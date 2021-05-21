package com.happyhouse.backend.model.service;

import java.util.HashMap;
import java.util.List;

public interface AddressService {
	
	List<String> getInfoGugun(String city);
	List<String> getInfoDong(HashMap<String, Object> map);
}
