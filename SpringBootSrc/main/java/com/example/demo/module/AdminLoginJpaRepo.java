package com.example.demo.module;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AdminLogin;

public interface AdminLoginJpaRepo extends JpaRepository<AdminLogin, Long> {
	
	boolean existsByUsernameAndPassword(String username, String password);

}
