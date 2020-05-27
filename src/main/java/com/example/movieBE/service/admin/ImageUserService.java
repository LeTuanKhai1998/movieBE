package com.example.movieBE.service.admin;

import com.example.movieBE.dto.ImageUserDto;
import com.example.movieBE.dto.ResponseTemplate;

public interface ImageUserService {
    ResponseTemplate updateImageUser(ImageUserDto form);
}
