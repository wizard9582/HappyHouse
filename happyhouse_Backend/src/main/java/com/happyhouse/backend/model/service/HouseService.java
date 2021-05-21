package com.happyhouse.backend.model.service;

import java.util.List;

import com.happyhouse.backend.dto.House;

public interface HouseService {
	
	List<House> getHouse(String dong);
}

