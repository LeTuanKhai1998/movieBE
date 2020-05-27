package com.example.movieBE.service.admin;

import com.example.movieBE.dto.CountryDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.response.Pagination;

public interface CountryService {
    ResponseTemplate getAllCountrys(Pagination pagination);

    ResponseTemplate getCountry();

    ResponseTemplate getCountryBanner();

    ResponseTemplate updateCountry(CountryDto form);

    ResponseTemplate deleteCountryById(Long id);
}
