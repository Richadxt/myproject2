package com.example.demo.module;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Experience;


@Service
public class ExperienceService {

	@Autowired
	private ExperienceRepo experienceRepo;
	
    public ResponseEntity getExperienceList(Long empId) {
		
		List<Experience> address =experienceRepo.findExperienceDeatailsByEmployee_Id(empId);
		return new ResponseEntity(address, HttpStatus.OK);
	}
}
