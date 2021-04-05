package com.rmgx.assignment.service;

import java.util.List;

import com.rmgx.assignment.dto.AssetDto;
import com.rmgx.assignment.entity.Asset;

public interface AssetService {
	
	public List<Asset> getAllAsset();	// method for getting all the assets stored in database
	
	public Asset addAsset(AssetDto assetDto);	// method for adding asset to database
	
	public List<Asset> searchAssetByName(String name);	//method to search an asset by name
	
	public String deleteAsset(long id);			// method for deleting an asset
	
	
}
