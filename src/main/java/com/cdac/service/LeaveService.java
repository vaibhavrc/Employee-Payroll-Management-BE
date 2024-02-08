package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Employee;
import com.cdac.entity.Leave;
import com.cdac.repository.EmployeeRepository;
import com.cdac.repository.LeaveRepository;
@Service
public class LeaveService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	LeaveRepository leaveRepository;
	
	public String addLeave(Leave leave, int id) {
	    Employee employee = employeeRepository.getById(id);
//	    int maxId=leaveRepository.getMaxId();
//	    leave.setId(maxId+1);
	    List<Leave> leaves=employee.getLeaves();
	    for(Leave tempLeave:leaves) {
	    	System.out.println(tempLeave.getFromDate()+":::"+leave.getFromDate());
	    	if((tempLeave.getFromDate().compareTo(leave.getFromDate())==0)&&(tempLeave.getToDate().compareTo(leave.getToDate())==0)) {
	    		return "Already applied for leave";
	    	}
	    }
	    leaves.add(leave);
	    employee.setLeaves(leaves);
	    leave.setEmployee(employee);

	    employeeRepository.save(employee);
	    return "Leave applied successfully";
	}
	public List<Leave> getLeaves(int id) {
		return employeeRepository.getById(id).getLeaves();
	}		
	
	public int countEmployeeOnLeaveToday() {
		return leaveRepository.countAllEmployeesOnLeaveToday();
	}
	
	public int emplooyeeLeaveDays(int empId) {
		return leaveRepository.sumDaysByEmpId(empId);
	}
}