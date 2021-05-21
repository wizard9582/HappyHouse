package com.happyhouse.backend.model.repo;

import com.happyhouse.backend.dto.User;

public interface UserRepo {
	int insertUser(User user);

	int deleteUser(String id);

	User getUser(String id);

	int changeUser(User user);
}
