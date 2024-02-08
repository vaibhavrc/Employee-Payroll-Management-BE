package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Employee;
import com.cdac.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	public List<Employee> getEmployees(){
		return employeeRepository.findAll();
	}
	public Employee getEmployee(int empId) {
		return employeeRepository.getById(empId);
	}
	
	public int countAllEmployees() {
        return employeeRepository.countAllEmployees();
    }
	
	public Employee getEmployee(String email) {
		return employeeRepository.findByEmail(email);
	}
	public void deleteEmployee(int empId) {
		employeeRepository.deleteById(empId);
	}
}
