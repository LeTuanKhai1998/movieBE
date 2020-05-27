package com.example.movieBE.service.impl.admin;

import com.example.movieBE.converter.DirectorConverter;
import com.example.movieBE.dto.DirectorDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.entity.DirectorEntity;
import com.example.movieBE.repository.DirectorRepository;
import com.example.movieBE.response.Pagination;
import com.example.movieBE.service.admin.DirectorService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private DirectorConverter directorConverter;

    @Override
    public ResponseTemplate getAllDirectors(Pagination pagination) {
        ResponseTemplate response = new ResponseTemplate();
        if (ObjectUtils.allNotNull(pagination)) {

            Page<DirectorEntity> list = directorRepository.findAll(PageRequest.of(pagination.getCurrentPage() - 1,
                    pagination.getItemsPerPage(),
                    pagination.getSortOrder() ? Sort.Direction.ASC : Sort.Direction.DESC,
                    pagination.getSort()));
            response.setData("total", list.getTotalElements());
            List<DirectorDto> dtos = new ArrayList<>();

            if (ObjectUtils.allNotNull(list, list.getContent())) {
                for (DirectorEntity directorEntity : list.getContent()) {
                    if (ObjectUtils.allNotNull(directorEntity)) {
                        dtos.add(directorConverter.toDTO(directorEntity));
                    }
                }
                response.setData("data", dtos);
            }
        }
        return response;
    }

    @Override
    public ResponseTemplate getDirector() {
        ResponseTemplate response = new ResponseTemplate();
        List<DirectorEntity> list = directorRepository.findAll();
        response.setData("data", directorConverter.toDTO(list));
        return response;
    }

    @Override
    public ResponseTemplate deleteDirectorById(Long id) {
        ResponseTemplate response = new ResponseTemplate();
        response.setData("data", "fail");
        if (ObjectUtils.allNotNull(id) && id != 0) {
            directorRepository.deleteById(id);
            response.setData("data", "successful");
        }
        return response;
    }

    @Override
    public ResponseTemplate updateDirector(DirectorDto form) {
        ResponseTemplate response = new ResponseTemplate();
        response.setData("data", "fail");
        if (ObjectUtils.allNotNull(form)) {
            DirectorEntity directorUpdate = new DirectorEntity();
            if (form.getId() != 0) {
                directorUpdate = directorRepository.getOne(form.getId());
            } else {
                directorUpdate.setId(form.getId());
            }
            if (!ObjectUtils.allNotNull(directorUpdate)) {
                directorUpdate = new DirectorEntity();
            }

            directorUpdate.setBirthday(form.getBirthday());
            directorUpdate.setDescription(form.getDescription());
            directorUpdate.setName(form.getName());
            directorRepository.save(directorUpdate);
            response.setData("data", "successful");
        }
        return response;
    }
}
