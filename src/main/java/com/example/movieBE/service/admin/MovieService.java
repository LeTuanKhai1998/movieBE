package com.example.movieBE.service.admin;

import com.example.movieBE.ScreenDto.MovieItemDto;
import com.example.movieBE.dto.MovieDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.entity.MovieEntity;
import com.example.movieBE.form.DateForm;
import com.example.movieBE.form.MovieByGenreForm;
import com.example.movieBE.form.UpdateMovieForm;
import com.example.movieBE.response.Pagination;

public interface MovieService {
    ResponseTemplate getMovie(Pagination pagination);

    ResponseTemplate getMovieById(Long id);

    ResponseTemplate MovieBySlug(String slug);

    ResponseTemplate updateMovie(UpdateMovieForm form);

    ResponseTemplate getTopViewByTime(DateForm form);

    ResponseTemplate getMovieByGenreSlug(MovieByGenreForm form);

    MovieItemDto getMovieItem(MovieEntity movie);

    public MovieDto getFullMovie(MovieEntity movie);

    ResponseTemplate deleteMovieById(Long id);
}
