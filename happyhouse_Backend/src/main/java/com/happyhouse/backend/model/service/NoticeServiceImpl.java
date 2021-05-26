package com.happyhouse.backend.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.backend.dto.Notice;
import com.happyhouse.backend.model.repo.NoticeRepo;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeRepo repo;

	@Override
	public int insert(Notice notice) {
		// TODO Auto-generated method stub
		return repo.insert(notice);
	}

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return repo.update(notice);
	}

	@Override
	public int delete(String no) {
		// TODO Auto-generated method stub
		return repo.delete(no);
	}

	@Override
	public List<Notice> selectAll() {
		// TODO Auto-generated method stub
		return repo.selectAll();
	}

	@Override
	public Notice detail(String no) {
		// TODO Auto-generated method stub
		return repo.detail(no);
	}
	
	

	
}
