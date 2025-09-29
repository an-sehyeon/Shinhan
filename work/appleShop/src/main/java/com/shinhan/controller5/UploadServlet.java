package com.shinhan.controller5;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shinhan.model.board.BoardDTO;
import com.shinhan.model.board.BoardService;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("upload/uploadForm.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String encoding = "utf-8";	
		
		// 업로드할 위치	, ./(현재밑에)는 생략가능, 현재는 웹서버의 root경로
		String uploaPath = getServletContext().getRealPath("./uploadLocation");
		// C:\\shinhanDS\\work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\appleShop\\uploadLocation
		// 웹서버 업로드 경로
		System.out.println("여기에 uploa예정 uploaPath : "+ uploaPath);
		File fileDir = new File(uploaPath);
		if(!fileDir.exists()) {
			//폴더가 존재하지 않으면 만든다.
			fileDir.mkdirs();
			System.out.println("폴더생성됨");
		}
		// 저장소에 대한 설정
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(fileDir);
		factory.setSizeThreshold(1024*1024); 	// 파일 최대 크기 지정
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items  = upload.parseRequest(request);
			Map<String, String> dataMap = new HashMap<>();
			for(FileItem fileItem:items) {
				System.out.println("-------------------------------------");
				String name = fileItem.getFieldName();	//pic1, pic2
				
				
				if(fileItem.isFormField()) {
					// type='file'가 아닌 data
					String value = fileItem.getString(encoding);	// 값(파일이름)
					System.out.println(name + "-----" + value);
					dataMap.put(name,value);
				}else {
					// <input type='file'/> upload
					String fname = fileItem.getName(); 	//파일이름
					System.out.println("이미지이름 : " + fname);
					System.out.println("이미지 사이즈 : " + fileItem.getSize());
					
					// pc경로:c:/a/b/c.jpg 
					// 		-> 파일서버:.../.../appleShop/uploadLocationc.jpg
					if(fileItem.getSize() > 0) {
						int idx = name.lastIndexOf("\\");
						if(idx == -1) { // 구분자가 없다면?
							idx = name.lastIndexOf("/"); 
						}
						
						String fileName = fname.substring(idx+1);
						File uploadFile = new File(uploaPath + "\\" + fileName);
						fileItem.write(uploadFile);		// 서버에 저장소에 파일저장
						
						dataMap.put(name,fname);
					}
				}
			}	// item의 개수만큼 Looping
			System.out.println(dataMap);
			// DB에 저장하기
			BoardDTO board = new BoardDTO();
			board.setContent(dataMap.get("content"));
			board.setWriter(dataMap.get("writer"));
			board.setTitle(dataMap.get("title"));
			board.setPic1(dataMap.get("pic1"));
			board.setPic2(dataMap.get("pic2"));
			BoardService boardService = new BoardService();
			boardService.insertBoard(board);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
