package com.example.movieBE.form;

import com.example.movieBE.dto.MovieDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMovieForm {
    private MovieDto movie;
    private boolean isUpdateBanner;
    private boolean isUpdateImage;
    private boolean isUpdateGenre;
    private boolean isUpdateActor;
    private boolean isUpdateDirector;
}
