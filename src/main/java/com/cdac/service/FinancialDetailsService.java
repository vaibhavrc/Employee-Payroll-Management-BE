package com.cdac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.AccountDetails;
import com.cdac.entity.Employee;
import com.cdac.entity.FinancialDetails;
import com.cdac.repository.AccountDetailsRepository;
import com.cdac.repository.EmployeeRepository;
import com.cdac.repository.FinancialDetailsRepository;

@Service
public class FinancialDetailsService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	FinancialDetailsRepository financialDetailsRepository;
	
	public void addFinancial(FinancialDetails financialDetails, int id) {
	    Employee employee = employeeRepository.getById(id);
	    financialDetails.setId(employee.getEmpId()); // Set the identifier value

	    employee.setFinancialDetails(financialDetails);
	    financialDetails.setEmployee(employee);

	    employeeRepository.save(employee);
	}
	public FinancialDetails getFinancialDetails(int id) {
		return employeeRepository.getById(id).getFinancialDetails();
	}
}
