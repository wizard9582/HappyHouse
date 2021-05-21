package com.happyhouse.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.backend.dto.User;
import com.happyhouse.backend.model.service.UserService;

@RequestMapping("/user")
@CrossOrigin("*")
@RestController
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	// JWT나 Session 관련으로 로그인 정보유지기능 추가해야됨.
	@PostMapping("/login")
	public int getUser(@RequestBody User user) {
		System.out.println(user.getId());
		
		User result = userService.getUser(user.getId());
		
		if(result != null) {
			//System.out.println("로그인 성공");
			return 200;
		}else {
			//System.out.println("로그인실패");
			return 400;
		}
	}
	
	@GetMapping("/duplecheck/{id}")
	public int dupleCheck(@PathVariable String id) {
		
		User result = userService.getUser(id);
		
		if(result == null) {
			//System.out.println("중복체크 통과");
			return 200;
		}else {
			//System.out.println("중복걸림");
			return 400;
		}
	}
	
	@Transactional
	@PostMapping("/signup")
	public int insert(@RequestBody User user) {

		int result = userService.insertUser(user);
		
		if(result == 1) {
			//System.out.println("가입성공");
			return 200;
		}else {
			//System.out.println("가입실패");
			return 400;
		}
	}
	
	@Transactional
	@PutMapping("/edit")
	public int update(@RequestBody User user) {

		int result = userService.changeUser(user);
		
		if(result == 1) {
			//System.out.println("수정성공");
			return 200;
		}else {
			//System.out.println("수정실패");
			return 400;
		}
	}
	
	@Transactional
	@DeleteMapping("/delete")
	public int delete(@RequestBody User user) {

		int result = userService.deleteUser(user.getId());
		
		if(result == 1) {
			//System.out.println("삭제성공");
			return 200;
		}else {
			//System.out.println("삭제실패");
			return 400;
		}
	}

}
