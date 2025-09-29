package com.shinhan.controller5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.board.BoardService;

/**
 * Servlet implementation class DownloadStartServlet
 */
@WebServlet("/downloadDisplay.do")
public class DownloadServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardService boardService = new BoardService();
		request.setAttribute("boardList", boardService.selectAll());
		
		request.getRequestDispatcher("upload/downLoadForm.jsp").forward(request, response);
	}


}
