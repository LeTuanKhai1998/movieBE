package com.example.movieBE.repository;

import com.example.movieBE.ScreenDto.MovieItemDto;
import com.example.movieBE.dto.ResponseTemplate;
import com.example.movieBE.form.SearchForm;
import com.example.movieBE.service.CommonService;
import com.example.movieBE.util.StringUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class SearchRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CommonService commonService;


    public ResponseTemplate getRejectData(SearchForm form) {
        ResponseTemplate response = new ResponseTemplate();
        if (!ObjectUtils.allNotNull(form, form.getPagination())) {
            return null;
        }
        String where = "";
        String orderBy = "";
        String fieldSearch = "m.name,m.slug";
        String keyWord = commonService.searchKeywordCreateSQL(ObjectUtils.allNotNull(form.getKeyWord()) ? form.getKeyWord() : "", fieldSearch, false);
        if (ObjectUtils.allNotNull(form.getPagination(), form.getPagination().getSortOrder()) && StringUtil.isNotBlank(form.getPagination().getSort())) {
            orderBy = form.getPagination().getSort() + (form.getPagination().getSortOrder() ? " ASC" : " DESC");
        } else {
            orderBy = "m.name DESC ";
        }
        String country = ObjectUtils.allNotNull(form.getCountry_id()) && form.getCountry_id() > 0 ? " m.country_id = :country_id " : "";
        String year = ObjectUtils.allNotNull(form.getRelease_year()) && form.getRelease_year() > 0 ? " m.release_year = :release_year " : "";

        year = StringUtil.isNotBlank(keyWord) &&  StringUtil.isNotBlank(year) ? " AND " + year : year;

        if (StringUtil.isNotBlank(keyWord) || StringUtil.isNotBlank(year) || StringUtil.isNotBlank(country)) {
            where = "where";
        }

        List<MovieItemDto> dtos = new ArrayList<>();
        MovieItemDto item;
        EntityManager em = this.entityManager;

        String sql = " select m.id as id, " +
                "  m.name as name, " +
                "  m.slug as slug, " +
                "  m.release_year as release_year, " +
                "  m.description as description, " +
                "  m.rate as rate, " +
                "  img.id as img_id, " +
                "  img.url as img_url, " +
                "  img.alt as img_alt, " +
                "  img_banner.id as banner_id, " +
                "  img_banner.url as banner_url, " +
                "  img_banner.alt as banner_alt " +
                " from movies m " +
                " join images img on m.image_id = img.id " +
                " join images img_banner on m.banner_id = img_banner.id " +
                where +
                keyWord +
                country +
                year +
                " order by " + orderBy;

        Query query = em.createNativeQuery(
                sql,
                Tuple.class);

        if (StringUtil.isNotBlank(country)) {
            query.setParameter("country_id", form.getCountry_id());
        }

        if (StringUtil.isNotBlank(year)) {
            query.setParameter("release_year", form.getRelease_year());
        }

        Integer totalPages = 0;
        if (ObjectUtils.allNotNull(query.getResultList())) {
            totalPages = query.getResultList().size() / form.getPagination().getItemsPerPage();
            if (query.getResultList().size() % form.getPagination().getItemsPerPage() != 0) {
                totalPages++;
            }
            response.setData("TotalPages", totalPages);
        }
        // Generate pagination
        Integer currentPage = 0;
        Integer itemsPerPage = 0;
        if ((ObjectUtils.allNotNull(form.getPagination(), form.getPagination().getCurrentPage(), form.getPagination().getItemsPerPage())  && form.getPagination().getItemsPerPage() > 0)) {
            currentPage = form.getPagination().getCurrentPage();
            itemsPerPage = form.getPagination().getItemsPerPage();
        }
        if ( itemsPerPage > 0) {
            Integer startIndex = (currentPage * itemsPerPage);
            query.setFirstResult(startIndex);
            query.setMaxResults(startIndex + itemsPerPage);
        }

        List<Tuple> resultList = query.getResultList();
        if (ObjectUtils.allNotNull(resultList) && !resultList.isEmpty()) {
            for (Tuple tuple : resultList) {
                item = new MovieItemDto(tuple);
                dtos.add(item);
            }
        }
        response.setData("data", dtos);
        return response;
    }
}
