package com.example.movieBE.service.impl.admin;

import com.example.movieBE.ScreenCoverter.MovieItemConverter;
import com.example.movieBE.ScreenDto.MovieItemDto;
import com.example.movieBE.converter.*;
import com.example.movieBE.dto.*;
import com.example.movieBE.entity.*;
import com.example.movieBE.form.DateForm;
import com.example.movieBE.form.MovieByGenreForm;
import com.example.movieBE.form.UpdateMovieForm;
import com.example.movieBE.repository.*;
import com.example.movieBE.response.Pagination;
import com.example.movieBE.service.admin.ImageService;
import com.example.movieBE.service.admin.MovieService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private CountryConverter countryConverter;

    @Autowired
    private GenreConverter genreConverter;

    @Autowired
    private ImageConverter imageConverter;

    @Autowired
    private ActorConverter actorConverter;

    @Autowired
    private DirectorConverter directorConverter;

    @Autowired
    private MovieConverter movieConverter;

    @Autowired
    private MovieItemConverter movieItemConverter;

    @Autowired
    private ImageService imageService;

    @Override
    public ResponseTemplate getMovie(Pagination pagination) {
        ResponseTemplate response = new ResponseTemplate();
        if (ObjectUtils.allNotNull(pagination)) {

            Page<MovieEntity> list = movieRepository.findAll(PageRequest.of(pagination.getCurrentPage() - 1,
                    pagination.getItemsPerPage(),
                    pagination.getSortOrder() ? Sort.Direction.ASC : Sort.Direction.DESC,
                    pagination.getSort()));
            response.setData("total", list.getTotalElements());
            List<MovieDto> dtos = new ArrayList<>();

            MovieDto item;
            if (ObjectUtils.allNotNull(list, list.getContent())) {
                for (MovieEntity movieEntity : list.getContent()) {
                    if (ObjectUtils.allNotNull(movieEntity)) {
                        item = getFullMovie(movieEntity);
                        dtos.add(item);
                    }
                }
                response.setData("data", dtos);
            }
        }
        return response;
    }

    @Override
    public ResponseTemplate getMovieById(Long id) {
        ResponseTemplate response = new ResponseTemplate();
        if (!ObjectUtils.allNotNull(id)) {
            return response;
        }
        Optional<MovieEntity> entity = movieRepository.findById(id);

        if (ObjectUtils.allNotNull(entity) && entity.isPresent()) {
            MovieDto movieDto = getFullMovie(entity.get());
            response.setData("data", movieDto);
        }
        return response;
    }

    @Override
    public ResponseTemplate MovieBySlug(String slug) {
        ResponseTemplate response = new ResponseTemplate();
        Optional<MovieEntity> movies = movieRepository.getMovieBySlug(slug);
        if (ObjectUtils.allNotNull(movies) && movies.isPresent()) {
            MovieDto movieDto = getFullMovie(movies.get());
            response.setData("data", movieDto);
        }
        return response;
    }


    @Override
    public ResponseTemplate getTopViewByTime(DateForm form) {
        ResponseTemplate response = new ResponseTemplate();

        List<MovieEntity> list = movieRepository.getTopViewByTime(form.getDateIn(), form.getDateOut());

        response.setData("data", movieConverter.toDTO(list));

        return response;
    }

    @Override
    public ResponseTemplate getMovieByGenreSlug(MovieByGenreForm form) {
        ResponseTemplate response = new ResponseTemplate();
        if (ObjectUtils.allNotNull(form, form.getSlug(), form.getPagination())) {
            Page<MovieEntity> list = movieRepository.getMovieByGenreSlug(form.getSlug(), PageRequest.of(form.getPagination().getCurrentPage(), form.getPagination().getItemsPerPage()));
            List<MovieItemDto> dtos = new ArrayList<>();
            MovieItemDto item;
            if (ObjectUtils.allNotNull(list, list.getContent())) {
                for (MovieEntity movieEntity : list.getContent()) {
                    if (ObjectUtils.allNotNull(movieEntity)) {
                        item = getMovieItem(movieEntity);
                        dtos.add(item);
                    }
                }
                response.setData("data", dtos);
                response.setData("TotalPages", list.getTotalPages());
            }
        }
        return response;
    }

    @Override
    public MovieDto getFullMovie(MovieEntity movie) {
        if (Objects.isNull(movie)) {
            return null;
        }
        MovieDto movieDto;
        List<ActorEntity> actor;
        List<DirectorEntity> director;
        List<GenreEntity> genre;
        Optional<ImageEntity> image;
        Optional<CountryEntity> country;

        movieDto = movieConverter.toDTO(movie);
        // get banner
        image = imageRepository.findById(movie.getBanner_id());
        if (ObjectUtils.allNotNull(image) && image.isPresent()) {
            movieDto.setBanner(imageConverter.toDTO(image.get()));
        }
        // get image
        image = imageRepository.findById(movie.getImage_id());
        if (ObjectUtils.allNotNull(image) && image.isPresent()) {
            movieDto.setImage(imageConverter.toDTO(image.get()));
        }
        country = countryRepository.findById(movie.getCountry_id());
        if (ObjectUtils.allNotNull(country) && country.isPresent()) {
            movieDto.setCountry(countryConverter.toDTO(country.get()));
        }

        actor = actorRepository.getActorHasMovie(movie.getId());
        if (ObjectUtils.allNotNull(actor)) {
            movieDto.setActors(actorConverter.toDTO(actor));
        }
        director = directorRepository.getDirectorHasMovie(movie.getId());
        if (ObjectUtils.allNotNull(director)) {
            movieDto.setDirectors(directorConverter.toDTO(director));
        }
        genre = genreRepository.getGenreHasMovie(movie.getId());
        if (ObjectUtils.allNotNull(genre)) {
            movieDto.setGenres(genreConverter.toDTO(genre));
        }
        return movieDto;
    }

    @Override
    public MovieItemDto getMovieItem(MovieEntity movie) {
        if (Objects.isNull(movie)) {
            return null;
        }
        MovieItemDto movieDto;
        Optional<ImageEntity> image;

        movieDto = movieItemConverter.toDTO(movie);
        // get banner
        image = imageRepository.findById(movie.getBanner_id());
        if (ObjectUtils.allNotNull(image) && image.isPresent()) {
            movieDto.setBanner(imageConverter.toDTO(image.get()));
        }
        // get image
        image = imageRepository.findById(movie.getImage_id());
        if (ObjectUtils.allNotNull(image) && image.isPresent()) {
            movieDto.setImage(imageConverter.toDTO(image.get()));
        }
        return movieDto;
    }

    @Transactional(readOnly = false)
    @Override
    public ResponseTemplate updateMovie(UpdateMovieForm form) {
        ResponseTemplate response = new ResponseTemplate();
        response.setData("data", "fail");
        if (ObjectUtils.allNotNull(form, form.getMovie())) {
            MovieDto movieDto = form.getMovie();
            MovieEntity movieUpdate = new MovieEntity();
            Long movieId = movieDto.getId();
            if (movieId != 0) {
                movieUpdate = movieRepository.getOne(movieId);
            } else {
                movieUpdate.setId(movieId);
            }
            if (!ObjectUtils.allNotNull(movieUpdate)) {
                movieUpdate = new MovieEntity();
            }
            movieUpdate.setName(movieDto.getName());
            movieUpdate.setSlug(movieDto.getSlug());
            movieUpdate.setDescription(movieDto.getDescription());
            movieUpdate.setRelease_year(movieDto.getRelease_year());
            movieUpdate.setNum_view(movieDto.getNum_view());
            movieUpdate.setRun_time(movieDto.getRun_time());
            movieUpdate.setRate(movieDto.getRate());
            movieUpdate.setNum_rate(movieDto.getNum_rate());
            movieUpdate.setRelease_year(movieDto.getRelease_year());

            if (ObjectUtils.allNotNull(movieDto.getCountry())) {
                movieUpdate.setCountry_id(movieDto.getCountry().getId());
            }
            // set image
            if (movieDto.getImage().getId() == 0) {
                ImageEntity imageEntity = (ImageEntity) imageService.updateImage(movieDto.getImage()).getData("image");
                movieUpdate.setImage_id(imageEntity.getId());
            } else if (ObjectUtils.allNotNull(movieDto.getImage())) {
                movieUpdate.setImage_id(movieDto.getImage().getId());
            }
            // set banner
            if (movieDto.getBanner().getId() == 0) {
                ImageEntity imageEntity = (ImageEntity) imageService.updateImage(movieDto.getBanner()).getData("image");
                movieUpdate.setBanner_id(imageEntity.getId());
            } else if (ObjectUtils.allNotNull(movieDto.getBanner())) {
                movieUpdate.setBanner_id(movieDto.getBanner().getId());
            }
            MovieEntity movieEntity = movieRepository.save(movieUpdate);
            if (ObjectUtils.allNotNull(movieEntity)) {
                movieId = movieEntity.getId();
            }
            if (movieId != 0) {
                actorRepository.deleteActorHasMovie(movieId);
                directorRepository.deleteDirectorHasMovie(movieId);
                genreRepository.deleteGenreHasMovie(movieId);
                if (form.isUpdateActor() && ObjectUtils.allNotNull(form.getMovie().getActors())) {
                    for (ActorDto actor : form.getMovie().getActors()) {
                        actorRepository.saveActorHasMovie(movieId, actor.getId());
                    }
                }
                if (form.isUpdateDirector() && ObjectUtils.allNotNull(form.getMovie().getDirectors())) {
                    for (DirectorDto director : form.getMovie().getDirectors()) {
                        directorRepository.saveDirectorHasMovie(movieId, director.getId());
                    }
                }
                if (form.isUpdateGenre() && ObjectUtils.allNotNull(form.getMovie().getGenres())) {
                    for (GenreDto genre : form.getMovie().getGenres()) {
                        genreRepository.saveGenreHasMovie(movieId, genre.getId());
                    }
                }
            }
            response.setData("data", "successful");
        }
        return response;
    }

    @Transactional(readOnly = false)
    @Override
    public ResponseTemplate deleteMovieById(Long id) {
        ResponseTemplate response = new ResponseTemplate();
        response.setData("data", "fail");
        if (ObjectUtils.allNotNull(id) && id != 0) {
            MovieEntity movieEntity = movieRepository.getOne(id);
            actorRepository.deleteActorHasMovie(id);
            directorRepository.deleteDirectorHasMovie(id);
            genreRepository.deleteGenreHasMovie(id);
            movieRepository.deleteById(id);
            if (ObjectUtils.allNotNull(movieEntity)) {
                imageRepository.deleteById(movieEntity.getImage_id());
                imageRepository.deleteById(movieEntity.getBanner_id());
            }
            response.setData("data", "successful");
        }
        return response;
    }
}
