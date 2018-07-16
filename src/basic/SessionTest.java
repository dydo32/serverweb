package basic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionTest")
public class SessionTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		//세션객체를 생성
		HttpSession ses = request.getSession();
		//세션에 데이터 공유
		ses.setAttribute("mydata", id);	//여러개 저장해도됨
		//request.setAttribute("mydata", id); -> 안됨

		RequestDispatcher rd = request.getRequestDispatcher("/servlettest/ses_first.jsp");
		rd.forward(request, response);
	}
}
