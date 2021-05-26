package com.happyhouse.backend.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.happyhouse.backend.model.service.JwtService;
import com.happyhouse.backend.model.service.UserService;

@RequestMapping("/user")
@CrossOrigin("*")
@RestController
public class UserRestController {

	@Autowired
	private JwtService jwtService;

	@Autowired
	UserService userService;

	// JWT나 Session 관련으로 로그인 정보유지기능 추가해야됨.
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> getUser(@RequestBody User user, HttpServletResponse res) {
		System.out.println(user.getId());
		
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		
		try {
			User loginUser = userService.getUser(user.getId());
			
			if(loginUser!=null && loginUser.getPass().equals(user.getPass())) {
				String token = jwtService.create(loginUser);
				res.setHeader("jwt-auth-token", token);
				
				resultMap.put("status", true);
				resultMap.put("token", token);
				resultMap.put("data", loginUser);
				status = HttpStatus.ACCEPTED;
			}else {
				resultMap.put("message", "wrong id or password");
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
			
		}catch (RuntimeException e){
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String,Object>>(resultMap,status);
	}

	@GetMapping("/duplecheck/{id}")
	public int dupleCheck(@PathVariable String id) {

		User result = userService.getUser(id);

		if (result == null) {
			// System.out.println("중복체크 통과");
			return 200;
		} else {
			// System.out.println("중복걸림");
			return 400;
		}
	}
	
	@GetMapping("/info/{id}")
	public User getInfo(@PathVariable String id) {

		return userService.getUser(id);
	}

	@Transactional
	@PostMapping("/signup")
	public int insert(@RequestBody User user) {
		System.out.println(user);
		int result = userService.insertUser(user);

		if (result == 1) {
			// System.out.println("가입성공");
			return 200;
		} else {
			// System.out.println("가입실패");
			return 400;
		}
	}

	@Transactional
	@PutMapping("/edit")
	public int update(@RequestBody User user) {

		int result = userService.changeUser(user);

		if (result == 1) {
			// System.out.println("수정성공");
			return 200;
		} else {
			// System.out.println("수정실패");
			return 400;
		}
	}

	@Transactional
	@DeleteMapping("/delete")
	public int delete(@RequestBody User user) {

		int result = userService.deleteUser(user.getId());

		if (result == 1) {
			// System.out.println("삭제성공");
			return 200;
		} else {
			// System.out.println("삭제실패");
			return 400;
		}
	}

}
