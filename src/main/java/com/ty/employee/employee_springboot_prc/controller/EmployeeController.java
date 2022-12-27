package com.ty.employee.employee_springboot_prc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ty.employee.employee_springboot_prc.dto.Employee;
import com.ty.employee.employee_springboot_prc.service.EmployeeService;
import com.ty.employee.employee_springboot_prc.util.ResponseStructure;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("employee")
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee employee,@RequestParam int id) {
		return employeeService.saveEmployee(employee,id);
	}

	@GetMapping("getEmployee")
	public ResponseStructure<Employee> getItems(@RequestParam int id) {
		return employeeService.getEmployeeById(id);
	}

	@DeleteMapping("deleteEmployee/{id}")
	public ResponseStructure<String> deleteItems(@PathVariable int id) {

		return employeeService.deleteEmployee(id);
	}

	@PutMapping("updateEmployee")
	public ResponseStructure<Employee> updateItems(@RequestBody Employee employee,@RequestParam int id) {
		ResponseStructure<Employee> employee2 =employeeService.getEmployeeById(id);
		if(employee2!=null) {
			employee.setId(id);
			return employeeService.saveEmployee(employee,id);
		}
		return null;
	}
}

