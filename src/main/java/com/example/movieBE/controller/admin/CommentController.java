package com.example.movieBE.controller.admin;

import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.form.CommentForm;
import com.example.movieBE.form.CommentPostForm;
import com.example.movieBE.service.admin.CommentSercive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/admin")
public class CommentController {

    /**
     *
     */
    public static Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentSercive commentSercive;

    /**
     * get Comment By MovieId
     *
     * @return
     */
    @RequestMapping(value = "/PostComment", method = RequestMethod.POST)
    public ResponseTemplate postComment(@RequestBody CommentPostForm form) {
        ResponseTemplate response = null;
        try {
            response = commentSercive.postComment(form);

        } catch (Exception e) {
            logger.error("getMovieByGenreSlug", e.getMessage());
            throw e;
        }
        return response;
    }

    /**
     * get Comment By MovieId
     *
     * @return
     */
    @RequestMapping(value = "/CommentByMovieId", method = RequestMethod.POST)
    public ResponseTemplate getCommentByMovieId(@RequestBody CommentForm form) {
        ResponseTemplate response = null;
        try {
            response = commentSercive.getCommentByMovieId(form);

        } catch (Exception e) {
            logger.error("getMovieByGenreSlug", e.getMessage());
            throw e;
        }
        return response;
    }


}
