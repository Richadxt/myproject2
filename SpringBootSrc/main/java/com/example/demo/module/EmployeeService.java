package com.example.demo.module;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.helper.Helper;
import com.example.demo.model.LoginRequest;
import com.example.demo.model.ResponseEntityObject;


@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private AdminLoginJpaRepo adminLoginRepo;
	
	@Autowired
	private EmployeeJpaRepo employeeJpaRepo;
	
	@Autowired 
	private Repository repository;
	
	@Autowired
    private EmailService emailService;
	

	
   

	public ResponseEntity getBy(Collection<Long> pincode) 
	{
		List<Helper> list=repository.getByCityAndVillage(pincode);
		
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	
	public List<Employee> updateSalaryByPerformanceAndSalary(Double performanceScore, Double salary) {
	    return employeeJpaRepo.updateEmpByPerf(performanceScore, salary);
	}

	public void deleteAddressesByEmployeeIds(List<Integer> employeeIds) {
		employeeJpaRepo.deleteAddress(employeeIds);
	}

	public Employee registerEmp(String name, Integer age, Date joiningDate) {
	    return employeeJpaRepo.registerEmp(name, age, joiningDate);
	}

	public List<Integer> getAgesByConditions(String nameEndsWith, Integer age, List<String> cities) {
	    return employeeJpaRepo.fetchAgesOfEmployees(nameEndsWith, age, cities);
	}

	public List<Object[]> getAddressesByConditionsAndPerformance(Double performanceScore, Double annualPackage, Date startDate, Date endDate, String state, List<String> pincodes) {
	    return employeeJpaRepo.fetchAddressesOfEmployees(state, pincodes, performanceScore, annualPackage, startDate, endDate);
	}
	
	public List<Object[]> findEmployeesNameAndCityName() {
        return employeeJpaRepo.findEmployeesNameAndCityName();
    }
	public List<Object[]> findEmployees(){
		return employeeJpaRepo.findEmployees();	
	}
	public List<Object[]> totalAmountSpend(){
		return employeeJpaRepo.totalAmountSpend();	
	}
	public List<Object[]> checkHighLowAvgSalary(){
		return employeeJpaRepo.checkHighLowAvgSalary();	
	}
	public List<Object[]> checkAvgAge(){
		return employeeJpaRepo.checkAvgAge();	
	}
	public List<Object[]> checkEmpBirthSep(){
		return employeeJpaRepo.checkEmpBirthSep();	
	}
	
	public String giveSalaryHikeAndSendMail() {
		
		
		
		// Calculate the date 2 years ago from the current date
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, -2);
		Date twoYearsAgo = calendar.getTime();
	
		// Use the twoYearsAgo date in your query
	
	    	
	    	List<Object[]> eligibleEmployees = employeeJpaRepo.findCityAndAgeByOrganizationAndOtherConditions(twoYearsAgo);
	    	
	    	System.out.println("Good");
	    	System.out.println(eligibleEmployees.size());
	    	if(eligibleEmployees.isEmpty()) {
	    		throw new EmployeeException("No Employee Found");
	    	}
	    	
	    	for(Object[] e : eligibleEmployees) {
	    		
	    		
	    	 Optional<Employee> employee = employeeJpaRepo.findById((Long) e[0]);
	    		
	    		if(employee.isPresent()) {
	    		
	    		employee.get().setSalary(90000+ (90000*0.1));
	    		
	    		Employee savedEmployee = employeeJpaRepo.save(employee.get());
	    		
	    		String emailSubject = "Congratulations on Your Salary Hike!";
	            String emailContent = "Dear " + savedEmployee.getName() + ",\n" +
	    			    "Congratulations on your 10% salary increase! Your dedication and outstanding performance have earned you this well-deserved raise.\n" +
	    			    "Your contributions are invaluable, and we're excited to recognize your hard work.\n" +
	    			    "Warm regards,\n" +
	    			    "Richa Dixit\n" +
	    			    "Human Resources Manager\n" +
	    			    "Krenai";
	    		
	    		emailService.sendEmail(savedEmployee.getEmail(), emailSubject, emailContent);
	    	   }
	    	}
	    	
	    	return "Congratulation email sent to all the eligible employees successfully!";
	    }
	

	public String sendEmailOnOneYearOfCompletion() {
        Date today = new Date();
        Date oneYearAgo = new Date(today.getTime() - (1000L * 60 * 60 * 24 * 365));

        List<Employee> eligibleEmployees = employeeJpaRepo.findByJoiningDateBefore(oneYearAgo);

        if(eligibleEmployees.isEmpty()) {
        	throw new NullPointerException("not found");
        }
        for (Employee e : eligibleEmployees) {
        	
            String email=e.getEmail();
            if (email != null && !email.isEmpty()) {
            String emailSubject = "Congratulations on Your One-Year Anniversary!";
            String emailContent = "Dear " + e.getName() + ",\n\n" +
                    "We are thrilled to celebrate your one-year anniversary with XYZ company. Your dedication and hard work have made a significant impact on our team and our success.\n\n" +
                    "In recognition of your milestone, we want to express our heartfelt appreciation for your contributions. It's employees like you who make our organization thrive, and we look forward to many more years of collaboration and success.\n\n" +
                    "Congratulations on reaching this significant milestone, and here's to many more years of growth and achievement together!\n\n" +
                    "Warm regards,\n" +
                    "Richa Dixit\n" +
                    "Human Resources Manager\n" +
                    "XYZ company";

            emailService.sendEmail(e.getEmail(), emailSubject, emailContent);
           }
        }
        return "Email sent to all eligible employees successfully";
    }
        


	
	
	public ResponseEntity login(LoginRequest request) {
		try {
		    		if(adminLoginRepo.existsByUsernameAndPassword(request.getUsername(), request.getPassword())) {
				    return new ResponseEntity(new ResponseEntityObject(true, "SUCCESS LOGIN"), HttpStatus.OK);
			        }else {
			       return new ResponseEntity(new ResponseEntityObject(false, "USERNAME AND PASSWORD WRONG"), HttpStatus.OK);
			       }
		   }catch(Exception e) {
			e.printStackTrace();	
			 return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<List<Employee>> get(int age, String status, String search, String searchBy, String sortOrder, String sortBy, int itemPerPage, int pageNumber) {
		try {
			         List<Employee> list= empRepo.getData(age,status, search, searchBy, sortOrder,sortBy, itemPerPage, pageNumber);
			         long count =empRepo.getCount(age,status, search, searchBy, sortOrder, sortBy, itemPerPage, pageNumber);
			        
		             return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
        
		   }catch(Exception e) {
			e.printStackTrace();
			 return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	public ResponseEntity get(long id ) {
		try {
			
			Employee emp= employeeJpaRepo.findById(id).orElse(null);
         
		   return new ResponseEntity(emp, HttpStatus.OK);
        
		}catch(Exception e) {
			e.printStackTrace();
			
			 return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	
}
