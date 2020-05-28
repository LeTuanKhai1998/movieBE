package com.example.movieBE.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/admin")
public class DashboardController {
    /**
     *
     */
    public static Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @GetMapping(path = "/Secured")
    public @ResponseBody
    String getSecured() {
        logger.info("GET successfully called on /secured resource");
        return "SECURED_TEXT";
    }
}
