package com.happyhouse.backend.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.happyhouse.backend.dto.AttLoc;
import com.happyhouse.backend.dto.Attention;
import com.happyhouse.backend.model.repo.AttLocRepo;

@Service
public class AttLocServiceImpl implements AttLocService {
	private static final Logger logger = LoggerFactory.getLogger(AttLocServiceImpl.class);
	private AttLocRepo repo;

	@Autowired
	ResourceLoader resLoader;

	@Autowired
	public void setAttLocRepo(AttLocRepo repo) {
		this.repo = repo;
	}

	public AttLocRepo getAttLocRepo() {
		return repo;
	}

	@Override
	public List<AttLoc> getAttLoc(Attention a) {
		return repo.getAttLoc(a);
	}

}
