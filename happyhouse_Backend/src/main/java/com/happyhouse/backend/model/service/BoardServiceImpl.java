package com.happyhouse.backend.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD

import com.happyhouse.backend.dto.Board;
import com.happyhouse.backend.model.repo.BoardRepo;

=======
import org.springframework.stereotype.Service;

import com.happyhouse.backend.dto.Board;
import com.happyhouse.backend.dto.StarBoard;
import com.happyhouse.backend.model.repo.BoardRepo;

@Service
>>>>>>> 58ac6d4c839690600fd608639ddb4628900ad3ef
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepo repo;
	
	@Override
	public int insert(Board board) {
		// TODO Auto-generated method stub
		return repo.insert(board);
	}

	@Override
	public int update(Board board) {
		// TODO Auto-generated method stub
		return repo.update(board);
	}

	@Override
	public int delete(String no) {
		// TODO Auto-generated method stub
		return repo.delete(no);
	}

	@Override
<<<<<<< HEAD
	public Board select(String no) {
		// TODO Auto-generated method stub
		return repo.select(no);
=======
	public List<StarBoard> select(String apt) {
		// TODO Auto-generated method stub
		return repo.select(apt);
>>>>>>> 58ac6d4c839690600fd608639ddb4628900ad3ef
	}

	@Override
	public List<Board> selectAll() {
		// TODO Auto-generated method stub
<<<<<<< HEAD
		return repo.selecAll();
=======
		return repo.selectAll();
>>>>>>> 58ac6d4c839690600fd608639ddb4628900ad3ef
	}

	
}
