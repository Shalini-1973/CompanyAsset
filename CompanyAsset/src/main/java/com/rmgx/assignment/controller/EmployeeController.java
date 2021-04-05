package com.rmgx.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rmgx.assignment.dto.AssignDto;
import com.rmgx.assignment.dto.EmployeeDto;
import com.rmgx.assignment.dto.RecoverDto;
import com.rmgx.assignment.entity.Employee;
import com.rmgx.assignment.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping("/addEmployee")				//handle a request for adding an employee
	public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDto employeeDto){
		Employee addedEmployee = service.addEmployee(employeeDto); // a service method called for adding an employee to the database
		return ResponseEntity.ok(addedEmployee);
	}
	
	@PostMapping("/getEmployeeById")				// handle the request for getting an employee details
	public ResponseEntity<Employee> getEmployeeById(@RequestParam(value="EmployeeId") long id){
		
		Employee searchedEmployee = service.searchEmployeeById(id); // a service method called for fetching the employee data from database
		
		return ResponseEntity.ok(searchedEmployee);
	}
	
	@PostMapping("/deleteEmployeeById")				// handles the request for deleting the employee
	public ResponseEntity<String> deleteEmployeeById(@RequestParam(value="EmployeeId") long id){
		String deleteEmployee = service.deleteEmployeeId(id);;	 // method called to validate and delete an employee from the database
		return ResponseEntity.ok(deleteEmployee);
	}
	
	@PostMapping("/assignAsset")		//handle request to assign an asset to an employee
	public ResponseEntity<Employee> assignAsset(@RequestBody AssignDto assignDto){
		Employee assignedAsset = service.assignAsset(assignDto);	// a service method call for assigning an asset to the employee and store it to database.
		return ResponseEntity.ok(assignedAsset);
	}
	
	@PostMapping("/recoverAsset")			//handle a request to recover a assigned asset to an employee
	public ResponseEntity<Employee> recoverAsset(@RequestBody RecoverDto recoverDto){
		
		Employee recoveredAsset = service.recoverAsset(recoverDto); // a service method call for recovering an asset to the employee and store it to database.
		return ResponseEntity.ok(recoveredAsset);
	}
}
