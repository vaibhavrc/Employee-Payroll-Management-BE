package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.AccountDetails;
import com.cdac.entity.FinancialDetails;
import com.cdac.service.AccountDetailsService;
import com.cdac.service.FinancialDetailsService;

@RestController
@CrossOrigin
public class FinancialDetailsController {
	@Autowired
	FinancialDetailsService financialDetailsService;
	
	@PostMapping("/addFinancialDetails")
	public void add(@RequestBody FinancialDetails financialDetails) {
		financialDetailsService.addFinancial(financialDetails, financialDetails.getEmployee().getEmpId());
	
		/*
		 * {
		    "accountName":"Test",
		    "accountNumber":"12345",
		    "bankName":"BOI",
		    "branchName":"Vimannagar",
		    "ifscCode":"ABCD123",
		    "employee":{
		        "empId":"1"
		    }
		}
		 */
		
	}
	
	@RequestMapping("/getFinancialDetails")
	public FinancialDetails getFinancialDetails(@RequestParam int empId) {
		FinancialDetails financialDetails=financialDetailsService.getFinancialDetails(empId);
		FinancialDetails financialDetails1=new FinancialDetails();
		financialDetails1.setId(financialDetails.getId());
		financialDetails1.setAllowance(financialDetails.getAllowance());
		financialDetails1.setBasicSalary(financialDetails.getBasicSalary());
		financialDetails1.setDeduction(financialDetails.getDeduction());
		financialDetails1.setEsiNumber(financialDetails.getEsiNumber());
		financialDetails1.setPanNumber(financialDetails.getPanNumber());
		financialDetails1.setPfNumber(financialDetails.getPfNumber());
		financialDetails1.setTotalSalary(financialDetails.getTotalSalary());
		
		return financialDetails1;
	}
	
	
}
