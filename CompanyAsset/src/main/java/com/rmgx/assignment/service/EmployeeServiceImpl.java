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
		    org.slf4j.LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepo emplRepo;
	
	@Autowired
	private AssetRepo assetRepo;
	
	@Override
	public Employee addEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		employee.setName(employeeDto.getName());
		employee.setDesignation(employeeDto.getDesignation());
		return emplRepo.save(employee);
	}

	@Override
	public Employee searchEmployeeById(long id) {
		Employee employee = emplRepo.findById(id).get();
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
		Employee employee = emplRepo.findById(assignDto.getEmployeeId()).get();
		Asset asset = assetRepo.findById(assignDto.getAssetId()).get();
		Set<Asset> assets = employee.getAssets();
		if(asset!=null && employee!=null && (asset.getAssignment_status().equals("Available")||asset.getAssignment_status().equals("Recovered"))) {
		asset.setEmployee(employee);
		asset.setConditionnotes(assignDto.getCondtionNote());
		asset.setPurchasedate(ZonedDateTime.now().toInstant().toEpochMilli());
		asset.setAssignment_status("Assigned");
		assets.add(asset);
		}
		employee.setAssets(assets);
		assetRepo.save(asset);
		Employee saved = emplRepo.save(employee);
		return saved;
	}
	
	@Override
	public Employee recoverAsset(RecoverDto recoverDto) {
		Employee employee = emplRepo.findById(recoverDto.getEmployeeId()).get();
		Asset asset = assetRepo.findById(recoverDto.getAssetId()).get();
		Set<Asset> assets = employee.getAssets();
		if(asset!=null && employee!=null) {
			
			asset.setEmployee(null);
			asset.setConditionnotes(null);
			asset.setPurchasedate(null);
			asset.setAssignment_status("Recovered");
			for(Asset myasset:assets) {
				if(myasset.getId()==asset.getId()) {
					boolean remove = assets.remove(myasset);
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
