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

import com.happyhouse.backend.dto.Board;
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
		
		int result = noticeService.insert(notice);
		
		if(result == 1) {
			//System.out.println(등록 성공);
			return 200;
		}else {
			return 400;
		}
	}
	
	@PutMapping("/update")
	public int update(@RequestBody Notice notice) {
		
		int result = noticeService.update(notice);
		
		if(result == 1) {
			//System.out.println(등록 성공);
			return 200;
		}else {
			return 400;
		}
	}
	
	@DeleteMapping("/delete/{no}")
	public int delete(@PathVariable String no) {
		
		int result = noticeService.delete(no);
		
		if(result == 1) {
			//System.out.println(등록 성공);
			return 200;
		}else {
			return 400;
		}
	}
	
	@GetMapping("/search")
	public List<Notice> selectAll() {
		List<Notice> list = noticeService.selectAll();
		return list;
	}
	@GetMapping("/detail/{no}")
	public Notice select(@PathVariable String no) {

		return noticeService.detail(no);
	}
}