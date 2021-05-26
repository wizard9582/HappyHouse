package com.happyhouse.backend.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.happyhouse.backend.dto.HouseDeal;
import com.happyhouse.backend.model.repo.HouseDealRepo;

@Service
public class HouseDealServiceImpl implements HouseDealService {

	private static final Logger logger = LoggerFactory.getLogger(HouseDealServiceImpl.class);
	private HouseDealRepo repo;

	@Autowired
	ResourceLoader resLoader;

	@Autowired
	public void setHouseDealRepo(HouseDealRepo repo) {
		this.repo = repo;
	}

	public HouseDealRepo getHouseDealRepo() {
		return repo;
	}

	@Override
	public List<HouseDeal> getHouseDeal(String aptname) {
		return repo.getHouseDeal(aptname);
	}

}
