package com.example.apiswagger.domain.staff.specs;

import com.example.apiswagger.domain.staff.Staff;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class StaffSpecifications {
    public static Specification<Staff> isFitsForQuery(String keyWord) {
        if (keyWord == null || keyWord.isEmpty())
            return null;
        List<Specification<Staff>> specifications = new ArrayList<>();

        specifications.add((root, query, builder) -> builder.like(root.get("name"), "%" + keyWord + "%"));

        return Specification.allOf(specifications);
    }
}
