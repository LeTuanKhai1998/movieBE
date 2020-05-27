package com.example.movieBE.service.impl.admin;

import com.example.movieBE.dto.ImageDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.entity.ImageEntity;
import com.example.movieBE.repository.ImageRepository;
import com.example.movieBE.service.admin.ImageService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;


    @Override
    public ResponseTemplate updateImage(ImageDto form) {
        ResponseTemplate response = new ResponseTemplate();
        response.setData("data", "fail");
        if (ObjectUtils.allNotNull(form)) {
            ImageEntity imageUpdate = new ImageEntity();
            if (form.getId() != 0) {
                imageUpdate = imageRepository.getOne(form.getId());
            }
            if (!ObjectUtils.allNotNull(imageUpdate)) {
                imageUpdate = new ImageEntity();
            }
            imageUpdate.setUrl(form.getUrl());
            imageUpdate.setAlt(form.getAlt());
            ImageEntity imageEntity = imageRepository.save(imageUpdate);
            response.setData("image", imageEntity);
            response.setData("data", "successful");
        }
        return response;
    }
}
