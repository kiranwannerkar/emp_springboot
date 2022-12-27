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

import com.ty.employee.employee_springboot_prc.dto.Office;
import com.ty.employee.employee_springboot_prc.service.OfficeService;
import com.ty.employee.employee_springboot_prc.util.ResponseStructure;


@RestController
public class OfficeController {
	@Autowired
	private OfficeService officeService;
	@PostMapping("office")
	public ResponseStructure<Office> saveOffice(@RequestBody Office office) {
		return officeService.saveOffice(office);
	}
	
	@GetMapping("getOffice")
	public ResponseStructure<Office> getOffice(@RequestParam int id) {
		return officeService.getOfficeById(id);
	}
	
	@DeleteMapping("officedelete/{id}")
	public ResponseStructure<String> deleteOffice(@PathVariable int id) {
		
		return officeService.deleteOffice(id);
	}
	
    @PutMapping("updateoffice")
    public ResponseStructure<Office> updateStudent(@RequestBody Office office,@RequestParam int id) {
    	ResponseStructure<Office> cart2 =officeService.getOfficeById(id);
    	if(cart2!=null) {
    		office.setId(id);
    		return officeService.saveOffice(office);
    	}
    	return null;
    }
}
