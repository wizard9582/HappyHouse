package com.happyhouse.backend.dto;

public class HouseDeal {
	private String name;
	private String price;
	private String area;
	private String dealYear;
	private String dealMonth;
	
	
	@Override
	public String toString() {
		return "HouseDeal [name=" + name + ", price=" + price + ", area=" + area + ", date=" + dealYear + dealMonth + "]";
	}
	
	public HouseDeal() {
		super();
	}

	public HouseDeal(String name, String price, String area, String dealYear, String dealMonth) {
		super();
		this.name = name;
		this.price = price;
		this.area = area;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDealYear() {
		return dealYear;
	}

	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}

	public String getDealMonth() {
		return dealMonth;
	}

	public void setDealMonth(String dealMonth) {
		this.dealMonth = dealMonth;
	}
	
	
}
