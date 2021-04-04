package com.rmgx.assignment.service;

import java.util.List;

import com.rmgx.assignment.dto.AssetDto;
import com.rmgx.assignment.entity.Asset;

public interface AssetService {
	
	public List<Asset> getAllAsset();
	
	public Asset addAsset(AssetDto assetDto);
	
	public List<Asset> searchAssetByName(String name);
	
	public String deleteAsset(long id);
	
	
}
