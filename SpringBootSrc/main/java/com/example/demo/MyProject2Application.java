package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.cors.CorsFilter;

@SpringBootApplication
public class MyProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(MyProject2Application.class, args);
	}
	@Bean
    CorsFilter corsFilter() {
		CorsFilter filter = new CorsFilter();
		return filter;
	}

}
