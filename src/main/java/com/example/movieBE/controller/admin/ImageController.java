package com.example.movieBE.controller.admin;

import com.example.movieBE.dto.ImageDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.service.admin.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/admin")
public class ImageController {
    public static Logger logger = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/UpdateImage", method = RequestMethod.POST)
    public ResponseTemplate updateImage(@RequestBody ImageDto form) {
        ResponseTemplate response = null;
        try {
            response = imageService.updateImage(form);
        } catch (Exception e) {
            logger.error("UpdateImage", e.getMessage());
            throw e;
        }
        return response;
    }
}
