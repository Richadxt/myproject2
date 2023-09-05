package com.example.demo.module;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;

@Service
public class AddressService {

	@Autowired
	private AddressRepo addressRepo;
	
    public ResponseEntity getAddressList(Long empId) {
		
		List<Address> address =addressRepo.findByEmployee_Id(empId);
		return new ResponseEntity(address, HttpStatus.OK);
	}
}
