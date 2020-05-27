package com.example.movieBE.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentPostForm {

    private  Long movie_id;

    private  Long user_id;

    private String description;
}
