package com.example.movieBE.service;

import java.util.List;

public interface CommonService {
    String searchKeywordCreateSQL(String keyword, String fields, Boolean isAnd);

    List<String> searchKeywordSplitKeywords(String keywordInput);
}
