package com.example.movieBE.service.admin;

import com.example.movieBE.dto.ImageUserDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.entity.ImageUserEntity;

public interface ImageUserService {
    ResponseTemplate updateImageUser(ImageUserDto form);

    ImageUserEntity getOne(Long id);
}
