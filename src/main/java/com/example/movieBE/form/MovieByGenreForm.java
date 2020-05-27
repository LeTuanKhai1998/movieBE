package com.example.movieBE.form;

import com.example.movieBE.response.Pagination;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieByGenreForm {
    String slug;
    Pagination pagination;
}
