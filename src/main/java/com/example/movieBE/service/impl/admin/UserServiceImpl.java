package com.example.movieBE.service.impl.admin;

import com.example.movieBE.dto.*;
import com.example.movieBE.entity.ImageUserEntity;
import com.example.movieBE.entity.UserEntity;
import com.example.movieBE.repository.UserRepository;
import com.example.movieBE.service.admin.ImageUserService;
import com.example.movieBE.service.admin.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    /**
     *
     */
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImageUserService imageUserService;

    /**
     * @return
     */
    @Override
    public ResponseTemplate getUser() {
        ResponseTemplate response = new ResponseTemplate();
        List<UserDto> userDtoList = userRepository.getAll();
        response.setData("data", userDtoList);
        return response;
    }

    //    @Transactional(readOnly = false)
    @Override
    public ResponseTemplate updateUser(UserDto form) {
        ResponseTemplate response = new ResponseTemplate();
        response.setData("data", "fail");
        if (ObjectUtils.allNotNull(form)) {
            UserEntity userUpdate = new UserEntity();
            if (form.getId() != 0) {
                userUpdate = userRepository.getOne(form.getId());
            } else {
                userUpdate.setId(form.getId());
                userUpdate.setPassword(form.getPassword());
            }
            if (!ObjectUtils.allNotNull(userUpdate)) {
                userUpdate = new UserEntity();
            }

            userUpdate.setEmail(form.getEmail());
            userUpdate.setFirstname(form.getFirstname());
            userUpdate.setLastname(form.getLastname());
            userUpdate.setUsername(form.getUsername());
            if (form.getAvatar().getId() == 0) {
                ImageUserEntity imageUserEntity = (ImageUserEntity) imageUserService.updateImageUser(form.getAvatar()).getData("image");
                userUpdate.setAvatar_id(imageUserEntity.getId());
            } else if (ObjectUtils.allNotNull(form.getAvatar())) {
                userUpdate.setAvatar_id(form.getAvatar().getId());
            }
            if (ObjectUtils.allNotNull(form.getRole())) {
                userUpdate.setUser_role_id(form.getRole().getId());
            }
            if (ObjectUtils.allNotNull(form.getCountry())) {
                userUpdate.setCountry_id(form.getCountry().getId());
            }
            userRepository.save(userUpdate);
            response.setData("data", "successful");
        }
        return response;
    }

    @Override
    public ResponseTemplate deleteUserById(Long idUser) {
        ResponseTemplate response = new ResponseTemplate();
        response.setData("data", "fail");
        if (ObjectUtils.allNotNull(idUser) && idUser != 0) {
            userRepository.deleteById(idUser);
            response.setData("data", "successful");
        }
        return response;
    }


}