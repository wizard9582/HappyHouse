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
import com.happyhouse.backend.dto.Star;
import com.happyhouse.backend.dto.StarBoard;
import com.happyhouse.backend.model.service.BoardService;
import com.happyhouse.backend.model.service.StarService;

@RequestMapping("/notice")
@CrossOrigin("*")
@RestController
public class NoticeRestController {

	@Autowired
	BoardService boardService;
	@Autowired
	StarService starService;
	
	@PostMapping("/insert")
	public int insert(@RequestBody Board board) {
		
		System.out.println(board);
		
		if(true) {
			//System.out.println(등록 성공);
			return 200;
		}else {
			return 400;
		}
	}
	
	@PutMapping("/update")
	public int update(@RequestBody Board board) {
		
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
	
	
	@GetMapping("/detail/{no}")
	public StarBoard selectNo(@PathVariable String no) {
		System.out.println("----->" + no);
		return boardService.selectNo(no);
	}
	
	@GetMapping("/search")
	public List<Board> selectAll() {
		System.out.println("in check");
		List<Board> list = boardService.selectAll();
		return list;
	}

}