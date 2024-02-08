package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cdac.entity.FinancialDetails;
import com.cdac.entity.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Integer>{
//	
//	@Query("SELECT COUNT(DISTINCT l.empId) FROM Leave l WHERE l.fromDate <= CURRENT_DATE AND l.toDate >= CURRENT_DATE")
//	int countAllEmployeesOnLeaveToday();

	
	@Query("SELECT COUNT(*) FROM Leave WHERE fromDate <= CURRENT_DATE AND toDate >= CURRENT_DATE")
	int countAllEmployeesOnLeaveToday();
	
	 @Query("SELECT SUM(l.days) AS totalDays " +
	           "FROM Leave l " +
	           "WHERE l.employee.empId = :empId")
	 int sumDaysByEmpId(int empId);

}