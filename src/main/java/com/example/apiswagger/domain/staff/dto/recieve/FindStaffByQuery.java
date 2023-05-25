package com.example.apiswagger.domain.staff.dto.recieve;

import jakarta.annotation.Nullable;
import lombok.Getter;


@Getter
public class FindStaffByQuery {
    public FindStaffByQuery(Integer page, Integer size, String[] properties, String keyword) {
        this.page = page==null?0:page;
        this.size = size==null?10:size;
        this.properties = properties==null?new String[]{"id"}:properties;
        this.keyword = keyword==null?"":keyword;
    }

    @Nullable
    Integer page;
    @Nullable
    Integer size;
    @Nullable
    String[] properties;
    @Nullable
    String keyword;
}
