package com.example.movieBE.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageUserDto {

    private Long id;

    private String url;

    private String alt;

}
