package com.cdac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.AccountDetails;
import com.cdac.entity.CompanyDetails;
import com.cdac.entity.Employee;
import com.cdac.repository.AccountDetailsRepository;
import com.cdac.repository.EmployeeRepository;

@Service
public class AccountDetailsService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	AccountDetailsRepository accountDetailsRepository;
	
	public void addAccount(AccountDetails accountDetails, int id) {
	    Employee employee = employeeRepository.getById(id);
	    accountDetails.setId(employee.getEmpId()); // Set the identifier value

	    employee.setAccountDetails(accountDetails);
	    accountDetails.setEmployee(employee);

	    employeeRepository.save(employee);
	}
	
	public AccountDetails getAccountDetails(int id) {
		return employeeRepository.getById(id).getAccountDetails();
	}
}
