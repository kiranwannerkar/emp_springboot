package com.ty.employee.employee_springboot_prc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.employee.employee_springboot_prc.dto.Office;

public interface OfficeRepository extends JpaRepository<Office, Integer> {

}
