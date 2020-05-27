package com.example.movieBE.service.admin;

import com.example.movieBE.dto.ImageDto;
import com.example.movieBE.dto.ResponseTemplate;

public interface ImageService {
    ResponseTemplate updateImage(ImageDto form);
}
