package com.happyhouse.backend.dto;

public class HouseDeal {
	private String name;
	private String price;
	private String area;
	private String date;
	
	
	@Override
	public String toString() {
		return "HouseDeal [name=" + name + ", price=" + price + ", area=" + area + ", date=" + date + "]";
	}
	
	public HouseDeal() {
		super();
	}

	public HouseDeal(String name, String price, String area, String date) {
		super();
		this.name = name;
		this.price = price;
		this.area = area;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
