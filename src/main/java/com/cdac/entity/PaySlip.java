package com.cdac.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PaySlip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
    @JsonBackReference
    @JoinColumn(name = "empId")
	private Employee employee;
	
	private String name;
	private String department;
	private String designation;
	private LocalDate dateOfJoining;
	private String pfNumber;
	private String panNumber;
	private String esiNumber;
	private double basicSalary;
	private double daAmount;
	private double hraAmount;
	private double maAmount;
	private double totalEarning;
	private double pfAmount;
	private double insuranceAmount;
	private double pTaxAmount;
	private double iTaxAmount;
	private double totalDeductions;
	private double netSalary;
	private long accountNumber;
	private String bankName;
	private String branchName;
	private String ifscCode;
	private int month;
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getPfNumber() {
		return pfNumber;
	}
	public void setPfNumber(String pfNumber) {
		this.pfNumber = pfNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getEsiNumber() {
		return esiNumber;
	}
	public void setEsiNumber(String esiNumber) {
		this.esiNumber = esiNumber;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getDaAmount() {
		return daAmount;
	}
	public void setDaAmount(double daAmount) {
		this.daAmount = daAmount;
	}
	public double getHraAmount() {
		return hraAmount;
	}
	public void setHraAmount(double hraAmount) {
		this.hraAmount = hraAmount;
	}
	public double getMaAmount() {
		return maAmount;
	}
	public void setMaAmount(double maAmount) {
		this.maAmount = maAmount;
	}
	public double getTotalEarning() {
		return totalEarning;
	}
	public void setTotalEarning(double totalEarning) {
		this.totalEarning = totalEarning;
	}
	public double getPfAmount() {
		return pfAmount;
	}
	public void setPfAmount(double pfAmount) {
		this.pfAmount = pfAmount;
	}
	public double getInsuranceAmount() {
		return insuranceAmount;
	}
	public void setInsuranceAmount(double insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}
	public double getpTaxAmount() {
		return pTaxAmount;
	}
	public void setpTaxAmount(double pTaxAmount) {
		this.pTaxAmount = pTaxAmount;
	}
	public double getiTaxAmount() {
		return iTaxAmount;
	}
	public void setiTaxAmount(double iTaxAmount) {
		this.iTaxAmount = iTaxAmount;
	}
	public double getTotalDeductions() {
		return totalDeductions;
	}
	public void setTotalDeductions(double totalDeductions) {
		this.totalDeductions = totalDeductions;
	}
	public double getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
}
