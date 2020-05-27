package com.example.movieBE.service.admin;

import com.example.movieBE.dto.GenreDto;
import com.example.movieBE.dto.MovieDto;

import java.util.List;

public interface AdminService {

    /**
     *
     * @return
     */
    List<MovieDto> getMovie();

    /**
     *
     * @return
     */
    List<GenreDto> getGenre();

    /**
     *
     * @return
     */
    String deleteGenre(Long id);
}
