package com.rmgx.assignment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmgx.assignment.entity.Asset;

public interface AssetRepo extends JpaRepository<Asset, Long> {

	List<Asset> findByName(String name);

}
