package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EmpFilter implements Filter{
	public EmpFilter(){
		System.out.println("EmpFilter생성");
	}
	@Override
	public void destroy() {

	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("emp에 관련된 요청전에만 실행되는 필터");
		chain.doFilter(req, res);
		System.out.println("응답되고 있음 - empfilter");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
