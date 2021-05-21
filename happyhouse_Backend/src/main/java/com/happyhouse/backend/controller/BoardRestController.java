package com.happyhouse.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.backend.dto.Board;
import com.happyhouse.backend.model.service.BoardService;

@RequestMapping("/board")
@RestController
public class BoardRestController {

	@Autowired
	BoardService boardService;
	
	@PostMapping("/")
	public int insert(Board board) {
		return boardService.insert(board);
	}
	
	@PutMapping("/")
	public int update(Board board) {
		return boardService.update(board);
	}
	
	@DeleteMapping("/book/{no}")
	public int delete(@PathVariable String no) {
		return boardService.delete(no);
		 
	}
	
	@GetMapping("/book/{no}")
	public Board select(@PathVariable String no) {
		return boardService.select(no);
		
	}
	
	@GetMapping("/book")
	public List<Board> selectAll() {
		List<Board> list = boardService.selectAll();
		return list;
	}
}