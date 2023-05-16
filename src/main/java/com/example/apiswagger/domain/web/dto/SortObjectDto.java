package com.example.apiswagger.domain.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SortObjectDto {
    private boolean empty;
    private boolean sorted;
    private boolean unsorted;
}
