package com.example.movieBE.controller.admin;

import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.dto.UserDto;
import com.example.movieBE.service.admin.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/admin")
public class UserController {
    /**
     *
     */
    public static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    /**
     * get list user
     *
     * @return
     */
    @RequestMapping(value = "/Users", method = RequestMethod.POST)
    public ResponseTemplate getUser() {
        ResponseTemplate response = null;
        try {
            response = userService.getUser();

        } catch (Exception e) {
            logger.error("getUser", e.getMessage());
            throw e;
        }
        return response;
    }

    @RequestMapping(value = "/UpdateUser", method = RequestMethod.POST)
    public ResponseTemplate updateUser(@RequestBody UserDto form) {
        ResponseTemplate response = null;
        try {
            response = userService.updateUser(form);
        } catch (Exception e) {
            logger.error("updateUser", e.getMessage());
            throw e;
        }
        return response;
    }

    @RequestMapping(value = "/DeleteUserById", method = RequestMethod.GET)
    public ResponseTemplate deleteUserById(@RequestParam Long id) {
        ResponseTemplate response = null;
        try {
            response = userService.deleteUserById(id);
        } catch (Exception e) {
            logger.error("deleteUserById", e.getMessage());
            throw e;
        }
        return response;
    }

}
