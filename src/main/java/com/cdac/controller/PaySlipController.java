package com.cdac.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.Leave;
import com.cdac.entity.PaySlip;
import com.cdac.service.LeaveService;
import com.cdac.service.PaySlipService;

@RestController
@CrossOrigin
public class PaySlipController {
	@Autowired
	PaySlipService paySlipService;
	
	@RequestMapping("/generatepayslip")
	public PaySlip add(@RequestParam int id,@RequestParam int month) {
		PaySlip payslipvar=paySlipService.generatePaySlip(id, month);
		PaySlip p1=new PaySlip();
		p1.setAccountNumber(payslipvar.getAccountNumber());
		p1.setBankName(payslipvar.getBankName());
		p1.setBasicSalary(payslipvar.getBasicSalary());
		p1.setBranchName(payslipvar.getBranchName());
		p1.setDaAmount(payslipvar.getDaAmount());
		p1.setDateOfJoining(payslipvar.getDateOfJoining());
		p1.setDepartment(payslipvar.getDepartment());
		p1.setDesignation(payslipvar.getDesignation());
		p1.setEmployee(payslipvar.getEmployee());
		p1.setEsiNumber(payslipvar.getEsiNumber());
		p1.setHraAmount(payslipvar.getHraAmount());
		p1.setId(id);
		p1.setIfscCode(payslipvar.getIfscCode());
		p1.setInsuranceAmount(payslipvar.getInsuranceAmount());
		p1.setiTaxAmount(payslipvar.getiTaxAmount());
		p1.setMaAmount(payslipvar.getMaAmount());
		p1.setMonth(payslipvar.getMonth());
		p1.setName(payslipvar.getName());
		p1.setNetSalary(payslipvar.getNetSalary());
		p1.setPanNumber(payslipvar.getPanNumber());
		p1.setPfAmount(payslipvar.getPfAmount());
		p1.setPfNumber(payslipvar.getPfNumber());
		p1.setpTaxAmount(payslipvar.getpTaxAmount());
		p1.setTotalDeductions(payslipvar.getTotalDeductions());
		p1.setTotalEarning(payslipvar.getTotalEarning());
		
		return p1;
	}
	
	@RequestMapping("/getpayslips")
	public List<PaySlip> getPaySlips(@RequestParam int empId) {
		List<PaySlip> list=paySlipService.getPaySlips(empId);
		List<PaySlip> list1=new ArrayList<PaySlip>();
		for(PaySlip payslipvar:list) {
			PaySlip p1=new PaySlip();
			p1.setAccountNumber(payslipvar.getAccountNumber());
			p1.setBankName(payslipvar.getBankName());
			p1.setBasicSalary(payslipvar.getBasicSalary());
			p1.setBranchName(payslipvar.getBranchName());
			p1.setDaAmount(payslipvar.getDaAmount());
			p1.setDateOfJoining(payslipvar.getDateOfJoining());
			p1.setDepartment(payslipvar.getDepartment());
			p1.setDesignation(payslipvar.getDesignation());
			p1.setEmployee(payslipvar.getEmployee());
			p1.setEsiNumber(payslipvar.getEsiNumber());
			p1.setHraAmount(payslipvar.getHraAmount());
			p1.setId(payslipvar.getId());
			p1.setIfscCode(payslipvar.getIfscCode());
			p1.setInsuranceAmount(payslipvar.getInsuranceAmount());
			p1.setiTaxAmount(payslipvar.getiTaxAmount());
			p1.setMaAmount(payslipvar.getMaAmount());
			p1.setMonth(payslipvar.getMonth());
			p1.setName(payslipvar.getName());
			p1.setNetSalary(payslipvar.getNetSalary());
			p1.setPanNumber(payslipvar.getPanNumber());
			p1.setPfAmount(payslipvar.getPfAmount());
			p1.setPfNumber(payslipvar.getPfNumber());
			p1.setpTaxAmount(payslipvar.getpTaxAmount());
			p1.setTotalDeductions(payslipvar.getTotalDeductions());
			p1.setTotalEarning(payslipvar.getTotalEarning());
			list1.add(p1);
		}
		
		return list1;
	}
	@RequestMapping("/getpayslip")
	public PaySlip getPaySlip(@RequestParam int id,@RequestParam int month) {
		PaySlip payslipvar=paySlipService.getPaySlip(id, month);
		PaySlip p1=new PaySlip();
		p1.setAccountNumber(payslipvar.getAccountNumber());
		p1.setBankName(payslipvar.getBankName());
		p1.setBasicSalary(payslipvar.getBasicSalary());
		p1.setBranchName(payslipvar.getBranchName());
		p1.setDaAmount(payslipvar.getDaAmount());
		p1.setDateOfJoining(payslipvar.getDateOfJoining());
		p1.setDepartment(payslipvar.getDepartment());
		p1.setDesignation(payslipvar.getDesignation());
		p1.setEmployee(payslipvar.getEmployee());
		p1.setEsiNumber(payslipvar.getEsiNumber());
		p1.setHraAmount(payslipvar.getHraAmount());
		p1.setId(payslipvar.getId());
		p1.setIfscCode(payslipvar.getIfscCode());
		p1.setInsuranceAmount(payslipvar.getInsuranceAmount());
		p1.setiTaxAmount(payslipvar.getiTaxAmount());
		p1.setMaAmount(payslipvar.getMaAmount());
		p1.setMonth(payslipvar.getMonth());
		p1.setName(payslipvar.getName());
		p1.setNetSalary(payslipvar.getNetSalary());
		p1.setPanNumber(payslipvar.getPanNumber());
		p1.setPfAmount(payslipvar.getPfAmount());
		p1.setPfNumber(payslipvar.getPfNumber());
		p1.setpTaxAmount(payslipvar.getpTaxAmount());
		p1.setTotalDeductions(payslipvar.getTotalDeductions());
		p1.setTotalEarning(payslipvar.getTotalEarning());
		
		return p1;
	}
}
