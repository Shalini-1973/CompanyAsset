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
	
	
	@PostMapping("/addAsset")
	public Asset addAsset(@RequestBody AssetDto assetDto){
		
		Asset addAsset = service.addAsset(assetDto);
		return addAsset;
	}
	
	@PostMapping("/findAllAsset")
	public ResponseEntity<List<Asset>> findAllAsset(){
		
		List<Asset> allAsset = service.getAllAsset();
		
		return ResponseEntity.ok(allAsset);
	}
	
	@PostMapping("/findAssetByName")
	public ResponseEntity<List<Asset>> findAssetByName(@RequestParam("userName") String userName){
		
		List<Asset> assets = service.searchAssetByName(userName);
		return ResponseEntity.ok(assets);
	}
	
	@PostMapping("/deleteAsset")
	public ResponseEntity<String> deleteAsset(@RequestParam(value="asset_id") long id){
		String deleteAsset = service.deleteAsset(id);
		return ResponseEntity.ok(deleteAsset);
	}
 
}
