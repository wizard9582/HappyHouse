package com.happyhouse.backend.dto;

public class User {
	private String id;
	private String name;
	private String pass;
	private String nick;
	private String address;
	private String phone;
	
	public User() {
		super();
	}
	public User(String id, String name, String pass, String nick, String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.nick = nick;
		this.address = address;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pass=" + pass + ", nick=" + nick + ", address=" + address
				+ ", phone=" + phone + "]";
	}
	
	
	
}
