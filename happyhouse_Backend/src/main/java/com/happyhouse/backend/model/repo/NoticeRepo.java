package com.happyhouse.backend.model.repo;

import java.util.List;
import com.happyhouse.backend.dto.Notice;

public interface NoticeRepo {
	
	int insert(Notice notice);

	int update(Notice notice);

	int delete(String no);
	
	List<Notice> selectAll();

	Notice detail(String no);
}