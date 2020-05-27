package com.example.movieBE.controller.admin;

import com.example.movieBE.dto.DirectorDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.response.Pagination;
import com.example.movieBE.service.admin.DirectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/admin")
public class DirectorController {

    /**
     *
     */
    public static Logger logger = LoggerFactory.getLogger(DirectorController.class);

    @Autowired
    private DirectorService directorService;
    /**
     * get list actor
     *
     * @return
     */
    @RequestMapping(value = "/AllDirector", method = RequestMethod.POST)
    public ResponseTemplate getAllDirectors(@RequestBody Pagination pagination) {
        ResponseTemplate response = null;
        try {
            response = directorService.getAllDirectors(pagination);

        } catch (Exception e) {
            logger.error("getAllDirectors", e.getMessage());
            throw e;
        }
        return response;
    }

    /**
     * get Directors
     *
     * @return
     */
    @RequestMapping(value = "/Directors", method = RequestMethod.GET)
    public ResponseTemplate getDirector() {
        ResponseTemplate response = null;
        try {
            response = directorService.getDirector();
        } catch (Exception e) {
            logger.error("getDirector", e.getMessage());
            throw e;
        }
        return response;
    }

    @RequestMapping(value = "/UpdateDirector", method = RequestMethod.POST)
    public ResponseTemplate updateDirector(@RequestBody DirectorDto form) {
        ResponseTemplate response = null;
        try {
            response = directorService.updateDirector(form);
        } catch (Exception e) {
            logger.error("UpdateDirector", e.getMessage());
            throw e;
        }
        return response;
    }

    @RequestMapping(value = "/DeleteDirectorById", method = RequestMethod.GET)
    public ResponseTemplate deleteDirectorById(@RequestParam Long id) {
        ResponseTemplate response = null;
        try  {
            response = directorService.deleteDirectorById(id);
        } catch (Exception e) {
            logger.error("deleteDirectorById", e.getMessage());
            throw e;
        }
        return response;
    }
}
