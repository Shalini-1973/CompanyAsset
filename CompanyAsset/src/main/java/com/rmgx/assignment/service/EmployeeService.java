package com.rmgx.assignment.service;

import com.rmgx.assignment.dto.AssignDto;
import com.rmgx.assignment.dto.EmployeeDto;
import com.rmgx.assignment.dto.RecoverDto;
import com.rmgx.assignment.entity.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(EmployeeDto employeeDto);	// method for adding an employee
	
	public Employee searchEmployeeById(long id);		// method for searching an employee bye name
	
	public String deleteEmployeeId(long id);		// method for deleting an employee
	
	public Employee assignAsset(AssignDto assignDto);	// method for assigning an asset to the employee
	
	public Employee recoverAsset(RecoverDto recoverDto);	// method to recover asset assigned to an employee
	
}
