package com.happyhouse.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.backend.dto.Notice;
import com.happyhouse.backend.model.service.NoticeService;


@RequestMapping("/notice")
@CrossOrigin("*")
@RestController
public class NoticeRestController {

	@Autowired
	NoticeService noticeService;
	
	@PostMapping("/insert")
	public int insert(@RequestBody Notice notice) {
		
		System.out.println(notice);
		
		if(true) {
			//System.out.println(등록 성공);
			return 200;
		}else {
			return 400;
		}
	}
	
	@PutMapping("/update")
	public int update(@RequestBody Notice notice) {
		
		if(true) {
			//System.out.println(등록 성공);
			return 200;
		}else {
			return 400;
		}
	}
	
	@DeleteMapping("/delete/{no}")
	public int delete(@PathVariable String no) {
		
		if(true) {
			//System.out.println(등록 성공);
			return 200;
		}else {
			return 400;
		}
	}
	
	@GetMapping("/search")
	public List<Notice> selectAll() {
		System.out.println("in check");
		List<Notice> list = noticeService.selectAll();
		return list;
	}

}