package com.rmgx.assignment.service;

import java.time.ZonedDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmgx.assignment.dto.AssignDto;
import com.rmgx.assignment.dto.EmployeeDto;
import com.rmgx.assignment.dto.RecoverDto;
import com.rmgx.assignment.entity.Asset;
import com.rmgx.assignment.entity.Employee;
import com.rmgx.assignment.repo.AssetRepo;
import com.rmgx.assignment.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final org.slf4j.Logger log = 
		    org.slf4j.LoggerFactory.getLogger(EmployeeServiceImpl.class);	// declared an instance of Slf4j logger to create logs
	
	@Autowired
	private EmployeeRepo emplRepo;
	
	@Autowired
	private AssetRepo assetRepo;
	
	@Override
	public Employee addEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();		// created an object of Employee using default constructor
		employee.setName(employeeDto.getName());
		employee.setDesignation(employeeDto.getDesignation());
		return emplRepo.save(employee);
	}

	@Override
	public Employee searchEmployeeById(long id) {
		Employee employee = emplRepo.findById(id).get();   // used Jpa findById method for finding an employee
		return employee;
	}

	@Override
	public String deleteEmployeeId(long id) {
		Employee employee = emplRepo.findById(id).get();
		if(employee.getAssets()==null) {
			emplRepo.deleteById(id);
			return "employee deleted";
		}
		return "can't delete assigned an asset";
	}

	@Override
	public Employee assignAsset(AssignDto assignDto) {
		Employee employee = emplRepo.findById(assignDto.getEmployeeId()).get();	// get the employee of the id  coming in assignDto
		Asset asset = assetRepo.findById(assignDto.getAssetId()).get();		// get the asset of the id coming in assetDto
		Set<Asset> assets = employee.getAssets();
		if(asset!=null && employee!=null && (asset.getAssignment_status().equals("Available")||asset.getAssignment_status().equals("Recovered"))) {
		asset.setEmployee(employee);			// validate the asset and employee and status of the asset
		asset.setConditionnotes(assignDto.getCondtionNote());
		asset.setPurchasedate(ZonedDateTime.now().toInstant().toEpochMilli());	// update purchased date to current date
		asset.setAssignment_status("Assigned");					// update the asset status to assigned
		assets.add(asset);
		}
		employee.setAssets(assets);
		assetRepo.save(asset);
		Employee saved = emplRepo.save(employee);
		return saved;
	}
	
	@Override
	public Employee recoverAsset(RecoverDto recoverDto) {
		Employee employee = emplRepo.findById(recoverDto.getEmployeeId()).get();	// get the employee by id coming in recoverDto
		Asset asset = assetRepo.findById(recoverDto.getAssetId()).get();		// get the asset by it coming in recoverDto
		Set<Asset> assets = employee.getAssets();					// get all the asset assigned to the employee
		if(asset!=null && employee!=null) {						// validated the employee and asset
			
			asset.setEmployee(null);
			asset.setConditionnotes(null);
			asset.setPurchasedate(null);
			asset.setAssignment_status("Recovered");
			for(Asset myasset:assets) {						// searching for asset in list of assigned asset
				if(myasset.getId()==asset.getId()) {
					boolean remove = assets.remove(myasset);		// after searching removed it from the list
					if(remove) {
						log.info("asset recovered successfully");
					}else {
						log.info("unable to recover asset");
					}
				}
			}
		}
		
		employee.setAssets(assets);
		assetRepo.save(asset);
		Employee saved = emplRepo.save(employee);
		if(saved!=null) {
			log.info("employee saved successfully");
		}else {
			log.info("unable to add employee to the database");
		}
		
		return saved;
	}



}
