package com.example.demo.entity;


import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="village")
public @Data class Village 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(strategy = "native", name="native")
	@Column(name = "village_id")
	private int id;
	
	private String name;
	
	private long pincode;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
}
