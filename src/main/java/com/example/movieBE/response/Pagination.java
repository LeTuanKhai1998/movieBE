package com.example.movieBE.response;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class Pagination {
    @NotNull
    @Min(0)
    private Integer currentPage = 1;

    @NotNull
    @Min(0)
    private Integer itemsPerPage;

    private String sort;

    private Boolean sortOrder;

    private Long totalItemCount;
}
