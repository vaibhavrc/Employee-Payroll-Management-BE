package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.AccountDetails;
import com.cdac.entity.CompanyDetails;
import com.cdac.entity.Employee;
import com.cdac.entity.FinancialDetails;
import com.cdac.service.CompanyDetailsService;

@RestController
@CrossOrigin
public class CompanyDetailsController {
	@Autowired
	CompanyDetailsService companyDetailsService;
	
	@PostMapping("/addCompany")
	public void add(@RequestBody CompanyDetails companyDetails) {
		companyDetailsService.addCompany(companyDetails, companyDetails.getEmployee().getEmpId());
	
		/*
		 * {
		    "department":"Test",
		    "designation":"Employee",
		    "dateOfJoining":"2023-01-01",
		    "dateOfLeaving":"2023-01-20",
		    "status":"Active",
		    "employee":{
		        "empId":"5"
		    }
		}
		 */
		
	}
	
	@RequestMapping("/getCompany")
	public CompanyDetails getCompanyDetails(@RequestParam int empId) {
		CompanyDetails companyDetails=companyDetailsService.getCompanyDetails(empId);
		CompanyDetails companyDetails1=new CompanyDetails();
		companyDetails1.setDepartment(companyDetails.getDepartment());
		companyDetails.setDesignation(companyDetails1.getDesignation());
		companyDetails1.setDateOfJoining(companyDetails.getDateOfJoining());
		companyDetails1.setDateOfLeaving(companyDetails.getDateOfLeaving());
		companyDetails1.setId(companyDetails.getId());
		companyDetails1.setStatus(companyDetails.getStatus());
		
		return companyDetails1;
	}
}
