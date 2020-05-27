package com.example.movieBE.service.admin;

import com.example.movieBE.dto.DirectorDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.response.Pagination;

public interface DirectorService {
    ResponseTemplate getAllDirectors(Pagination pagination);

    ResponseTemplate getDirector();

    ResponseTemplate updateDirector(DirectorDto form);

    ResponseTemplate deleteDirectorById(Long id);
}
