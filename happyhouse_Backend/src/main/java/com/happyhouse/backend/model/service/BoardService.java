package com.happyhouse.backend.model.service;

import java.util.List;

import com.happyhouse.backend.dto.Board;
<<<<<<< HEAD
=======
import com.happyhouse.backend.dto.StarBoard;
>>>>>>> 58ac6d4c839690600fd608639ddb4628900ad3ef

public interface BoardService {

	int insert(Board board);

	int update(Board board);

	int delete(String no);

<<<<<<< HEAD
	Board select(String no);
=======
	 List<StarBoard> select(String apt);
>>>>>>> 58ac6d4c839690600fd608639ddb4628900ad3ef
	
	List<Board> selectAll();
}
