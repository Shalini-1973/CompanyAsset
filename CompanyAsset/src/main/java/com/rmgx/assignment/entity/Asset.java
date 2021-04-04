package com.rmgx.assignment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private Long purchasedate;
	private String conditionnotes;

	@ManyToOne(targetEntity=Category.class, fetch=FetchType.LAZY)
    private Category category;

	private String assignment_status;

	@ManyToOne(targetEntity=Employee.class, fetch=FetchType.LAZY)
	private Employee employee;
	
/*	public Category getCategory() {
		return category;
	}
*/
	public void setCategory(Category category) {
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPurchasedate() {
		return purchasedate;
	}

	public void setPurchasedate(Long purchasedate) {
		this.purchasedate = purchasedate;
	}

	public String getConditionnotes() {
		return conditionnotes;
	}

	public void setConditionnotes(String conditionnotes) {
		this.conditionnotes = conditionnotes;
	}

	public String getAssignment_status() {
		return assignment_status;
	}

	public void setAssignment_status(String assignment_status) {
		this.assignment_status = assignment_status;
	}
/*
	public Employee getEmployee() {
		return employee;
	}
*/
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
