package com.ty.employee.employee_springboot_prc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.employee.employee_springboot_prc.dto.Employee;
import com.ty.employee.employee_springboot_prc.repo.EmployeeRepository;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;


	public Employee saveEmployee( Employee employee) {

		return employeeRepository.save(employee);
	}

	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).get();
	}

	public String deleteEmployee(int id) {

		employeeRepository.deleteById(id);
		return "deleted";
	}

}
