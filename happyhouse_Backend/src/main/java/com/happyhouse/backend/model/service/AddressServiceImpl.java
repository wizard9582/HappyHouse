package com.happyhouse.backend.model.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.happyhouse.backend.model.repo.AddressRepo;

@Service
public class AddressServiceImpl implements AddressService {
	
	private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);
	private AddressRepo repo;
	
	@Autowired
	ResourceLoader resLoader;
	
	@Autowired
	public void setAddressRepo(AddressRepo repo) {
		this.repo = repo;
	}

	public AddressRepo getAddressRepo() {
		return repo;
	}

	@Override
	public List<String> getInfoGugun(String city) {
		return repo.getInfoGugun(city);
	}

	@Override
	public List<String> getInfoDong(HashMap<String, Object> map) {
		return repo.getInfoDong(map);
	}
}
