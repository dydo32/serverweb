package ajax;
//ajax든 아니든 서블릿으로 요청
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ajaxgugu_post", urlPatterns = { "/ajaxgugu_post.do" })
public class AjaxGuGuTest_POST extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Ajax를 이용해서 사용가능 아이디 파악
		
		//5. 서버에서 request를 수신
		//6. request를 처리해서 클라이언트에게 보내기
		response.setContentType("text/html;charset=euc-kr");
		//response의 헤더값을 변경
		//html을 요청하는 것은 정적리소스를 요청하는 작업이고 요청이 될때마다 서버에서
		//작업을 수행하고 실행해서 결과를 가져온다. 이를 비효율적이라 판단해서
		//기본설정이 동일한 요청이 들어왔을때 캐쉬에서 저장하고 있는 파일을 보여준다.
		//결과를 캐쉬에 저장하면 다음 요청에 대한 결과가 안나올 수 있기 때문에
		//응답결과를 캐쉬에 저장하지 않고 서버에서 재요청하도록 헤더값에 설정
		response.setHeader("cache-control", "no-cache,no-store");
		PrintWriter pw = response.getWriter();
		int num = Integer.parseInt(request.getParameter("num"));
		String msg = "";
		for(int i=1;i<10;i++){
			String str = num +"*"+ i + "=" + num*i;
			msg = msg + str + "<br/>" ;
		}
		
		System.out.println("post방식으로 ajax요청=>"+msg);
		pw.println(msg);
	
	}
}
