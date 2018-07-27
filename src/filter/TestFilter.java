package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestFilter implements Filter{
	public TestFilter(){
		System.out.println("TestFilter생성");
	}
	@Override
	public void destroy() {
		
	}

	//서블릿이 실행되기 전에 실행해야하는 작업이 있는 경우 명시
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("TestFilter의 doFilter호출전");
		//FilterChain안에 정의되어 있는 다음 필터나 서블릿을 요청을 넘기는 작업
		//doFilter호출문을 기준으로 호출문 앞에 정의된 명령문은 request될 때 실행되고
		//호출문 뒤에 정의된 명령문은 response될때 실행된다.
		chain.doFilter(req,res);
		System.out.println("TestFilter의 doFilter호출후");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
