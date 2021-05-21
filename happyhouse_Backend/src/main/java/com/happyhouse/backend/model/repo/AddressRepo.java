package com.happyhouse.backend.model.repo;

import java.util.HashMap;
import java.util.List;

public interface AddressRepo {

	public List<String> getInfoGugun(String city);
	public List<String> getInfoDong(HashMap<String, Object> map);
}
