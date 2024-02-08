package com.cdac.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cdac.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	@Query("select count(c) from Employee c")
	public int countAllEmployees();
	
	public Employee findByEmail(String email);
	
}
