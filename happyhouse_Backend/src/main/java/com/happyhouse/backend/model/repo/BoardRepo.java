package com.happyhouse.backend.model.repo;

import java.util.List;
import com.happyhouse.backend.dto.Board;
import com.happyhouse.backend.dto.StarBoard;

public interface BoardRepo {
	
	int insert(Board board);

	int update(Board board);

	int delete(String no);

	 List<StarBoard> select(String apt);
	
	List<Board> selectAll();
}


