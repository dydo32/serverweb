package emp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.EmpDTO;
import emp.service.EmpService;
import emp.service.EmpServiceImpl;

public class EmpInsertServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		//System.out.println("���� ��û ����");
		
		req.setCharacterEncoding("euc-kr");
	/*	res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();*/	//forward �Ŀ� �ʿ����
		
		//1. Ŭ���̾�Ʈ�� ��û���� ����
		String deptno = req.getParameter("deptno");//�μ���ȣ
		String name = req.getParameter("name"); //����
		String id = req.getParameter("id");//���
		String pass = req.getParameter("pass"); //�н�����
		String addr = req.getParameter("addr");//�ּ�
		int point = Integer.parseInt(req.getParameter("point")); //����Ʈ
		String grade = req.getParameter("grade"); //���
		
		//2. �����Ͻ� �޼ҵ� ȣ��
		EmpService service = new EmpServiceImpl();
		EmpDTO user = new EmpDTO(id, pass, name, addr, grade, point, deptno);
		int result = service.insert(user);
		
		//3. ������ ����
		String msg = "";
		if(result>=1){
			msg = result+"�� �� ���� ����";
		}else{
			msg = "���Խ���";
		}
		req.setAttribute("msg", msg);
		
		//4. ��û������ - forward
		RequestDispatcher rd = req.getRequestDispatcher("/emp/insertResult.jsp"); 
		rd.forward(req, res);
		
		//res.sendRedirect("/serverweb/basic/insertResult.html");
	}
}
