package com.example.movieBE.service.impl;

import com.example.movieBE.ScreenDto.MovieItemDto;
import com.example.movieBE.constant.StringConstant;
import com.example.movieBE.dto.MovieDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.entity.MovieEntity;
import com.example.movieBE.form.SearchForm;
import com.example.movieBE.repository.MovieRepository;
import com.example.movieBE.repository.SearchRepository;
import com.example.movieBE.service.HomeService;
import com.example.movieBE.service.admin.MovieService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private MovieService movieService;

    /**
     *
     */
    @Autowired
    private MovieRepository movieRepository;

    /**
     *
     */
    @Autowired
    private SearchRepository searchRepository;

    @Override
    public ResponseTemplate search(SearchForm form) {
        return searchRepository.getRejectData(form);
    }

    @Override
    public ResponseTemplate getYear() {
        ResponseTemplate response = new ResponseTemplate();
        response.setData("data",movieRepository.getYear());
        return response;
    }

    @Override
    public ResponseTemplate getMovie(String type) {
        ResponseTemplate response = new ResponseTemplate();

        List<MovieEntity> list = new ArrayList<>();

        List<MovieItemDto> dtos = new ArrayList<>();

        MovieItemDto item;

        switch (type) {
            case StringConstant.Banner:
                list = movieRepository.getBanner();
                break;
            case StringConstant.BannerBottom:
                list = movieRepository.getBannerBottom();
                break;
            case StringConstant.Featured:
                list = movieRepository.getFeatured();
                break;
            case StringConstant.TopRating:
                list = movieRepository.getTopRating();
                break;
            case StringConstant.TopViewed:
                list = movieRepository.getTopViewed();
                break;
            case StringConstant.RecentlyAdded:
                list = movieRepository.getRecentlyAdded();
                break;
            default:
                break;
        }

        for (MovieEntity movieEntity : list) {
            if (ObjectUtils.allNotNull(movieEntity)) {
                item = movieService.getMovieItem(movieEntity);
                dtos.add(item);
            }
        }
        response.setData("data", dtos);
        return response;
    }

    @Override
    public ResponseTemplate getMostPopularMovie(Integer totalnumber, Integer numPerItem) {
        ResponseTemplate response = new ResponseTemplate();
        Pageable paging = PageRequest.of(0, totalnumber, Sort.by("num_view").descending().and(Sort.by("rate").descending()));

        List<MovieEntity> list = movieRepository.getMostPopularMovie(paging);

        List<MovieDto> movieDtoList = new ArrayList<>();

        list.forEach(movie -> {
            movieDtoList.add(movieService.getFullMovie(movie));
        });

        List<Object> finalList = new ArrayList<>();

        for (int i = 0; i < movieDtoList.size(); i += numPerItem) {
            finalList.add(movieDtoList.subList(i, Math.min(movieDtoList.size(), i + numPerItem)));
        }

        response.setData("data", finalList);
        return response;
    }


}
