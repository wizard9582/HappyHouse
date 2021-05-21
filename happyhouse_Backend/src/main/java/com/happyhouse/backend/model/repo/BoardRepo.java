package com.happyhouse.backend.model.repo;

import java.util.List;
<<<<<<< HEAD

import com.happyhouse.backend.dto.Board;
=======
import com.happyhouse.backend.dto.Board;
import com.happyhouse.backend.dto.StarBoard;
>>>>>>> 58ac6d4c839690600fd608639ddb4628900ad3ef

public interface BoardRepo {
	
	int insert(Board board);

	int update(Board board);

	int delete(String no);

<<<<<<< HEAD
	Board select(String no);
	
	List<Board> selecAll();
=======
	 List<StarBoard> select(String apt);
	
	List<Board> selectAll();
>>>>>>> 58ac6d4c839690600fd608639ddb4628900ad3ef
}


