package com.happyhouse.backend.dto;

import java.sql.Date;

public class Board {
    private String no;
    private String apt;
    private String author;
    private Date date;
    private String content;
    
	public Board() {
		super();
	}
	public Board(String no, String apt, String author, Date date, String content) {
		super();
		this.no = no;
		this.apt = apt;
		this.author = author;
		this.date = date;
		this.content = content;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getApt() {
		return apt;
	}
	public void setApt(String apt) {
		this.apt = apt;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Board [no=" + no + ", apt=" + apt + ", author=" + author + ", date=" + date + ", content=" + content
				+ "]";
	}
    
}
