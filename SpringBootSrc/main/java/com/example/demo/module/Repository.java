package com.example.demo.module;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Village;
import com.example.demo.helper.Helper;

public interface Repository extends JpaRepository<Village, Integer>
{
	@Query(value = "select v.name as village, c.name as city from village v join city c on" + " v.city_id=c.city_id where v.pincode in (?1);", nativeQuery = true)
	List<Helper> getByCityAndVillage(Collection<Long> pincode);
	
	
	
}