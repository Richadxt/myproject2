package com.example.demo.module;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeCriteria {

	private String name;
    private Date joiningDate;
    private Integer age;
    private Double minSalary;
    private Double maxSalary;
    private Boolean haveCar;
    private String status;
    private Boolean isRetire;
}
