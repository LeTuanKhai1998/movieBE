package com.example.movieBE.controller.admin;

import com.example.movieBE.dto.ImageUserDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.service.admin.ImageUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/admin")
public class ImageUserController {

    public static Logger logger = LoggerFactory.getLogger(ImageUserController.class);

    @Autowired
    private ImageUserService imageUserService;

    @RequestMapping(value = "/UpdateImageUser", method = RequestMethod.POST)
    public ResponseTemplate updateImageUser(@RequestBody ImageUserDto form) {
        ResponseTemplate response = null;
        try {
            response = imageUserService.updateImageUser(form);
        } catch (Exception e) {
            logger.error("UpdateImageUser", e.getMessage());
            throw e;
        }
        return response;
    }
}
