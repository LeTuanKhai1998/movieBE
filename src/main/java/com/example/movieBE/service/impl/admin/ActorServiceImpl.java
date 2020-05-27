package com.example.movieBE.service.impl.admin;

import com.example.movieBE.converter.ActorConverter;
import com.example.movieBE.dto.ActorDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.entity.ActorEntity;
import com.example.movieBE.repository.ActorRepository;
import com.example.movieBE.response.Pagination;
import com.example.movieBE.service.admin.ActorService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ActorConverter actorConverter;

    @Override
    public ResponseTemplate getAllActors(Pagination pagination) {
        ResponseTemplate response = new ResponseTemplate();
        if (ObjectUtils.allNotNull(pagination)) {

            Page<ActorEntity> list = actorRepository.findAll(PageRequest.of(pagination.getCurrentPage() - 1,
                    pagination.getItemsPerPage(),
                    pagination.getSortOrder() ? Sort.Direction.ASC : Sort.Direction.DESC,
                    pagination.getSort()));
            response.setData("total", list.getTotalElements());
            List<ActorDto> dtos = new ArrayList<>();

            if (ObjectUtils.allNotNull(list, list.getContent())) {
                for (ActorEntity actorEntity : list.getContent()) {
                    if (ObjectUtils.allNotNull(actorEntity)) {
                        dtos.add(actorConverter.toDTO(actorEntity));
                    }
                }
                response.setData("data", dtos);
            }
        }
        return response;
    }

    @Override
    public ResponseTemplate getActor() {
        ResponseTemplate response = new ResponseTemplate();
        List<ActorEntity> list = actorRepository.findAll();
        response.setData("data", actorConverter.toDTO(list));
        return response;
    }

    @Override
    public ResponseTemplate deleteActorById(Long id) {
        ResponseTemplate response = new ResponseTemplate();
        response.setData("data", "fail");
        if (ObjectUtils.allNotNull(id) && id != 0) {
            actorRepository.deleteById(id);
            response.setData("data", "successful");
        }
        return response;
    }

    @Override
    public ResponseTemplate updateActor(ActorDto form) {
        ResponseTemplate response = new ResponseTemplate();
        response.setData("data", "fail");
        if (ObjectUtils.allNotNull(form)) {
            ActorEntity actorUpdate = new ActorEntity();
            if (form.getId() != 0) {
                actorUpdate = actorRepository.getOne(form.getId());
            } else {
                actorUpdate.setId(form.getId());
            }
            if (!ObjectUtils.allNotNull(actorUpdate)) {
                actorUpdate = new ActorEntity();
            }

            actorUpdate.setBirthday(form.getBirthday());
            actorUpdate.setDescription(form.getDescription());
            actorUpdate.setName(form.getName());
            actorRepository.save(actorUpdate);
            response.setData("data", "successful");
        }
        return response;
    }
}
