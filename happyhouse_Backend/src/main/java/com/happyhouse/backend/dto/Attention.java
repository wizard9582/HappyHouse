package com.happyhouse.backend.dto;

public class Attention {
	private String dong;
	private String gugun;
	
	public Attention() {
		super();
	}
	
	public Attention(String dong, String gugun) {
		super();
		this.dong = dong;
		this.gugun = gugun;
	}
	
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	@Override
	public boolean equals(Object obj) {
		Attention a = (Attention)obj;
		
		if(dong.equals(a.dong) &&gugun.equals(a.gugun)) return true;
		return false;
	}
	
	
	
}
