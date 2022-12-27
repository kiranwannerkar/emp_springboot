package com.ty.employee.employee_springboot_prc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.employee.employee_springboot_prc.dao.EmployeeDao;
import com.ty.employee.employee_springboot_prc.dao.OfficeDao;
import com.ty.employee.employee_springboot_prc.dto.Employee;
import com.ty.employee.employee_springboot_prc.dto.Office;
import com.ty.employee.employee_springboot_prc.util.ResponseStructure;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private OfficeDao officeDao;

	public ResponseStructure<Employee> saveEmployee(Employee employee, int id) {
		
		Office office=officeDao.getOfficeById(id);
		employee.setOffice(office);
		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(employeeDao.saveEmployee(employee));
		return responseStructure;

	}

	public ResponseStructure<Employee> getEmployeeById(int id) {
		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("received");
		responseStructure.setData(employeeDao.getEmployeeById(id));
		return responseStructure;
	}

	public ResponseStructure<String> deleteEmployee(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("deleted");
		responseStructure.setData(employeeDao.deleteEmployee(id));
		return responseStructure;

	}


}
