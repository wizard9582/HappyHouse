package com.happyhouse.backend.model.repo;

import java.util.List;

import com.happyhouse.backend.dto.Board;

public interface BoardRepo {
	
	int insert(Board board);

	int update(Board board);

	int delete(String no);

	Board select(String no);
	
	List<Board> selecAll();
}


