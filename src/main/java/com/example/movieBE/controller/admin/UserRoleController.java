package com.example.movieBE.controller.admin;

import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.dto.UserRoleDto;
import com.example.movieBE.response.Pagination;
import com.example.movieBE.service.admin.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/admin")
public class UserRoleController {
    /**
     *
     */
    public static Logger logger = LoggerFactory.getLogger(UserRoleController.class);

    @Autowired
    private UserRoleService userRoleService;
    /**
     * get list user role
     *
     * @return
     */
    @RequestMapping(value = "/AllUserRoles", method = RequestMethod.POST)
    public ResponseTemplate getAllUserRoles(@RequestBody Pagination pagination) {
        ResponseTemplate response = null;
        try {
            response = userRoleService.getAllUserRoles(pagination);

        } catch (Exception e) {
            logger.error("getAllUserRoles", e.getMessage());
            throw e;
        }
        return response;
    }

    /**
     * get country
     *
     * @return
     */
    @RequestMapping(value = "/UserRoles", method = RequestMethod.GET)
    public ResponseTemplate getUserRole() {
        ResponseTemplate response = null;
        try {
            response = userRoleService.getUserRole();
        } catch (Exception e) {
            logger.error("getUserRole", e.getMessage());
            throw e;
        }
        return response;
    }

    @RequestMapping(value = "/UpdateUserRole", method = RequestMethod.POST)
    public ResponseTemplate updateUserRole(@RequestBody UserRoleDto form) {
        ResponseTemplate response = null;
        try {
            response = userRoleService.updateUserRole(form);
        } catch (Exception e) {
            logger.error("updateUserRole", e.getMessage());
            throw e;
        }
        return response;
    }

    @RequestMapping(value = "/DeleteUserRoleById", method = RequestMethod.GET)
    public ResponseTemplate deletedUserRoleById(@RequestParam Long id) {
        ResponseTemplate response = null;
        try  {
            response = userRoleService.deletedUserRoleById(id);
        } catch (Exception e) {
            logger.error("deletedUserRoleById", e.getMessage());
            throw e;
        }
        return response;
    }

}
