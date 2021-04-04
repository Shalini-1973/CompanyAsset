package com.rmgx.assignment.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.rmgx.assignment.dto.AssetDto;
import com.rmgx.assignment.entity.Asset;
import com.rmgx.assignment.entity.Category;
import com.rmgx.assignment.repo.AssetRepo;
import com.rmgx.assignment.repo.CategoryRepo;
import com.rmgx.assignment.service.AssetService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class AssetControllerTest {
	
	
	@Autowired
	private AssetService service;
	
	@MockBean
	private CategoryRepo cat;

	@MockBean
	private AssetRepo repository;
	
	@Test
	public void addAsset() {
		AssetDto assetDto = new AssetDto();
		assetDto.setName("camera");
		assetDto.setCategory_id(1);
		Asset asset = new Asset();
		Category cate = new Category();
		cate.setId(1);
		cate.setName("abcd");
		asset.setAssignment_status("Available");
		asset.setCategory(cate);
		asset.setConditionnotes(null);
		asset.setPurchasedate(null);
		
		when(repository.save(asset)).thenReturn(asset);
		assertEquals(asset, service.addAsset(assetDto));
	}

	
}
