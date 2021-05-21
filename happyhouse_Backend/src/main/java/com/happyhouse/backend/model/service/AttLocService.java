package com.happyhouse.backend.model.service;

import java.util.List;

import com.happyhouse.backend.dto.AttLoc;
import com.happyhouse.backend.dto.Attention;

public interface AttLocService {
	List<AttLoc> getAttLoc(Attention a);
}

