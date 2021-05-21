package com.happyhouse.backend.dto;

public class House {
	private String name;
	private String dong;
	private String lat;
	private String lng;
	
	public House() {
		super();
	}
	
	public House(String name, String dong, String lat, String lang) {
		super();
		this.name = name;
		this.dong = dong;
		this.lat = lat;
		this.lng = lang;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "House [name=" + name + ", dong=" + dong + ", lat=" + lat + ", lng=" + lng + "]";
	}


	
	
	
}
