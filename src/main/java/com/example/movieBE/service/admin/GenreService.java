package com.example.movieBE.service.admin;

import com.example.movieBE.dto.CountryDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.response.Pagination;

public interface GenreService {
    ResponseTemplate getAllGenres(Pagination pagination);

    ResponseTemplate getGenre();

    ResponseTemplate getGenres();

    ResponseTemplate updateGenre(CountryDto form);

    ResponseTemplate deleteGenreById(Long id);
}
