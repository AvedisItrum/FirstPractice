package com.example.apiswagger.domain.staff;


import com.example.apiswagger.domain.staff.dto.recieve.PostStaffDto;
import com.example.apiswagger.domain.staff.dto.recieve.PutStaffInfoDto;
import com.example.apiswagger.domain.web.dto.IdResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface StaffService {
    Staff updateStaff(Long id, PutStaffInfoDto staff);

    IdResponseDto deleteStaff(Long id);

    Staff addStaff(PostStaffDto staff);

    Page<Staff> getAllFilteredBy(String keyWord, PageRequest pageRequest);
}
