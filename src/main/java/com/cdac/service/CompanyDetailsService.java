package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.CompanyDetails;
import com.cdac.entity.Employee;
import com.cdac.repository.CompanyDetailsRepository;
import com.cdac.repository.EmployeeRepository;

@Service
public class CompanyDetailsService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	CompanyDetailsRepository companyDetailsRepository;
	
	public void addCompany(CompanyDetails companyDetails, int id) {
	    Employee employee = employeeRepository.getById(id);
	    companyDetails.setId(employee.getEmpId()); // Set the identifier value

	    employee.setCompanyDetails(companyDetails);
	    companyDetails.setEmployee(employee);

	    employeeRepository.save(employee);
	}
	
	public CompanyDetails getCompanyDetails(int id) {
		return employeeRepository.getById(id).getCompanyDetails();
	}
}
