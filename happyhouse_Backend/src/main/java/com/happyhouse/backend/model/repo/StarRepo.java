package com.happyhouse.backend.model.repo;

import com.happyhouse.backend.dto.Star;

public interface StarRepo {
	int insertStar(Star star);

	int deleteStar(String no);

	Star getStar(String no);

	int changeStar(Star star);
}
