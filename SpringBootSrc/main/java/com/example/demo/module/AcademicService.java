package com.example.demo.module;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Academic;

@Service
public class AcademicService {

	@Autowired
	private AcademicRepo academicRepo;
	
    public ResponseEntity getAcademicDetailsList(Long empId) {
		
		List<Academic> address =academicRepo.findAcademicDetailsByEmployee_Id(empId);
		return new ResponseEntity(address, HttpStatus.OK);
	}
}
