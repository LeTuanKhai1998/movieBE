package com.example.movieBE.service.impl.admin;

import com.example.movieBE.converter.CountryConverter;
import com.example.movieBE.dto.CountryDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.entity.CountryEntity;
import com.example.movieBE.repository.CountryRepository;
import com.example.movieBE.response.Pagination;
import com.example.movieBE.service.admin.CountryService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryConverter countryConverter;

    @Override
    public ResponseTemplate getAllCountrys(Pagination pagination) {
        ResponseTemplate response = new ResponseTemplate();
        if (ObjectUtils.allNotNull(pagination)) {

            Page<CountryEntity> list = countryRepository.findAll(PageRequest.of(pagination.getCurrentPage() - 1,
                    pagination.getItemsPerPage(),
                    pagination.getSortOrder() ? Sort.Direction.ASC : Sort.Direction.DESC,
                    pagination.getSort()));
            response.setData("total", list.getTotalElements());
            List<CountryDto> dtos = new ArrayList<>();

            if (ObjectUtils.allNotNull(list, list.getContent())) {
                for (CountryEntity countryEntity : list.getContent()) {
                    if (ObjectUtils.allNotNull(countryEntity)) {
                        dtos.add(countryConverter.toDTO(countryEntity));
                    }
                }
                response.setData("data", dtos);
            }
        }
        return response;
    }

    @Override
    public ResponseTemplate getCountry() {
        ResponseTemplate response = new ResponseTemplate();
        List<CountryEntity> list = countryRepository.findAll();
        response.setData("data", countryConverter.toDTO(list));
        return response;
    }

    @Override
    public ResponseTemplate getCountryBanner() {
        ResponseTemplate response = new ResponseTemplate();

        List<CountryEntity> list = countryRepository.findAll();
        List<CountryDto> dtoList = new ArrayList<>();

        list.forEach(country -> {
            dtoList.add(countryConverter.toDTO(country));
        });

        List<Object> finalList = new ArrayList<>();

        if (ObjectUtils.allNotNull(dtoList)) {
            int numPerItem = dtoList.size() % 3 > 0 ? dtoList.size() / 3 + 1 : dtoList.size() / 3;

            for (int i = 0; i < dtoList.size(); i += numPerItem) {
                finalList.add(dtoList.subList(i, Math.min(dtoList.size(), i + numPerItem)));
            }
            response.setData("data", finalList);
        }
        return response;
    }

    @Override
    public ResponseTemplate updateCountry(CountryDto form) {
        ResponseTemplate response = new ResponseTemplate();
        response.setData("data", "fail");
        if (ObjectUtils.allNotNull(form)) {
            CountryEntity countryUpdate = new CountryEntity();
            if (form.getId() != 0) {
                countryUpdate = countryRepository.getOne(form.getId());
            } else {
                countryUpdate.setId(form.getId());
            }
            if (!ObjectUtils.allNotNull(countryUpdate)) {
                countryUpdate = new CountryEntity();
            }
            countryUpdate.setName(form.getName());
            countryRepository.save(countryUpdate);
            response.setData("data", "successful");
        }
        return response;
    }

    @Override
    public ResponseTemplate deleteCountryById(Long id) {
        ResponseTemplate response = new ResponseTemplate();
        response.setData("data", "fail");
        if (ObjectUtils.allNotNull(id) && id != 0) {
            countryRepository.deleteById(id);
            response.setData("data", "successful");
        }
        return response;
    }
}
