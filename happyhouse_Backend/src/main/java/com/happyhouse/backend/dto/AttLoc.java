package com.happyhouse.backend.dto;

public class AttLoc {
	private String name;
	private String gugun;
	private String dong;
	private String lat;
	private String lng;
	private String type;
	
	public AttLoc() {
		super();
	}
	
	public AttLoc(String name,String gugun, String dong, String lat, String lng, String type) {
		super();	
		this.name = name;
		this.gugun = gugun;
		this.dong = dong;
		this.lat = lat;
		this.lng = lng;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
