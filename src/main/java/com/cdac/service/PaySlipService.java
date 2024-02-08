package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Employee;
import com.cdac.entity.Leave;
import com.cdac.entity.PaySlip;
import com.cdac.repository.EmployeeRepository;
import com.cdac.repository.PaySlipRepository;


@Service
public class PaySlipService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	PaySlipRepository paySlipRepository;
	
	public List<PaySlip> getPaySlips(int id){
		return employeeRepository.getById(id).getPayslips();
	}
	
	public PaySlip generatePaySlip(int id,int month) {
		Employee employee=employeeRepository.getById(id);
		List<PaySlip> list=employee.getPayslips();
		for(PaySlip tempPaySlip:list) {
			if((tempPaySlip.getEmployee().getEmpId()==id)&&tempPaySlip.getMonth()==month) {
				return tempPaySlip;
			}
		}
		PaySlip paySlip=new PaySlip();
		paySlip.setMonth(month);
		paySlip.setAccountNumber(employee.getAccountDetails().getAccountNumber());
		paySlip.setBankName(employee.getAccountDetails().getBankName());
		paySlip.setBranchName(employee.getAccountDetails().getBranchName());
		paySlip.setIfscCode(employee.getAccountDetails().getIfscCode());
		paySlip.setName(employee.getName());
		paySlip.setDepartment(employee.getCompanyDetails().getDepartment());
		paySlip.setDesignation(employee.getCompanyDetails().getDesignation());
		paySlip.setDateOfJoining(employee.getCompanyDetails().getDateOfJoining());
		paySlip.setPanNumber(employee.getFinancialDetails().getPanNumber());
		paySlip.setPfNumber(employee.getFinancialDetails().getPfNumber());
		paySlip.setEsiNumber(employee.getFinancialDetails().getEsiNumber());
		double basicSalary=getBasicSalary(id, month);
		double daAmount=basicSalary*0.4;
		double hraAmount=basicSalary*0.15;
		double maAmount=basicSalary*0.05;
		double pfAmount=basicSalary*0.03;
		double ipAmount=1000;
		double pTaxAmount=500;
		double iTaxAmount=getTax(basicSalary);
		
		paySlip.setBasicSalary(basicSalary);
		paySlip.setDaAmount(daAmount);
		paySlip.setHraAmount(hraAmount);
		paySlip.setMaAmount(maAmount);
		paySlip.setTotalEarning(basicSalary+daAmount+hraAmount+maAmount);
		
		paySlip.setPfAmount(pfAmount);
		paySlip.setInsuranceAmount(ipAmount);
		paySlip.setpTaxAmount(pTaxAmount);
		paySlip.setiTaxAmount(iTaxAmount);
		paySlip.setTotalDeductions(pfAmount+pTaxAmount+iTaxAmount+ipAmount);
		
		paySlip.setNetSalary((basicSalary+daAmount+hraAmount+maAmount)-(pfAmount+pTaxAmount+iTaxAmount+ipAmount));
		
		List<PaySlip> list1=employee.getPayslips();
	    list1.add(paySlip);
	    employee.setPayslips(list1);
	    paySlip.setEmployee(employee);

	    employeeRepository.save(employee);
	    return paySlip;
	}
	public PaySlip getPaySlip(int id,int month) {
		Employee employee=employeeRepository.getById(id);
		PaySlip paySlipNull=new PaySlip();
		List<PaySlip> list=employee.getPayslips();
		for(PaySlip paySlip:list) {
			if(paySlip.getMonth()==month) {
				return paySlip;
			}
		}
		return paySlipNull;
	}
	public double getBasicSalary(int id, int month) {
		Employee employee=employeeRepository.getById(id);
		int leaves=0;
		List<Leave> list=employee.getLeaves();
		for(Leave leavevar:list) {
			if(leavevar.getMonth()==month) {
				leaves+=leavevar.getDays();
			}
		}
		double basicSalary=employee.getFinancialDetails().getBasicSalary();
		double newSalary=basicSalary-((basicSalary/30)*leaves);
		return newSalary;
	}
	public double getTax(double basicSalary) {
		double iTaxAmount=0;
		if(basicSalary>80000) {
			iTaxAmount=0.3*basicSalary;
		}
		else if(basicSalary>60000) {
			iTaxAmount=0.2*basicSalary;
		}
		else if(basicSalary>40000) {
			iTaxAmount=0.2*basicSalary;
		}
		else {
			iTaxAmount=0;
		}
		return iTaxAmount;
	}

}
