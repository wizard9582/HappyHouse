package com.happyhouse.backend.model.repo;

import java.util.List;

import com.happyhouse.backend.dto.AttLoc;
import com.happyhouse.backend.dto.Attention;


public interface AttLocRepo {
	List<AttLoc> getAttLoc(Attention a);
}
