package com.example.apiswagger.domain.staff;


import com.example.apiswagger.domain.staff.dto.recieve.FindStaffByQuery;
import com.example.apiswagger.domain.staff.dto.recieve.PostStaffDto;
import com.example.apiswagger.domain.staff.dto.recieve.PutStaffDto;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.Set;

public interface StaffService {
    Staff updateStaff(PutStaffDto staffDto) throws IOException;

    Long deleteStaff(Long id);

    Staff addStaff(PostStaffDto staffDto) throws IOException;

    Page<Staff> getAllFilteredBy(FindStaffByQuery staffQuery);

    Set<Staff> getStaffByIds(Set<Long> actors);

    Staff convertFromDto(PutStaffDto dto) throws IOException;
    Staff convertFromDto(PostStaffDto dto) throws IOException;
}
