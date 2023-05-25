package com.example.apiswagger.domain.staff;

import com.example.apiswagger.domain.staff.dto.recieve.FindStaffByQuery;
import com.example.apiswagger.domain.staff.dto.recieve.PostStaffDto;
import com.example.apiswagger.domain.staff.dto.recieve.PutStaffDto;
import com.example.apiswagger.domain.web.dto.IdResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @PutMapping("staffs/{id}")
    private ResponseEntity<Staff> updateStaff(@ModelAttribute PutStaffDto staffDto) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(staffService.updateStaff(staffDto));
    }

    @DeleteMapping("staffs/{id}")
    private ResponseEntity<IdResponseDto> deleteStaff(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(new IdResponseDto(staffService.deleteStaff(id)));
    }

    @PostMapping("staff")
    private ResponseEntity<Staff> addStaff(@ModelAttribute PostStaffDto staffDto) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(staffService.addStaff(staffDto));
    }

    @GetMapping("staffs")
    private ResponseEntity<Page<Staff>> getStaff(@ModelAttribute FindStaffByQuery staff) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(staffService.getAllFilteredBy(staff));
    }
}
