package com.example.movieBE.service.impl.admin;

import com.example.movieBE.converter.GenreConverter;
import com.example.movieBE.converter.MovieConverter;
import com.example.movieBE.dto.GenreDto;
import com.example.movieBE.dto.MovieDto;
import com.example.movieBE.entity.GenreEntity;
import com.example.movieBE.entity.MovieEntity;
import com.example.movieBE.repository.GenreRepository;
import com.example.movieBE.repository.MovieRepository;
import com.example.movieBE.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    /**
     *
     */
    @Autowired
    private MovieRepository movieRepository;

    /**
     *
     */
    @Autowired
    private GenreRepository genreRepository;

    /**
     *
     */
    @Autowired
    private MovieConverter movieConverter;

    /**
     *
     */
    @Autowired
    private GenreConverter genreConverter;

    /**
     *
     * @return
     */
    @Override
    public String deleteGenre(Long id) {
        try {
            genreRepository.deleteById(id);
        }catch (Exception e){
            return e.getMessage();
        }
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<MovieDto> getMovie() {
        List<MovieEntity> entityList = movieRepository.findAll();
        return movieConverter.toDTO(entityList);
    }

    /**
     * @return
     */
    @Override
    public List<GenreDto> getGenre() {
        List<GenreEntity> entityList = genreRepository.findAll();
        return genreConverter.toDTO(entityList);
    }
}
