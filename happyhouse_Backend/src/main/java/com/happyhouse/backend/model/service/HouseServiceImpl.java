package com.happyhouse.backend.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.happyhouse.backend.dto.House;
import com.happyhouse.backend.model.repo.HouseRepo;

@Service
public class HouseServiceImpl implements HouseService{
	private static final Logger logger = LoggerFactory.getLogger(HouseServiceImpl.class);
	private HouseRepo repo;
	
	@Autowired
	ResourceLoader resLoader;
	
	@Autowired
	public void setHouseRepo(HouseRepo repo) {
		this.repo = repo;
	}

	public HouseRepo getHouseRepo() {
		return repo;
	}

	@Override
	public List<House> getHouse(String dong) {
		return repo.getHouse(dong);
	}

}
