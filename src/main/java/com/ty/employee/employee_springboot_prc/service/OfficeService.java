package com.ty.employee.employee_springboot_prc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ty.employee.employee_springboot_prc.dao.OfficeDao;
import com.ty.employee.employee_springboot_prc.dto.Office;
import com.ty.employee.employee_springboot_prc.util.ResponseStructure;
@Service
public class OfficeService {
	@Autowired
	private OfficeDao officeDao;

	public ResponseStructure<Office> saveOffice(@RequestBody Office office) {
		ResponseStructure<Office> responseStructure = new ResponseStructure<Office>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(officeDao.saveOffice(office));
		return responseStructure;
	}

	public ResponseStructure<Office> getOfficeById(int id) {
		ResponseStructure<Office> responseStructure = new ResponseStructure<Office>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("received");
		responseStructure.setData(officeDao.getOfficeById(id));
		return responseStructure;
	}
	
	public ResponseStructure<String> deleteOffice(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("deleted");
		responseStructure.setData(officeDao.deleteOffice(id));
		return responseStructure;

	}
}
