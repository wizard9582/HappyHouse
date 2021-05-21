package com.happyhouse.backend.dto;

public class Star {
	private int no;
	private int als;
	private int sft;
	private int trf;
	private int env;
	private int cvn;
	private int mng;
	
	public Star() {
		super();
	}

	public Star(int no, int als, int sft, int trf, int env, int cvn, int mng) {
		super();
		this.no = no;
		this.als = als;
		this.sft = sft;
		this.trf = trf;
		this.env = env;
		this.cvn = cvn;
		this.mng = mng;
	}

	
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getAls() {
		return als;
	}

	public void setAls(int als) {
		this.als = als;
	}

	public int getSft() {
		return sft;
	}

	public void setSft(int sft) {
		this.sft = sft;
	}

	public int getTrf() {
		return trf;
	}

	public void setTrf(int trf) {
		this.trf = trf;
	}

	public int getEnv() {
		return env;
	}

	public void setEnv(int env) {
		this.env = env;
	}

	public int getCvn() {
		return cvn;
	}

	public void setCvn(int cvn) {
		this.cvn = cvn;
	}

	public int getMng() {
		return mng;
	}

	public void setMng(int mng) {
		this.mng = mng;
	}

	@Override
	public String toString() {
		return "Star [als=" + als + ", sft=" + sft + ", trf=" + trf + ", env=" + env + ", cvn=" + cvn + ", mng=" + mng
				+ "]";
	}
	
}
