package com.happyhouse.backend.model.service;

import java.util.List;

import com.happyhouse.backend.dto.Notice;

public interface NoticeService {

	int insert(Notice notice);

	int update(Notice notice);

	int delete(String no);
	
	List<Notice> selectAll();

	Notice detail(String no);
}
