package com.example.apiswagger.domain.staff;

import com.example.apiswagger.domain.staff.dto.recieve.FindStaffByQuery;
import com.example.apiswagger.domain.staff.dto.recieve.PostStaffDto;
import com.example.apiswagger.domain.staff.dto.recieve.PutStaffDto;
import com.example.apiswagger.domain.staff.specs.StaffSpecifications;
import com.example.apiswagger.domain.web.dto.CustomExceptions;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Staff updateStaff(PutStaffDto staffDto) throws IOException {
        return staffRepository.save(convertFromDto(staffDto));
    }

    @Override
    public Long deleteStaff(Long id) {
        staffRepository
                .findById(id)
                .orElseThrow(CustomExceptions.IdNotFound(Staff.class, id));
        staffRepository.deleteById(id);
        return id;
    }

    @Override
    public Staff addStaff(PostStaffDto staffDto) throws IOException {
        return staffRepository.save(convertFromDto(staffDto));
    }

    @Override
    public Page<Staff> getAllFilteredBy(FindStaffByQuery staffQuery) {
        PageRequest pageRequest = PageRequest.of(
                staffQuery.getPage(),
                staffQuery.getSize(),
                Sort.Direction.ASC,
                staffQuery.getProperties());

        return staffRepository.findAll(StaffSpecifications.isFitsForQuery(staffQuery.getKeyword()), pageRequest);
    }

    @Override
    public Set<Staff> getStaffByIds(Set<Long> ids) {
        Set<Staff> staffs = staffRepository.findAllByIdIn(ids);
        if (staffs.size() == ids.size())
            return staffs;

        Iterator<Long> iterator = staffs.stream().map(Staff::getId).iterator();

        while (iterator.hasNext())
            ids.remove(iterator.next());

        throw CustomExceptions.IdsNotFound(Staff.class, ids).get();
    }

    @Override
    public Staff convertFromDto(PutStaffDto dto) throws IOException {
        Staff staff = staffRepository.
                findById(dto.getId()).
                orElseThrow(CustomExceptions.IdNotFound(Staff.class, dto.getId()));
        staff.setName(dto.getName());
        if (dto.getOptAvatar() != null)
            staff.setAvatar(dto.getOptAvatar().getBytes());
        return staff;
    }

    @Override
    public Staff convertFromDto(PostStaffDto dto) throws IOException {
        Staff staff = modelMapper.map(dto, Staff.class);
        staff.setAvatar(dto.getAvatar().getBytes());
        return staff;
    }


}
