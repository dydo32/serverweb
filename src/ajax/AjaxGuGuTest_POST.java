package ajax;
//ajax�� �ƴϵ� �������� ��û
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
		//Ajax�� �̿��ؼ� ��밡�� ���̵� �ľ�
		
		//5. �������� request�� ����
		//6. request�� ó���ؼ� Ŭ���̾�Ʈ���� ������
		response.setContentType("text/html;charset=euc-kr");
		//response�� ������� ����
		//html�� ��û�ϴ� ���� �������ҽ��� ��û�ϴ� �۾��̰� ��û�� �ɶ����� ��������
		//�۾��� �����ϰ� �����ؼ� ����� �����´�. �̸� ��ȿ�����̶� �Ǵ��ؼ�
		//�⺻������ ������ ��û�� �������� ĳ������ �����ϰ� �ִ� ������ �����ش�.
		//����� ĳ���� �����ϸ� ���� ��û�� ���� ����� �ȳ��� �� �ֱ� ������
		//�������� ĳ���� �������� �ʰ� �������� ���û�ϵ��� ������� ����
		response.setHeader("cache-control", "no-cache,no-store");
		PrintWriter pw = response.getWriter();
		int num = Integer.parseInt(request.getParameter("num"));
		String msg = "";
		for(int i=1;i<10;i++){
			String str = num +"*"+ i + "=" + num*i;
			msg = msg + str + "<br/>" ;
		}
		
		System.out.println("post������� ajax��û=>"+msg);
		pw.println(msg);
	
	}
}
