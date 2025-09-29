package apt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application_office.model.OfficeDTO;
import application_office.model.OfficeService;

/**
 * Servlet implementation class AdminPageServlet
 */
@WebServlet("/office/search")
public class AdminPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword = request.getParameter("columnName");
		String value = request.getParameter("inputValue");
		
		OfficeService officeService = new OfficeService();
        List<OfficeDTO> list = officeService.selectDetail(keyword, value);
        
        request.setAttribute("userinfolist", list);
        request.getRequestDispatcher("/office/userSearchResult.jsp")
        	.forward(request, response);
		System.out.println(keyword);
		System.out.println(value);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}
