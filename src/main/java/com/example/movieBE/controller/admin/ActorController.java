package com.example.movieBE.controller.admin;

import com.example.movieBE.dto.ActorDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.response.Pagination;
import com.example.movieBE.service.admin.ActorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/admin")
public class ActorController {

      /**
     *
     */
    public static Logger logger = LoggerFactory.getLogger(ActorController.class);

    @Autowired
    private ActorService actorService;
    /**
     * get list actor
     *
     * @return
     */
    @RequestMapping(value = "/AllActors", method = RequestMethod.POST)
    public ResponseTemplate getAllActors(@RequestBody Pagination pagination) {
        ResponseTemplate response = null;
        try {
            response = actorService.getAllActors(pagination);

        } catch (Exception e) {
            logger.error("getAllActors", e.getMessage());
            throw e;
        }
        return response;
    }

    /**
     * get Actors
     *
     * @return
     */
    @RequestMapping(value = "/Actors", method = RequestMethod.GET)
    public ResponseTemplate getActor() {
        ResponseTemplate response = null;
        try {
            response = actorService.getActor();
        } catch (Exception e) {
            logger.error("getActor", e.getMessage());
            throw e;
        }
        return response;
    }

    @RequestMapping(value = "/UpdateActor", method = RequestMethod.POST)
    public ResponseTemplate updateActor(@RequestBody ActorDto form) {
        ResponseTemplate response = null;
        try {
            response = actorService.updateActor(form);
        } catch (Exception e) {
            logger.error("UpdateActor", e.getMessage());
            throw e;
        }
        return response;
    }

    @RequestMapping(value = "/DeleteActorById", method = RequestMethod.GET)
    public ResponseTemplate deleteActorById(@RequestParam Long id) {
        ResponseTemplate response = null;
        try  {
            response = actorService.deleteActorById(id);
        } catch (Exception e) {
            logger.error("deleteActorById", e.getMessage());
            throw e;
        }
        return response;
    }

}
