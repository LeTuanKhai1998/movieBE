package com.example.movieBE.service.admin;

import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.form.CommentForm;
import com.example.movieBE.form.CommentPostForm;

public interface CommentSercive {
    ResponseTemplate postComment(CommentPostForm form);

    ResponseTemplate getCommentByMovieId(CommentForm form);
}
