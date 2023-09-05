package com.example.demo.entity;

//import java.util.Date;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.Data;
//
//@Data
//@Entity
//public class Employee {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private Date joiningDate;
//    private int age;
//    private double salary;
//    private boolean haveCar;
//    private String status;
//    private boolean isRetire;
//    
//
//    // Getters and setters
//}
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private Integer age;
    private Double salary;
    private Date joiningDate;
    private Date birthdate;
    private String city;
    private String status;
    private String organization;
    private Double performanceScore;
    private Boolean haveCar;
    private Double annualPackage;
    private Boolean joiningDocumentSubmitted;
    
    
}