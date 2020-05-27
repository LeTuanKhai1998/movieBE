package com.example.movieBE.controller.admin;

import com.example.movieBE.dto.CountryDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.response.Pagination;
import com.example.movieBE.service.admin.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/admin")
public class CountryController {
    /**
     *
     */
    public static Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;
    /**
     * get list actor
     *
     * @return
     */
    @RequestMapping(value = "/AllCountrys", method = RequestMethod.POST)
    public ResponseTemplate getAllCountrys(@RequestBody Pagination pagination) {
        ResponseTemplate response = null;
        try {
            response = countryService.getAllCountrys(pagination);

        } catch (Exception e) {
            logger.error("getAllCountrys", e.getMessage());
            throw e;
        }
        return response;
    }

    /**
     * get country
     *
     * @return
     */
    @RequestMapping(value = "/Countrys", method = RequestMethod.GET)
    public ResponseTemplate getCountry() {
        ResponseTemplate response = null;
        try {
            response = countryService.getCountry();
        } catch (Exception e) {
            logger.error("getCountry", e.getMessage());
            throw e;
        }
        return response;
    }

    /**
     * get country
     *
     * @return
     */
    @RequestMapping(value = "/CountrysBanner", method = RequestMethod.GET)
    public ResponseTemplate getCountryBanner() {
        ResponseTemplate response = null;
        try {
            response = countryService.getCountryBanner();
        } catch (Exception e) {
            logger.error("getCountryBanner", e.getMessage());
            throw e;
        }
        return response;
    }

    @RequestMapping(value = "/UpdateCountry", method = RequestMethod.POST)
    public ResponseTemplate updateCountry(@RequestBody CountryDto form) {
        ResponseTemplate response = null;
        try {
            response = countryService.updateCountry(form);
        } catch (Exception e) {
            logger.error("UpdateCountry", e.getMessage());
            throw e;
        }
        return response;
    }

    @RequestMapping(value = "/DeleteCountryById", method = RequestMethod.GET)
    public ResponseTemplate deleteCountryById(@RequestParam Long id) {
        ResponseTemplate response = null;
        try  {
            response = countryService.deleteCountryById(id);
        } catch (Exception e) {
            logger.error("deleteCountryById", e.getMessage());
            throw e;
        }
        return response;
    }
}
