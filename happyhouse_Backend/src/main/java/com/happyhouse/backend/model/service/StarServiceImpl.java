package com.happyhouse.backend.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happyhouse.backend.dto.Star;
import com.happyhouse.backend.model.repo.StarRepo;

@Service
public class StarServiceImpl implements StarService{
	private static final Logger logger = LoggerFactory.getLogger(StarServiceImpl.class);
	private StarRepo repo;
	
	@Autowired
	ResourceLoader resLoader;
	
	@Autowired
	public void setStarRepo(StarRepo repo) {
		this.repo = repo;
	}

	public StarRepo getStarRepo() {
		return repo;
	}

	@Transactional
	@Override
	public int insertStar(Star star) {
		return repo.insertStar(star);
	}

	@Transactional
	@Override
	public int deleteStar(String no) {
		// TODO Auto-generated method stub
		return repo.deleteStar(no);
	}

	@Override
	public Star getStar(String no) {
		// TODO Auto-generated method stub
		return repo.getStar(no);
	}

	@Transactional
	@Override
	public int changeStar(Star star) {
		// TODO Auto-generated method stub
		return repo.changeStar(star);
	}

	@Override
	public List<Star> selectAll() {
		// TODO Auto-generated method stub
		return repo.selectAll();
	}
}
