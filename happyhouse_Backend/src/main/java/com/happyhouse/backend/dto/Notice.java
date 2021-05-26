package com.happyhouse.backend.dto;

import java.sql.Date;

public class Notice {
    private String no;
    private Date date;
    private String title;
    private String content;
    
	public Notice() {
		super();
	}

	public Notice(String no, Date date, String title, String content) {
		super();
		this.no = no;
		this.date = date;
		this.title = title;
		this.content = content;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Notice [no=" + no + ", date=" + date + ", title=" + title + ", content=" + content + "]";
	}
    
	
    
}
