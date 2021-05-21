package com.happyhouse.backend.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.happyhouse.backend.dto.Board;
import com.happyhouse.backend.model.repo.BoardRepo;

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
	public Board select(String no) {
		// TODO Auto-generated method stub
		return repo.select(no);
	}

	@Override
	public List<Board> selectAll() {
		// TODO Auto-generated method stub
		return repo.selecAll();
	}

	
}
