package com.example.movieBE.service;

import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.form.SearchForm;

public interface HomeService {

    ResponseTemplate getMovie(String type);

    ResponseTemplate getMostPopularMovie(Integer totalNumber,Integer numPerItem);

    ResponseTemplate search(SearchForm form);

    ResponseTemplate getYear();
}
