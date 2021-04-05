package com.rmgx.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rmgx.assignment.dto.AssetDto;
import com.rmgx.assignment.entity.Asset;
import com.rmgx.assignment.service.AssetServiceImpl;
@Controller
public class AssetController {
	
	@Autowired
	private AssetServiceImpl service;
	
	
	@PostMapping("/addAsset")  									// handling request for adding an asset
	public Asset addAsset(@RequestBody AssetDto assetDto){
		
		Asset addAsset = service.addAsset(assetDto);			// a service method called for adding asset to the database
		return addAsset;
	}
	
	@PostMapping("/findAllAsset")								 // handles request for fetching all assets list
	public ResponseEntity<List<Asset>> findAllAsset(){
		
		List<Asset> allAsset = service.getAllAsset();			// a service method called for fetching all assets stored in database.
																//It returns a list of assets			
		return ResponseEntity.ok(allAsset);
	}
	
	@PostMapping("/findAssetByName")						// handle request for fetching asset by name
	public ResponseEntity<List<Asset>> findAssetByName(@RequestParam("userName") String userName){
		
		List<Asset> assets = service.searchAssetByName(userName); // a service method called for searching the assets matches to the name coming in url
		return ResponseEntity.ok(assets);
	}
	
	@PostMapping("/deleteAsset")
	public ResponseEntity<String> deleteAsset(@RequestParam(value="asset_id") long id){
		String deleteAsset = service.deleteAsset(id);
		return ResponseEntity.ok(deleteAsset);
	}
 
}
