package com.example.movieBE.controller.admin;

import com.example.movieBE.converter.MovieConverter;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.form.DateForm;
import com.example.movieBE.form.MovieByGenreForm;
import com.example.movieBE.form.UpdateMovieForm;
import com.example.movieBE.response.Pagination;
import com.example.movieBE.service.admin.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/admin")
public class MovieController {
    /**
     *
     */
    public static Logger logger = LoggerFactory.getLogger(MovieConverter.class);


    @Autowired
    private MovieService movieService;

    /**
     * get list movie
     *
     * @return
     */
    @RequestMapping(value = "/Movies", method = RequestMethod.POST)
    public ResponseTemplate getMovie(@RequestBody Pagination pagination) {
        ResponseTemplate response = null;
        try {
            response = movieService.getMovie(pagination);

        } catch (Exception e) {
            logger.error("getUser", e.getMessage());
            throw e;
        }
        return response;
    }

    /**
     * get Movie by Id
     *
     * @return
     */
    @RequestMapping(value = "/MovieById", method = RequestMethod.GET)
    public ResponseTemplate getMovieById(@RequestParam Long id) {
        ResponseTemplate response = null;
        try {
            response = movieService.getMovieById(id);

        } catch (Exception e) {
            logger.error("getMovieById", e.getMessage());
            throw e;
        }
        return response;
    }

    /**
     * get Movie by Id
     *
     * @return
     */
    @RequestMapping(value = "/MovieBySlug", method = RequestMethod.GET)
    public ResponseTemplate getMovieBySlug(@RequestParam String slug) {
        ResponseTemplate response = null;
        try {
            response = movieService.MovieBySlug(slug);

        } catch (Exception e) {
            logger.error("MovieBySlug", e.getMessage());
            throw e;
        }
        return response;
    }

    @RequestMapping(value = "/UpdateMovies", method = RequestMethod.POST)
    public ResponseTemplate updateMovie(@RequestBody UpdateMovieForm form) {
        ResponseTemplate response = null;
        try {
            response = movieService.updateMovie(form);
        } catch (Exception e) {
            logger.error("updateMovie", e.getMessage());
            throw e;
        }
        return response;
    }

    @RequestMapping(value = "/DeleteMovieById", method = RequestMethod.GET)
    public ResponseTemplate deletedMovieById(@RequestParam Long id) {
        ResponseTemplate response = null;
        try  {
            response = movieService.deleteMovieById(id);
        } catch (Exception e) {
            logger.error("deleteMovieById", e.getMessage());
            throw e;
        }
        return response;
    }

    /**
     * get Top View By Time
     *
     * @return
     */
    @RequestMapping(value = "/TopViewByTime", method = RequestMethod.POST)
    public ResponseTemplate getTopViewByTime(@RequestBody DateForm form) {
        ResponseTemplate response = null;
        try {
            response = movieService.getTopViewByTime(form);

        } catch (Exception e) {
            logger.error("getTopViewByTime", e.getMessage());
            throw e;
        }
        return response;
    }

    /**
     * get Movie by Genre slug
     *
     * @return
     */
    @RequestMapping(value = "/MovieByGenreSlug", method = RequestMethod.POST)
    public ResponseTemplate getMovieByGenreSlug(@RequestBody MovieByGenreForm form) {
        ResponseTemplate response = null;
        try {
            response = movieService.getMovieByGenreSlug(form);

        } catch (Exception e) {
            logger.error("getMovieByGenreSlug", e.getMessage());
            throw e;
        }
        return response;
    }
}
