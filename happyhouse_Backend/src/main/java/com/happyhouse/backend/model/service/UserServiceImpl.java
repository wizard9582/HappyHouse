package com.happyhouse.backend.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happyhouse.backend.dto.User;
import com.happyhouse.backend.model.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private UserRepo repo;
	
	@Autowired
	ResourceLoader resLoader;
	
	@Autowired
	public void setUserRepo(UserRepo repo) {
		this.repo = repo;
	}

	public UserRepo getUserRepo() {
		return repo;
	}

	@Override
	@Transactional
	public int insertUser(User user) {
		return repo.insertUser(user);
	}

	@Override
	@Transactional
	public int deleteUser(String id) {
		return repo.deleteUser(id);
	}

	@Override
	public User getUser(String id) {
		return repo.getUser(id);
	}

	@Override
	@Transactional
	public int changeUser(User user) {
		return repo.changeUser(user);
	}
}
