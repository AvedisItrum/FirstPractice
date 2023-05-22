package com.example.apiswagger.domain.staff;

import com.example.apiswagger.domain.staff.dto.recieve.PostStaffDto;
import com.example.apiswagger.domain.staff.dto.recieve.PutStaffInfoDto;
import com.example.apiswagger.domain.staff.specs.StaffSpecifications;
import com.example.apiswagger.domain.web.dto.CustomException;
import com.example.apiswagger.domain.web.dto.IdResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Staff updateStaff(Long id, PutStaffInfoDto staff) {
        if (!staffRepository.existsById(id))
            throw CustomException.IdNotFound(Staff.class).get();

        Staff newStaff = modelMapper.map(staff, Staff.class);
        newStaff.setId(id);
        return staffRepository.save(newStaff);
    }

    @Override
    public IdResponseDto deleteStaff(Long id) {
        staffRepository.findById(id).orElseThrow(CustomException.IdNotFound(Staff.class));
        staffRepository.deleteById(id);
        return new IdResponseDto(id);
    }

    @Override
    public Staff addStaff(PostStaffDto staff) {
        return staffRepository.save(modelMapper.map(staff,Staff.class));
    }

    @Override
    public Page<Staff> getAllFilteredBy(String keyWord, PageRequest pageRequest) {
        return staffRepository.findAll(StaffSpecifications.isFitsForQuery(keyWord),pageRequest);
    }
}
