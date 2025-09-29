package com.shinhan.SimpleBoard;

import java.util.List;

public class SimpleBoardService {
	SimpleBoardDAO simpleBoardDAO = new SimpleBoardDAO();

	public List<SimpleBoardDTO> selectAll() {
		return simpleBoardDAO.selectAll();
	}

	public List<SimpleBoardDTO> selectByWriter(String writer) {
		return simpleBoardDAO.selectByWriter(writer);
	}

	public List<SimpleBoardDTO> selectByTitle(String title) {
		return simpleBoardDAO.selectByTitle(title);
	}

	public List<SimpleBoardDTO> selectByContents(String contents) {
		return simpleBoardDAO.selectByContents(contents);
	}

	public List<SimpleBoardDTO> selectByTitleAndContents(String writer, String contents) {
		return simpleBoardDAO.selectByTitleAndContents(writer, contents);
	}

	public int deleteByNum(int num) {
		return simpleBoardDAO.deleteBoard(num);
	}

	public int boardUpdate(SimpleBoardDTO board) {
		return simpleBoardDAO.boardUpdate(board);
	}

	public SimpleBoardDTO selectBoard(String writer, int bno, String title) {
		return simpleBoardDAO.selectBoard(writer, bno, title);
	}

	public int insertPost(SimpleBoardDTO sb) {
		return simpleBoardDAO.insertPost(sb);
	}
}
