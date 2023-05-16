package com.example.apiswagger.domain.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PageableObjectDto {
    private int offset;
    private SortObjectDto sort;
    private int pageNumber;
    private int pageSize;
    private boolean paged;
    private boolean unpaged;
}
