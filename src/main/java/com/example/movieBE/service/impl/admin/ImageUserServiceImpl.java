package com.example.movieBE.service.impl.admin;

import com.example.movieBE.dto.ImageUserDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.entity.ImageUserEntity;
import com.example.movieBE.repository.ImageUserRepository;
import com.example.movieBE.service.admin.ImageUserService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImageUserServiceImpl implements ImageUserService {

    @Autowired
    private ImageUserRepository imageUserRepository;


    @Override
    public ResponseTemplate updateImageUser(ImageUserDto form) {
        ResponseTemplate response = new ResponseTemplate();
        response.setData("data", "fail");
        if (ObjectUtils.allNotNull(form)) {
            ImageUserEntity imageUserUpdate = new ImageUserEntity();
            if (form.getId() != 0) {
                imageUserUpdate = imageUserRepository.getOne(form.getId());
            }
            if (!ObjectUtils.allNotNull(imageUserUpdate)) {
                imageUserUpdate = new ImageUserEntity();
            }
            imageUserUpdate.setUrl(form.getUrl());
            imageUserUpdate.setAlt(form.getAlt());
            ImageUserEntity imageUserEntity = imageUserRepository.save(imageUserUpdate);
            response.setData("image", imageUserEntity);
            response.setData("data", "successful");
        }
        return response;
    }
}
