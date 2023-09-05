package com.example.demo.module;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeJpaRepo extends JpaRepository<Employee, Long>{
	
	@Modifying
	@Transactional
	@Query("UPDATE Employee e SET e.salary = e.salary + ?1 WHERE e.performanceScore > ?2")
	public List<Employee> updateEmpByPerf(Double salary, Double performanceScore);
	
	@Modifying
	@Transactional
	@Query(value ="DELETE FROM Address a WHERE a.employee.id IN ?1 AND a.employee.hasCar = true", nativeQuery = true)	
	public void deleteAddress(List<Integer> ids);
	
	@Modifying
	@Transactional
	@Query(value ="INSERT into Employee (name, age, joiningDate) values(?1, ?2, ?3)", nativeQuery = true)
	public Employee registerEmp(String name, Integer age, Date joiningDate );
	
	
	@Query(value ="SELECT e.age FROM Address a JOIN a.employee e WHERE e.name LIKE %?1 AND e.age > ?2 AND e.hasCar = true AND a.city IN ?3", nativeQuery = true)
	public List<Integer> fetchAgesOfEmployees(String nameEndsWith, Integer age, List<String> cities);
	
	
	@Query(value ="SELECT a FROM Address a JOIN a.employee e WHERE a.state = :state AND a.pincode IN :pincodes AND e.performanceScore > :performanceScore AND e.annualPackage = :annualPackage AND e.joiningDocumentSubmitted = true AND e.joiningDate BETWEEN :startDate AND :endDate", nativeQuery = true)
	public List<Object[]> fetchAddressesOfEmployees(@Param("state") String state, @Param("pincodes") List<String> pincodes, @Param("performanceScore") Double performanceScore, @Param("annualPackage") Double annualPackage, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

	
	@Query(value ="SELECT e.name, a.city FROM myproject2.employee e INNER JOIN myproject2.address a ON e.id = a.id WHERE e.age > 45 AND e.salary IN (40000, 50000, 90000, 75000)", nativeQuery = true)
	public List<Object[]> findEmployeesNameAndCityName();

	
	
	@Query(value ="SELECT e.*, a.* FROM myproject2.employee e inner join myproject2.address a on e.id = a.id WHERE e.joining_date BETWEEN '2022-04-11' AND '2023-04-11' AND e.age BETWEEN 20 AND 40 AND (a.state IN ('Delhi', 'Haryana')) AND (a.city IN ('Delhi', 'Noida', 'Gurugram')) AND e.have_car = 0", nativeQuery = true)
	public List<Object[]> findEmployees();
	
	
	@Query(value ="SELECT"
			+ " SUM(quarterly_bonus + monthly_incentive) AS total_yearly_amount"
			+ " FROM ( SELECT id, salary, performance_score, (CASE WHEN performance_score >= 80 THEN (salary * 0.20) ELSE 0 END) AS quarterly_bonus, (CASE WHEN performance_score >= 90 THEN (salary * 0.05 * 12) ELSE 0 END) AS monthly_incentive"
			+ " FROM myproject2.employee) AS employee_bonuses", nativeQuery = true)
	public List<Object[]> totalAmountSpend();	
	
	
	
	@Query(value ="SELECT MAX(salary) AS highest_salary, MIN(salary) AS lowest_salary, AVG(salary) AS average_salary FROM myproject2.employee", nativeQuery = true)
	public List<Object[]> checkHighLowAvgSalary();	
	
	
	
	@Query(value ="SELECT AVG(age) AS aa FROM myproject2.employee", nativeQuery = true)
	public List<Object[]> checkAvgAge();	
	
	
	@Query(value = "SELECT e.id, a.city, e.age FROM address a INNER JOIN employee e ON a.employee_id = e.id WHERE e.salary < 90000 AND e.joining_date < ?1 AND e.age > 10" , nativeQuery = true)
	public List<Object[]> findCityAndAgeByOrganizationAndOtherConditions(Date joiningDate);
	
    public List<Employee> findByJoiningDateBefore(Date oneYearAgo);
	
    
	
	@Query(value ="SELECT * FROM myproject2.employee WHERE MONTH(birthdate) = 9", nativeQuery = true)
	public List<Object[]> checkEmpBirthSep();	
	
	

		
	
	
	
}
