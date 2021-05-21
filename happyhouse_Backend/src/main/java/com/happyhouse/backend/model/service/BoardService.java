package com.happyhouse.backend.model.service;

import java.util.List;

import com.happyhouse.backend.dto.Board;

public interface BoardService {

	int insert(Board board);

	int update(Board board);

	int delete(String no);

	Board select(String no);
	
	List<Board> selectAll();
}
