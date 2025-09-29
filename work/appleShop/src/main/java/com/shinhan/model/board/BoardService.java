package com.shinhan.model.board;

import java.util.List;

public class BoardService {
	BoardDAO boardDAO = new BoardDAO();
	
	public List<BoardDTO> selectAll() {
		return boardDAO.selectAll();
		
	}
	
	public BoardDTO selectById(int bno) {
		return boardDAO.selectById(bno);
	}
	
	public int insertBoard(BoardDTO board) {
		return boardDAO.insertBoard(board);
	}
	
	
}
