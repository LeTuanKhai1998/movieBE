package com.example.movieBE.ScreenDto;

import com.example.movieBE.dto.ImageDto;
import com.example.movieBE.util.NumberUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Tuple;
import java.math.BigInteger;
import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieItemDto {

    private Long id;

    private String name;

    private String slug;

    private String description;

    private Integer release_year;

    private Float rate;

    private ImageDto image;

    private ImageDto banner;


    public MovieItemDto(Tuple tuple) {
        this.id = Objects.nonNull((BigInteger) tuple.get("id")) ? NumberUtils.toLong((BigInteger) tuple.get("id")) : this.id;
        this.name = (String) tuple.get("name");
        this.slug = (String) tuple.get("slug");
        this.description = (String) tuple.get("description");
        this.release_year = Objects.nonNull((Integer) tuple.get("release_year")) ? (Integer) tuple.get("release_year") : this.release_year;
        this.rate = Objects.nonNull((Float) tuple.get("rate")) ? (Float) tuple.get("rate") : this.rate;
        Long id = Objects.nonNull((BigInteger) tuple.get("img_id")) ? NumberUtils.toLong((BigInteger) tuple.get("img_id")):0 ;
        String url = (String) tuple.get("img_url");
        String alt = (String) tuple.get("img_alt");
        this.image =  new ImageDto(id,url,alt);
        id = Objects.nonNull((BigInteger) tuple.get("banner_id")) ? NumberUtils.toLong((BigInteger) tuple.get("banner_id")):0 ;
        url = (String) tuple.get("banner_url");
        alt = (String) tuple.get("banner_alt");
        this.banner =  new ImageDto(id,url,alt);

    }

}
