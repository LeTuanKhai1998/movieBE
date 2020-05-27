package com.example.movieBE.service.admin;

import com.example.movieBE.dto.ActorDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.response.Pagination;

public interface ActorService {

    ResponseTemplate getAllActors(Pagination pagination);

    ResponseTemplate getActor();

    ResponseTemplate deleteActorById(Long id);

    ResponseTemplate updateActor(ActorDto form);
}
