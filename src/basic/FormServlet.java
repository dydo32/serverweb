package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//System.out.println("서블릿 요청 성공");	
		
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		
		String name = req.getParameter("name");
		String addr = req.getParameter("addr");
		String[] language = req.getParameterValues("language");
		String save = req.getParameter("save");
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2> client form data 처리 </h2>");

		out.println("<ul>");
		out.println("<li>이름: ");
		if(name.equals("")){
			out.println("<이름을 입력하세요></li>");
		}else{
			out.println(name+"</li>");
		}
		
		out.println("<li>주소: ");
		if(addr.equals("")){
			out.println("<주소을 입력하세요></li>");
		}else{
			out.println(addr+"</li>");
		}
		
		out.println("사용가능한 Language 선택. <br/>");
		if(language==null){
			out.println("<li>사용 가능한 language가 없습니다</li>");
		}else{
			for(int i=0; i<language.length; i++){
				out.print("<li>"+language[i]+"</li>");
			}
		}
		
		out.println("<li>입력 정보 저장유무:");
		if(save==null){
			out.println("입력정보 저장유무를 선택하세요</li>");
		}else{
			out.println(save+"</li>");
		}
		
		out.println("</ul>");
		
		out.println("</body>");
		out.println("</html>");

	}
}
