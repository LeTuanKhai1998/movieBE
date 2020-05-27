package com.example.movieBE.controller.admin;

import com.example.movieBE.dto.CountryDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.response.Pagination;
import com.example.movieBE.service.admin.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/admin")
public class GenreController {
    /**
     *
     */
    public static Logger logger = LoggerFactory.getLogger(GenreController.class);

    @Autowired
    private GenreService genreService;
    /**
     * get list actor
     *
     * @return
     */
    @RequestMapping(value = "/AllGenres", method = RequestMethod.POST)
    public ResponseTemplate getAllGenres(@RequestBody Pagination pagination) {
        ResponseTemplate response = null;
        try {
            response = genreService.getAllGenres(pagination);

        } catch (Exception e) {
            logger.error("getAllGenres", e.getMessage());
            throw e;
        }
        return response;
    }

    /**
     * get Genres
     *
     * @return
     */
    @RequestMapping(value = "/Genres", method = RequestMethod.GET)
    public ResponseTemplate getGenre() {
        ResponseTemplate response = null;
        try {
            response = genreService.getGenre();
        } catch (Exception e) {
            logger.error("getGenre", e.getMessage());
            throw e;
        }
        return response;
    }

    /**
     * get genre
     *
     * @return
     */
    @RequestMapping(value = "/GenreBanner", method = RequestMethod.GET)
    public ResponseTemplate getGenres() {
        ResponseTemplate response = null;
        try {
            response = genreService.getGenres();
        } catch (Exception e) {
            logger.error("getGenres", e.getMessage());
            throw e;
        }
        return response;
    }

    @RequestMapping(value = "/UpdateGenre", method = RequestMethod.POST)
    public ResponseTemplate updateGenre(@RequestBody CountryDto form) {
        ResponseTemplate response = null;
        try {
            response = genreService.updateGenre(form);
        } catch (Exception e) {
            logger.error("UpdateGenre", e.getMessage());
            throw e;
        }
        return response;
    }

    @RequestMapping(value = "/DeleteGenreById", method = RequestMethod.GET)
    public ResponseTemplate deleteGenreById(@RequestParam Long id) {
        ResponseTemplate response = null;
        try  {
            response = genreService.deleteGenreById(id);
        } catch (Exception e) {
            logger.error("deleteCountryById", e.getMessage());
            throw e;
        }
        return response;
    }
}
