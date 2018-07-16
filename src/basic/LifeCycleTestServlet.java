package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleTestServlet extends HttpServlet{
	public LifeCycleTestServlet(){
		System.out.println("LifeCycleTestServlet객체 생성");
	}
	
	public void init(){
		System.out.println("init()..호출");
	}
	//HttpServletRequest,HttpServletResponse-매개변수순서바뀌면안됨
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{	
		System.out.println("service()^^..호출");
		//get방식으로 요청이 들어오면 doGet을 호출하고 post방식이면 doPost를 호출
		//System.out.println(req.getMethod());
		if(req.getMethod().equals("GET")){
			doGet(req, res);
		}else{
			doPost(req, res);
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException{
		System.out.println("doGet()..호출");
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException{
		System.out.println("doPost()..호출");
	}
	public void destroy(){
		//서블릿객체가 소멸될때 호출되는 메소드
		// - WAS가 리로드, 서블릿이 변경되었을 때, Context가 리로드될 때
		System.out.println("destroy()..호출");
	}
	
}
