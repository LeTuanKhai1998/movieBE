package com.example.movieBE.controller.admin;

import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.service.admin.PermissionTabService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/admin")
public class PermissionTabController {

    /**
     *
     */
    public static Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private PermissionTabService permissionTabService;
    /**
     * get country
     *
     * @return
     */
    @RequestMapping(value = "/PermissionTab", method = RequestMethod.GET)
    public ResponseTemplate getPermissionTab() {
        ResponseTemplate response = null;
        try {
            response = permissionTabService.getPermissionTab();
        } catch (Exception e) {
            logger.error("getPermissionTab", e.getMessage());
            throw e;
        }
        return response;
    }
}
