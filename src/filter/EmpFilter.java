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
		System.out.println("EmpFilter����");
	}
	@Override
	public void destroy() {

	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("emp�� ���õ� ��û������ ����Ǵ� ����");
		chain.doFilter(req, res);
		System.out.println("����ǰ� ���� - empfilter");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
