package com.rmgx.assignment.service;

import com.rmgx.assignment.dto.AssignDto;
import com.rmgx.assignment.dto.EmployeeDto;
import com.rmgx.assignment.dto.RecoverDto;
import com.rmgx.assignment.entity.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(EmployeeDto employeeDto);
	
	public Employee searchEmployeeById(long id);
	
	public String deleteEmployeeId(long id);
	
	public Employee assignAsset(AssignDto assignDto);
	
	public Employee recoverAsset(RecoverDto recoverDto);
	
}
