package com.shinhan.controller5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadStartServlet
 */
@WebServlet("/download.do")
public class DownloadStartServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("fileName");
		response.setContentType("text/html; charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attach;fileName=" + fileName);
		
		
		String path = getServletContext().getRealPath("uploadLocation");
		String douwnloadFile = path + "/" + fileName;
		File file =  new File(douwnloadFile);		// 읽을 파일
		OutputStream out = response.getOutputStream();		// 브라우저의 다운로드위치에 출력할 예정
		FileInputStream fi = new FileInputStream(file);
		byte[] buffer = new byte[1024*8]; 	// 8k
		while(true) {
			int sz = fi.read(buffer);
			if(sz==-1)break;
			out.write(buffer,0,sz);
		}
		fi.close();
		out.close();
	}


}
