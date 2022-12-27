package com.ty.employee.employee_springboot_prc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.employee.employee_springboot_prc.dto.Office;
import com.ty.employee.employee_springboot_prc.repo.OfficeRepository;
@Repository
public class OfficeDao {
@Autowired
OfficeRepository officeRepository;

public Office saveOffice( Office office ) {
	return officeRepository.save(office);
}

public Office getOfficeById(int id) {
	return officeRepository.findById(id).get();
}
public String deleteOffice(int id) {
	
	officeRepository.deleteById(id);
		return "deleted";
	}

}
