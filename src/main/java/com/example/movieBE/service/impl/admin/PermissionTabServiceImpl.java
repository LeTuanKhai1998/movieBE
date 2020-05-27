package com.example.movieBE.service.impl.admin;

import com.example.movieBE.converter.PermissionTabConverter;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.entity.PermissionTabEntity;
import com.example.movieBE.repository.PermissionTabRepository;
import com.example.movieBE.service.admin.PermissionTabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionTabServiceImpl implements PermissionTabService {

    @Autowired
    private PermissionTabRepository permissionTabRepository;

    @Autowired
    private PermissionTabConverter permissionTabConverter;

    @Override
    public ResponseTemplate getPermissionTab() {
        ResponseTemplate response = new ResponseTemplate();
        List<PermissionTabEntity> list = permissionTabRepository.findAll();
        response.setData("data", permissionTabConverter.toDTO(list));
        return response;
    }
}
