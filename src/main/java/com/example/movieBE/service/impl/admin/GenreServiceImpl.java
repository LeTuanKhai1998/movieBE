package com.example.movieBE.service.impl.admin;

import com.example.movieBE.converter.GenreConverter;
import com.example.movieBE.dto.CountryDto;
import com.example.movieBE.dto.GenreDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.entity.GenreEntity;
import com.example.movieBE.repository.GenreRepository;
import com.example.movieBE.response.Pagination;
import com.example.movieBE.service.admin.GenreService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {


    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private GenreConverter genreConverter;

    @Override
    public ResponseTemplate getAllGenres(Pagination pagination) {
        ResponseTemplate response = new ResponseTemplate();
        if (ObjectUtils.allNotNull(pagination)) {

            Page<GenreEntity> list = genreRepository.findAll(PageRequest.of(pagination.getCurrentPage() - 1,
                    pagination.getItemsPerPage(),
                    pagination.getSortOrder() ? Sort.Direction.ASC : Sort.Direction.DESC,
                    pagination.getSort()));
            response.setData("total", list.getTotalElements());
            List<GenreDto> dtos = new ArrayList<>();

            if (ObjectUtils.allNotNull(list, list.getContent())) {
                for (GenreEntity genreEntity : list.getContent()) {
                    if (ObjectUtils.allNotNull(genreEntity)) {
                        dtos.add(genreConverter.toDTO(genreEntity));
                    }
                }
                response.setData("data", dtos);
            }
        }
        return response;
    }

    @Override
    public ResponseTemplate getGenre() {
        ResponseTemplate response = new ResponseTemplate();
        List<GenreEntity> list = genreRepository.findAll();
        response.setData("data", genreConverter.toDTO(list));
        return response;
    }

    @Override
    public ResponseTemplate getGenres() {
        ResponseTemplate response = new ResponseTemplate();
        List<GenreEntity> list = genreRepository.findAll();
        List<GenreDto> dtoList = new ArrayList<>();
        list.forEach(genres -> {
            dtoList.add(genreConverter.toDTO(genres));
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
    public ResponseTemplate updateGenre(CountryDto form) {
        ResponseTemplate response = new ResponseTemplate();
        response.setData("data", "fail");
        if (ObjectUtils.allNotNull(form)) {
            GenreEntity genreUpdate = new GenreEntity();
            if (form.getId() != 0) {
                genreUpdate = genreRepository.getOne(form.getId());
            } else {
                genreUpdate.setId(form.getId());
            }
            if (!ObjectUtils.allNotNull(genreUpdate)) {
                genreUpdate = new GenreEntity();
            }
            genreUpdate.setName(form.getName());
            genreRepository.save(genreUpdate);
            response.setData("data", "successful");
        }
        return response;
    }

    @Override
    public ResponseTemplate deleteGenreById(Long id) {
        ResponseTemplate response = new ResponseTemplate();
        response.setData("data", "fail");
        if (ObjectUtils.allNotNull(id) && id != 0) {
            genreRepository.deleteById(id);
            response.setData("data", "successful");
        }
        return response;
    }
}
