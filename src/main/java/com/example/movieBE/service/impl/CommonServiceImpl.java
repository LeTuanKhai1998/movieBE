package com.example.movieBE.service.impl;

import com.example.movieBE.service.CommonService;
import com.example.movieBE.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommonServiceImpl implements CommonService {

    @Override
    public String searchKeywordCreateSQL(String keyword, String fields, Boolean isAnd) {
        //String_Split
        List<String> fieldsList = Arrays.asList(fields.split(","));
        List<String> keywordsList = this.searchKeywordSplitKeywords(keyword);
        String subSQL = "";
        String sqlConditionKeyword = "";
        for (String s : keywordsList) {
            for (String field : fieldsList) {
                if (StringUtil.isNotBlank(field)) {
                    subSQL += StringUtil.isBlank(subSQL) ? "" : " OR ";
                    subSQL += field + " like '%" + s + "%' ";
                }
            }
            if (StringUtil.isNotBlank(subSQL)) {
                sqlConditionKeyword += StringUtil.isBlank(sqlConditionKeyword) ? "" : isAnd ? " AND " : " OR ";
                sqlConditionKeyword += "  ( " + subSQL + " ) ";
            }
            subSQL = "";
        }
//        if (StringUtil.isNotBlank(sqlConditionKeyword)) {
//            sqlConditionKeyword = " AND (" + sqlConditionKeyword + ") ";
//        }
        return sqlConditionKeyword;
    }

    /**
     * searchKeywordSplitKeywords
     *
     * @param keywordInput
     * @return
     * @author PhucNK
     */
    @Override
    public List<String> searchKeywordSplitKeywords(String keywordInput) {
        //String_Split
        String regex = " ";
        List<String> keywordsList = Arrays.asList(keywordInput.split(regex));
        keywordsList = keywordsList.stream().filter(StringUtils::isNotEmpty).collect(Collectors.toList());
        return keywordsList;
    }


}
