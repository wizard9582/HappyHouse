package com.happyhouse.backend.dto;

import java.sql.Date;

public class Board {
    private String no;
    private String apt;
    private String author;
    private Date date;
<<<<<<< HEAD
=======
    private String title;
>>>>>>> 58ac6d4c839690600fd608639ddb4628900ad3ef
    private String content;
    
	public Board() {
		super();
	}
<<<<<<< HEAD
	public Board(String no, String apt, String author, Date date, String content) {
		super();
=======
	public Board(String no, String apt, String author, Date date, String title, String content) {
		super();
		this.title = title;
>>>>>>> 58ac6d4c839690600fd608639ddb4628900ad3ef
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
	
<<<<<<< HEAD
=======
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
>>>>>>> 58ac6d4c839690600fd608639ddb4628900ad3ef
	@Override
	public String toString() {
		return "Board [no=" + no + ", apt=" + apt + ", author=" + author + ", date=" + date + ", content=" + content
				+ "]";
	}
    
}
