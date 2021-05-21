package com.happyhouse.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.CrossOrigin;
>>>>>>> 58ac6d4c839690600fd608639ddb4628900ad3ef
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> 58ac6d4c839690600fd608639ddb4628900ad3ef
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.backend.dto.Board;
<<<<<<< HEAD
import com.happyhouse.backend.model.service.BoardService;

@RequestMapping("/board")
=======
import com.happyhouse.backend.dto.Star;
import com.happyhouse.backend.dto.StarBoard;
import com.happyhouse.backend.model.service.BoardService;
import com.happyhouse.backend.model.service.StarService;

@RequestMapping("/board")
@CrossOrigin("*")
>>>>>>> 58ac6d4c839690600fd608639ddb4628900ad3ef
@RestController
public class BoardRestController {

	@Autowired
	BoardService boardService;
<<<<<<< HEAD
	
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
=======
	@Autowired
	StarService starService;
	
	@PostMapping("/insert")
	public int insert(@RequestBody StarBoard starboard) {
		
		Board board = starboard.getBoard();
		Star star = starboard.getStar();
		
		System.out.println(board);
		System.out.println(star);
		
		int result = Math.min(boardService.insert(board), starService.insertStar(star));
		
		if(result == 1) {
			//System.out.println(등록 성공);
			return 200;
		}else {
			return 400;
		}
	}
	
	@PutMapping("/update")
	public int update(@RequestBody StarBoard starboard) {
		Board board = starboard.getBoard();
		Star star = starboard.getStar();
		
		System.out.println(board);
		System.out.println(star);
		
		int result = Math.min(boardService.update(board), starService.changeStar(star));
		
		if(result == 1) {
			//System.out.println(수정 성공);
			return 200;
		}else {
			return 400;
		}
	}
	
	@DeleteMapping("/delete/{no}")
	public int delete(@PathVariable String no) {
		
		int result = Math.min(boardService.delete(no), starService.deleteStar(no));
		
		if(result == 1) {
			//System.out.println(수정 성공);
			return 200;
		}else {
			return 400;
		}
	}
	
	@GetMapping("/search/{apt}")
	public List<StarBoard> select(@PathVariable String apt) {
		
		return boardService.select(apt);
	}
	
	@GetMapping("/search")
	public List<Board> selectAll() {
		System.out.println("in check");
>>>>>>> 58ac6d4c839690600fd608639ddb4628900ad3ef
		List<Board> list = boardService.selectAll();
		return list;
	}
}