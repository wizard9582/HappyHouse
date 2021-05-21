package com.happyhouse.backend.model.repo;

import java.util.List;

import com.happyhouse.backend.dto.HouseDeal;

public interface HouseDealRepo {
	
	List<HouseDeal> getHouseDeal(String dong);
}
