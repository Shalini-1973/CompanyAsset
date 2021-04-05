package com.rmgx.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmgx.assignment.CompanyAssetApplication;
import com.rmgx.assignment.dto.AssetDto;
import com.rmgx.assignment.entity.Asset;
import com.rmgx.assignment.entity.Category;
import com.rmgx.assignment.repo.AssetRepo;
import com.rmgx.assignment.repo.CategoryRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AssetServiceImpl implements AssetService {
	
	private static final org.slf4j.Logger log = 
		    org.slf4j.LoggerFactory.getLogger(AssetServiceImpl.class);

	
	
	@Autowired 
	private AssetRepo repository;

	@Autowired
	private CategoryRepo cat_repo;
	
	@Override
	public List<Asset> getAllAsset() {	// implementation of method for returning all the assets list
		return repository.findAll();
	}

	@Override
	public Asset addAsset(AssetDto assetDto) {	// implementation of method for adding asset to database
		Asset newAsset = new Asset();
		newAsset.setName(assetDto.getName());
		newAsset.setAssignment_status("Available");
		Category category = cat_repo.findById(assetDto.getCategory_id()).get();
		newAsset.setCategory(category);
		newAsset.setPurchasedate(null);;
		newAsset.setConditionnotes(null);;
		System.out.println(newAsset.toString());
		Asset savedAsset = repository.save(newAsset);
		if(savedAsset!=null) {
			log.info("asset is added to the database");
		}else {
			log.info("error in saving asset to database");
		}
		System.out.println(savedAsset.toString());
		
		return savedAsset;
	}

	@Override
	public List<Asset> searchAssetByName(String name) {	// implementation of method for searching asset by name
		return repository.findByName(name);
	}

	@Override
	public String deleteAsset(long id) {			// implementation of method for deleting asset
		Asset asset = repository.findById(id).get();
		if(asset.getAssignment_status().equals("Assigned")) {
			log.info("employee is assing to an asset, so can't delete");
			return "Can't delete the asset, it is assigned";
		}
		log.info("asset deleted");
		repository.delete(asset);;
		return "Asset Deleted";
	}

}
