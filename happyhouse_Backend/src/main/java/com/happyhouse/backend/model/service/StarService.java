package com.happyhouse.backend.model.service;

import java.util.List;

import com.happyhouse.backend.dto.Star;

public interface StarService {
	int insertStar(Star star);

	int deleteStar(String no);

	Star getStar(String no);

	int changeStar(Star star);
	
	List<Star> selectAll();
}
