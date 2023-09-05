package com.example.demo.module;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long> { 
	
	List<Address> findByEmployee_Id(Long empId);

}
