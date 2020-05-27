package com.example.movieBE.form;

import com.example.movieBE.response.Pagination;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchForm {

    private String keyWord;

    private Long country_id;

    private Long genre_id;

    private Integer release_year;

    private Pagination pagination;

}
