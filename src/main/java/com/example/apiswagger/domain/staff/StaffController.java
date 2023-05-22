package com.example.apiswagger.domain.staff;

import com.example.apiswagger.domain.staff.dto.recieve.PostStaffDto;
import com.example.apiswagger.domain.staff.dto.recieve.PutStaffInfoDto;
import com.example.apiswagger.domain.web.dto.IdResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @PutMapping("staffs/{id}")
    private ResponseEntity<Staff> updateStaff(@PathVariable("id") Long id, @RequestBody PutStaffInfoDto staff) {
        return ResponseEntity.status(HttpStatus.OK).body(staffService.updateStaff(id, staff));
    }

    @DeleteMapping("staffs/{id}")
    private ResponseEntity<IdResponseDto> deleteStaff(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(staffService.deleteStaff(id));
    }

    @PostMapping("staff")
    private ResponseEntity<Staff> addStaff(@RequestBody PostStaffDto staff){
        return ResponseEntity.status(HttpStatus.OK).body(staffService.addStaff(staff));
    }

    @GetMapping("staffs")
    private ResponseEntity<Page<Staff>> getStaff(@RequestParam(defaultValue = "") String[] properties,
                                               @RequestParam(defaultValue = "0") Integer page,
                                               @RequestParam(defaultValue = "10") Integer size,
                                               @RequestBody(required = false) String keyWord) {

        return ResponseEntity.status(HttpStatus.OK).body(staffService.getAllFilteredBy(keyWord, PageRequest.of(page, size, Sort.Direction.ASC, properties)));
    }
}
