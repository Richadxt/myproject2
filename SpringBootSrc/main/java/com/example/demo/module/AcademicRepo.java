package com.example.demo.module;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Academic;

public interface AcademicRepo extends JpaRepository<Academic, Long> { 
	
	List<Academic> findAcademicDetailsByEmployee_Id(Long empId);

}
