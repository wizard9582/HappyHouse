package com.happyhouse.backend.model.service;

import com.happyhouse.backend.dto.User;

public interface UserService {
	int insertUser(User user);

	int deleteUser(String id);

	User getUser(String id);

	int changeUser(User user);
}
