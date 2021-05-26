package com.happyhouse.backend.model.service;

import java.util.List;

import com.happyhouse.backend.dto.HouseDeal;

public interface HouseDealService {

	List<HouseDeal> getHouseDeal(String aptname);
}
