package com.happyhouse.backend.model.repo;

import java.util.List;

import com.happyhouse.backend.dto.House;

public interface HouseRepo {
	
	List<House> getHouse(String dong);
}
