package com.example.demo.model;

import lombok.Data;

public @Data class EmployeeRequest {
	
	private String name;
	private int age;
	private double salary;
	private int isRetired;

}
