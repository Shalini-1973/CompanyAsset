package com.rmgx.assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmgx.assignment.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
