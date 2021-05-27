package com.happyhouse.backend.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.backend.dto.House;
import com.happyhouse.backend.dto.HouseDeal;
import com.happyhouse.backend.model.service.AddressService;
import com.happyhouse.backend.model.service.HouseDealService;
import com.happyhouse.backend.model.service.HouseService;
import com.happyhouse.backend.model.service.UserService;

@RestController
@RequestMapping("/house")
@CrossOrigin("*")
public class HouseRestController {
	@Autowired
	AddressService addressservice;
	@Autowired
	HouseDealService dealservice;
	@Autowired
	HouseService houseservice;
	@Autowired
	UserService userservice;

	@GetMapping("/addrInfo/{city}")
	public List<String> getInfoGugun(@PathVariable String city) {
		List<String> list = addressservice.getInfoGugun(city);
		return list;
	}

	@GetMapping("/addrInfo/{city}/{gugun}")
	public List<String> getInfoDong(@PathVariable String city, @PathVariable String gugun) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("city", city);
		map.put("gugun", gugun);
		List<String> list = addressservice.getInfoDong(map);
		return list;
	}
	
	@GetMapping("/houseInfo/{dong}")
	public List<House> getHouse(@PathVariable String dong) {
		return houseservice.getHouse(dong);
	}
	
	@GetMapping("/houseDeal/{aptName}")
	public List<HouseDeal> getDeal(@PathVariable String aptName) {
		
		System.out.println("this ---->" + aptName);
		
		return dealservice.getHouseDeal(aptName);
	}
}
