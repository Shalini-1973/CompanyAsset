package com.rmgx.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AssignDto {
	
	private long employeeId;
	private long assetId;
	private String condtionNote;
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public long getAssetId() {
		return assetId;
	}
	public void setAssetId(long assetId) {
		this.assetId = assetId;
	}
	public String getCondtionNote() {
		return condtionNote;
	}
	public void setCondtionNote(String condtionNote) {
		this.condtionNote = condtionNote;
	}
	
	
	
}
