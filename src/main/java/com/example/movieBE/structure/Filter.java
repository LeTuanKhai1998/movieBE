package com.example.movieBE.structure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Filter {

    private Long country_id;

    private Integer release_year;

    private Long genre_id;
}
