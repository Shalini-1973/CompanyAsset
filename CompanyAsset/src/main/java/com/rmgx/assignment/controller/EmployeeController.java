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
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDto employeeDto){
		Employee addedEmployee = service.addEmployee(employeeDto);
		return ResponseEntity.ok(addedEmployee);
	}
	
	@PostMapping("/getEmployeeById")
	public ResponseEntity<Employee> getEmployeeById(@RequestParam(value="EmployeeId") long id){
		
		Employee searchedEmployee = service.searchEmployeeById(id);
		
		return ResponseEntity.ok(searchedEmployee);
	}
	
	@PostMapping("/deleteEmployeeById")
	public ResponseEntity<String> deleteEmployeeById(@RequestParam(value="EmployeeId") long id){
		String deleteEmployee = service.deleteEmployeeId(id);;
		return ResponseEntity.ok(deleteEmployee);
	}
	
	@PostMapping("/assignAsset")
	public ResponseEntity<Employee> assignAsset(@RequestBody AssignDto assignDto){
		Employee assignedAsset = service.assignAsset(assignDto);
		return ResponseEntity.ok(assignedAsset);
	}
	
	@PostMapping("/recoverAsset")
	public ResponseEntity<Employee> recoverAsset(@RequestBody RecoverDto recoverDto){
		
		Employee recoveredAsset = service.recoverAsset(recoverDto);
		return ResponseEntity.ok(recoveredAsset);
	}
}
