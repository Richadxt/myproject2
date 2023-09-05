package com.example.demo.module;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.model.LoginRequest;

@CrossOrigin
@RestController
@RequestMapping(path = "/emp-management")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private AcademicService academicService;
	
	@Autowired
	private ExperienceService experienceService;
	
	
	@PostMapping("/update-salary")
    public ResponseEntity<List<Employee>> updateSalaryByPerformanceAndSalary(@RequestParam Double performanceScore, @RequestParam Double salary) {
        List<Employee> updatedEmployees = service.updateSalaryByPerformanceAndSalary(performanceScore, salary);
        return new ResponseEntity<>(updatedEmployees, HttpStatus.OK);
    }

    @DeleteMapping("/delete-addresses")
    public ResponseEntity<Void> deleteAddressesByEmployeeIds(@RequestBody List<Integer> employeeIds) {
        service.deleteAddressesByEmployeeIds(employeeIds);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/register-employee")
    public ResponseEntity<Employee> registerEmployee(@RequestParam String name, @RequestParam Integer age, @RequestParam Date joiningDate) {
        Employee employee = service.registerEmp(name, age, joiningDate);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("/get-ages")
    public ResponseEntity<List<Integer>> getAgesByConditions(@RequestParam String nameEndsWith, @RequestParam Integer age, @RequestParam List<String> cities) {
        List<Integer> ages = service.getAgesByConditions(nameEndsWith, age, cities);
        return new ResponseEntity<>(ages, HttpStatus.OK);
    }

    @GetMapping("/get-addresses")
    public ResponseEntity<List<Object[]>> getAddressesByConditionsAndPerformance(@RequestParam Double performanceScore, @RequestParam Double annualPackage, @RequestParam Date startDate, @RequestParam Date endDate, @RequestParam String state, @RequestParam List<String> pincodes) {
        List<Object[]> addresses = service.getAddressesByConditionsAndPerformance(performanceScore, annualPackage, startDate, endDate, state, pincodes);
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }
    
    @GetMapping("/get1")
    public ResponseEntity<List<Object[]>> findEmployeesNameAndCityName() {
        List<Object[]>  find1= service.findEmployeesNameAndCityName();
        return new ResponseEntity<>(find1, HttpStatus.OK);
    }
    
    @RequestMapping("get2")
	public ResponseEntity get(@RequestParam Collection<Long> pincode)
	{
		return service.getBy(pincode);
	}
    
    @GetMapping("/get3")
    public ResponseEntity<List<Object[]>> findEmployees()	{
    	List<Object[]> find2=service.findEmployees();
    	return new ResponseEntity<>(find2, HttpStatus.OK);
    	
    }
    
    @GetMapping("getT1")
    public ResponseEntity<List<Object[]>> totalAmountSpend() {
    	List<Object[]>  find1= service.totalAmountSpend();
        return new ResponseEntity<>(find1, HttpStatus.OK);
    }
    
    @GetMapping("/getT2")
    public ResponseEntity<List<Object[]>> checkHighLowAvgSalary() {
        List<Object[]>  find1= service.checkHighLowAvgSalary();
        return new ResponseEntity<>(find1, HttpStatus.OK);
    }
    
    @GetMapping("/getT3")
    public ResponseEntity<List<Object[]>> checkAvgAge() {
    	List<Object[]>  find1= service.checkAvgAge();
        return new ResponseEntity<>(find1, HttpStatus.OK);
    }
    
    @GetMapping("/getT4")
    public ResponseEntity<String> giveSalaryHikeAndSendMail() {
    	String  find1= service.giveSalaryHikeAndSendMail();
        return new ResponseEntity<>(find1, HttpStatus.OK);
    }
    
    @GetMapping("/getT5")
    public ResponseEntity<String> sendEmailOnOneYearOfCompletion(){
        String result = service.sendEmailOnOneYearOfCompletion();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getT6")
    public ResponseEntity<List<Object[]>> checkEmpBirthSep(){
        List<Object[]> employees = service.checkEmpBirthSep();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    

	
	@RequestMapping(path ="/login", method = RequestMethod.POST)
	public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
		
		return service.login(loginRequest);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path ="/fetch")
	public ResponseEntity get(
			@RequestParam(name = "age", defaultValue = "0") int age,
			@RequestParam(name = "status", defaultValue = "") String status,
			@RequestParam(name = "itemsPerPage", defaultValue = "1") int itemPerPage,
			@RequestParam(name = "pageNumber", defaultValue = "1") int pageNumber,
			@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "searchBy", defaultValue = "") String searchBy,
			 @RequestParam(name = "sortOrder", defaultValue = "") String sort,
			 @RequestParam(name = "sortBy", defaultValue = "") String sortBy)
	{
		return service.get(age, status, search, searchBy, sort, sortBy, itemPerPage, pageNumber);
	}
	
	@RequestMapping(method = RequestMethod.GET, path ="/single/{id}")
	public ResponseEntity getEmp(@PathVariable(name = "id") Long id) {
		
		return service.get(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, path ="/address-list/{empId}")
	public ResponseEntity getAddressList(@PathVariable(name = "empId") Long empId) {
       return addressService.getAddressList(empId);
    }
	
	@RequestMapping(method = RequestMethod.GET, path ="/academic-list/{empId}")
	public ResponseEntity getAcademicDetailsList(@PathVariable(name = "empId") Long empId) {
       return academicService.getAcademicDetailsList(empId);
    }
	
	@RequestMapping(method = RequestMethod.GET, path ="/experience-list/{empId}")
	public ResponseEntity getExperienceList(@PathVariable(name = "empId") Long empId) {
       return experienceService.getExperienceList(empId);
    }
	
	
}
