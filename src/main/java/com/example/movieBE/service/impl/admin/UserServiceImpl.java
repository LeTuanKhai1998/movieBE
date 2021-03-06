package com.example.movieBE.service.impl.admin;

import com.example.movieBE.converter.PermissionTabConverter;
import com.example.movieBE.converter.UserConverter;
import com.example.movieBE.dto.*;
import com.example.movieBE.entity.ImageUserEntity;
import com.example.movieBE.entity.PermissionTabEntity;
import com.example.movieBE.entity.UserEntity;
import com.example.movieBE.entity.UserRoleEntity;
import com.example.movieBE.form.UpdatePasswordForm;
import com.example.movieBE.repository.PermissionTabRepository;
import com.example.movieBE.repository.UserRepository;
import com.example.movieBE.repository.UserRoleRepository;
import com.example.movieBE.service.admin.ImageUserService;
import com.example.movieBE.service.admin.UserService;
import com.example.movieBE.util.StringUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PermissionTabRepository permissionTabRepository;

    @Autowired
    private PermissionTabConverter permissionTabConverter;

    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


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
            }
            if (!ObjectUtils.allNotNull(userUpdate)) {
                userUpdate = new UserEntity();
            }
            userUpdate.setPassword(bCryptPasswordEncoder.encode(form.getPassword()));
            userUpdate.setEmail(form.getEmail());
            userUpdate.setFirstname(form.getFirstname());
            userUpdate.setLastname(form.getLastname());
            userUpdate.setUsername(form.getUsername());
//            if (form.getAvatar().getId() == 0) {
            ImageUserEntity imageUserEntity = (ImageUserEntity) imageUserService.updateImageUser(form.getAvatar()).getData("image");
            userUpdate.setAvatar_id(imageUserEntity.getId());
//            } else if (ObjectUtils.allNotNull(form.getAvatar())) {
//                ImageUserEntity imageUserCheck = imageUserService.getOne(form.getAvatar().getId());
//                if(imageUserService.equals(form.getAvatar())) {
//                    userUpdate.setAvatar_id(form.getAvatar().getId());
//                }else {
//
//                }
//            }
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

    @Override
    public ResponseTemplate getUserByUserName(String userName) {
        ResponseTemplate response = new ResponseTemplate();
        if (StringUtil.isNotBlank(userName)) {
            UserDto userDto = userRepository.getByUserName(userName);
            List<PermissionTabEntity> permissionTabEntities = permissionTabRepository.getPermissionHasUserRole(userDto.getRole().getId());
            userDto.getRole().setPermissionTabs(permissionTabConverter.toDTO(permissionTabEntities));
            response.setData("data", userDto);
        }
        return response;
    }

    @Override
    public ResponseTemplate updateUserPassword(UpdatePasswordForm form) {
        ResponseTemplate response = new ResponseTemplate();
        response.setData("data", "fail");
        if (ObjectUtils.allNotNull(form)) {
            UserEntity userUpdate = userRepository.findOneByUsername(form.getUsername());
            if (ObjectUtils.allNotNull(userUpdate)) {
//                String pass = passwordEncoder.encode(form.getNewPassword());
//                userUpdate.setPassword(passwordEncoder.encode(form.getNewPassword()));
                userUpdate.setPassword(form.getNewPassword());
            }
            userRepository.save(userUpdate);
            response.setData("data", "successful");
        }
        return response;
    }

    @Override
    public UserEntity findUserByUserName(String userName) {
        if (StringUtil.isNotBlank(userName)) {
            return userRepository.findOneByUsername(userName);
        }
        return null;
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Long id = userRoleRepository.findIdByRoleName("admin");
        user.setUser_role_id(id);
        return userRepository.save(user);
    }

    @Override
    public List<UserRoleEntity> findRole() {
        return userRoleRepository.findRole();
    }
}
