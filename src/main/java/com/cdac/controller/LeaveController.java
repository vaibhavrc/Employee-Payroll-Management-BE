package com.cdac.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entity.FinancialDetails;
import com.cdac.entity.Leave;
import com.cdac.service.FinancialDetailsService;
import com.cdac.service.LeaveService;
@RestController
@CrossOrigin
public class LeaveController {
	@Autowired
	LeaveService leaveService;
	
	@PostMapping("/addLeave")
	public String add(@RequestBody Leave leave) {
		return leaveService.addLeave(leave, leave.getEmployee().getEmpId());
	
		/*
		 * {
		    "month":"1",
		    "days":"2",
		    "fromDate":"2023-01-10",
		    "toDate":"2023-01-11",
		    "reason":"ABCD123",
		    "employee":{
		        "empId":"1"
		    }
		}
		 */
		
	}
	
	@RequestMapping("/getLeaves")
	public List<Leave> getLeaves(@RequestParam int empId) {
		List<Leave> leave=leaveService.getLeaves(empId);
		List<Leave> leave1=new ArrayList<Leave>();
		for(Leave leavevar:leave) {
			Leave l1=new Leave();
			l1.setDays(leavevar.getDays());
			l1.setEmployee(leavevar.getEmployee());
			l1.setFromDate(leavevar.getFromDate());
			l1.setId(leavevar.getId());
			l1.setMonth(leavevar.getMonth());
			l1.setReason(leavevar.getReason());
			l1.setToDate(leavevar.getToDate());
			leave1.add(l1);
		}
		
		return leave1;
	}
	
	
	@RequestMapping("/getAttendence")
	public int getAttendence() {
		return leaveService.countEmployeeOnLeaveToday();
	}
	
	@RequestMapping("/getLeaveDays")
	public int getLeaveDays(@RequestParam int empId) {
		return leaveService.emplooyeeLeaveDays(empId);
	}
}