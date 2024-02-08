package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.AccountDetails;
import com.cdac.entity.CompanyDetails;
import com.cdac.service.AccountDetailsService;

@RestController
@CrossOrigin
public class AccountDetailsController {
	@Autowired
	AccountDetailsService accountDetailsService;
	
	@PostMapping("/addAccountDetails")
	public void add(@RequestBody AccountDetails accountDetails) {
		accountDetailsService.addAccount(accountDetails, accountDetails.getEmployee().getEmpId());
	
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
	
	@RequestMapping("/getAccountDetails")
	public AccountDetails getAccountDetails(@RequestParam int empId) {
		AccountDetails accountDetails=accountDetailsService.getAccountDetails(empId);
		AccountDetails accountDetails1=new AccountDetails();
		accountDetails1.setId(accountDetails.getId());
		accountDetails1.setAccountName(accountDetails.getAccountName());
		accountDetails1.setAccountNumber(accountDetails.getAccountNumber());
		accountDetails1.setBankName(accountDetails.getBankName());
		accountDetails1.setBranchName(accountDetails.getBranchName());
		accountDetails1.setIfscCode(accountDetails.getIfscCode());
		
		return accountDetails1;
	}
}
