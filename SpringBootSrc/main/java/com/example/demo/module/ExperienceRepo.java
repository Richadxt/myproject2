package com.example.demo.module;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Experience;

public interface ExperienceRepo extends JpaRepository<Experience, Long> { 
	
	List<Experience> findExperienceDeatailsByEmployee_Id(Long empId);

}
