package com.example.apiswagger.domain.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StaffRepository extends JpaRepository<Staff,Long>, JpaSpecificationExecutor<Staff> {
}
