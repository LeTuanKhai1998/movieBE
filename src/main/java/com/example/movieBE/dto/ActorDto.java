package com.example.movieBE.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto {

    private Long id;

    private String name;

    private String description;

    private Instant birthday;

}
