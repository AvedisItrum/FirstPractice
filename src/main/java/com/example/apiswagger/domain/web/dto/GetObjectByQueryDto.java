package com.example.apiswagger.domain.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class GetObjectByQueryDto<T> {
    private int totalPages;
    private int totalElements;
    private int size;
    private Set<T> content;
    private int number;
    private SortObjectDto sort;
    private PageableObjectDto pageable;
    private boolean first;
    private boolean last;
    private int numberOfElements;
    private boolean empty;
}
