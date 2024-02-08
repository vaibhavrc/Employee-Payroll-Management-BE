package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.AccountDetails;
import com.cdac.entity.CompanyDetails;
import com.cdac.entity.Employee;
import com.cdac.entity.FinancialDetails;
import com.cdac.service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/list-employee")
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody Employee employee1) {
		Employee employee = new Employee();
	    employee.setName(employee1.getName());
	    employee.setDateOfBirth(employee1.getDateOfBirth());
	    employee.setGender(employee1.getGender());
	    employee.setEmail(employee1.getEmail());
	    employee.setMobileNumber(employee1.getMobileNumber());
	    employee.setCurrentAddress(employee1.getCurrentAddress());
	    employee.setPermanentAddress(employee1.getPermanentAddress());
	    employee.setPassword(employee1.getPassword());


	    // Set the CompanyDetails if available
	    if (employee1.getCompanyDetails() != null) {
	        CompanyDetails companyDetails = new CompanyDetails();
	        companyDetails.setDepartment(employee1.getCompanyDetails().getDepartment());
	        companyDetails.setDesignation(employee1.getCompanyDetails().getDesignation());
	        companyDetails.setDateOfJoining(employee1.getCompanyDetails().getDateOfJoining());
	        companyDetails.setDateOfLeaving(employee1.getCompanyDetails().getDateOfLeaving());
	        companyDetails.setStatus(employee1.getCompanyDetails().getStatus());
	        companyDetails.setEmployee(employee);
	        employee.setCompanyDetails(companyDetails);
	    }
	    
	    if(employee1.getAccountDetails()!=null) {
	    	AccountDetails accountDetails=new AccountDetails();
	    	accountDetails.setAccountName(employee1.getAccountDetails().getAccountName());
	    	accountDetails.setAccountNumber(employee1.getAccountDetails().getAccountNumber());
	    	accountDetails.setBankName(employee1.getAccountDetails().getBankName());
	    	accountDetails.setBranchName(employee1.getAccountDetails().getBranchName());
	    	accountDetails.setIfscCode(employee1.getAccountDetails().getIfscCode());
	    	accountDetails.setEmployee(employee);
	    	employee.setAccountDetails(accountDetails);
	    }
	    
	    if(employee1.getFinancialDetails()!=null) {
	    	FinancialDetails financialDetails=new FinancialDetails();
	    	financialDetails.setBasicSalary(employee1.getFinancialDetails().getBasicSalary());
	    	financialDetails.setAllowance(employee1.getFinancialDetails().getAllowance());
	    	financialDetails.setDeduction(employee1.getFinancialDetails().getDeduction());
	    	financialDetails.setEsiNumber(employee1.getFinancialDetails().getEsiNumber());
	    	financialDetails.setPanNumber(employee1.getFinancialDetails().getPanNumber());
	    	financialDetails.setPfNumber(employee1.getFinancialDetails().getPfNumber());
	    	financialDetails.setTotalSalary(employee1.getFinancialDetails().getBasicSalary()+employee1.getFinancialDetails().getAllowance()-employee1.getFinancialDetails().getDeduction());
	    	financialDetails.setEmployee(employee);
	    	employee.setFinancialDetails(financialDetails);
	    }

	    // Save the employee using the service or repository
	    employeeService.addEmployee(employee);
	    
	}
	
	@RequestMapping("/emp")
	public Employee getEmployee(@RequestParam int empId) {
		Employee employee1= employeeService.getEmployee(empId);
		Employee employee=new Employee();
		
		employee.setEmpId(employee1.getEmpId());
		employee.setName(employee1.getName());
	    employee.setDateOfBirth(employee1.getDateOfBirth());
	    employee.setGender(employee1.getGender());
	    employee.setEmail(employee1.getEmail());
	    employee.setMobileNumber(employee1.getMobileNumber());
	    employee.setCurrentAddress(employee1.getCurrentAddress());
	    employee.setPermanentAddress(employee1.getPermanentAddress());
		employee.setCompanyDetails(employee1.getCompanyDetails());
		employee.setAccountDetails(employee1.getAccountDetails());
		employee.setFinancialDetails(employee1.getFinancialDetails());
	    return employee;
	}
	@RequestMapping("/employee-email")
	public Employee getEmployeeByEmail(@RequestParam String email) {
		Employee employee1= employeeService.getEmployee(email);
		Employee employee=new Employee();
		
		employee.setEmpId(employee1.getEmpId());
		employee.setName(employee1.getName());
	    employee.setDateOfBirth(employee1.getDateOfBirth());
	    employee.setGender(employee1.getGender());
	    employee.setEmail(employee1.getEmail());
	    employee.setMobileNumber(employee1.getMobileNumber());
	    employee.setCurrentAddress(employee1.getCurrentAddress());
	    employee.setPermanentAddress(employee1.getPermanentAddress());
		employee.setCompanyDetails(employee1.getCompanyDetails());
		employee.setAccountDetails(employee1.getAccountDetails());
		employee.setFinancialDetails(employee1.getFinancialDetails());
	    return employee;
	}
	
	@GetMapping("/employees/count")
    public Integer countAllEmployees() {
        return employeeService.countAllEmployees();
    }
	
	
	@GetMapping("/login")
	public int getEmployee(@RequestParam int id,@RequestParam String password) {
		Employee emp = employeeService.getEmployee(id);
		if(emp.getPassword().equals(password)){
			return emp.getEmpId();
		}
		else
			return 0;
	}
	
	@GetMapping("/login-email")
	public int getEmployee(@RequestParam String email,@RequestParam String password) {
		Employee emp = employeeService.getEmployee(email);
		if(emp.getPassword().equals(password)){
			return emp.getEmpId();
		}
		else
			return 0;
	}
	@RequestMapping("/delete")
	public void deleteEmployee(@RequestParam int empId) {
		employeeService.deleteEmployee(empId);
	}
	
//	@GetMapping("/employee-email")
//	public Employee getEmployee(@RequestParam String email) {
//		Employee emp = employeeService.getEmployee(email);
//		return emp;
//	}
}
