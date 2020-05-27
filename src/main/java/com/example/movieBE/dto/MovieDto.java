package com.example.movieBE.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private Long id;

    private String name;

    private String slug;

    private String description;

    private Integer release_year;

    private Long num_view;

    private Integer run_time;

    private Float rate;

    private Long num_rate;

    private CountryDto country;

    private ImageDto image;

    private ImageDto banner;

    private List<GenreDto> genres;

    private List<ActorDto> actors;

    private List<DirectorDto> directors;
}
