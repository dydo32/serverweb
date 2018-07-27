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
		System.out.println("TestFilter����");
	}
	@Override
	public void destroy() {
		
	}

	//������ ����Ǳ� ���� �����ؾ��ϴ� �۾��� �ִ� ��� ���
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("TestFilter�� doFilterȣ����");
		//FilterChain�ȿ� ���ǵǾ� �ִ� ���� ���ͳ� ������ ��û�� �ѱ�� �۾�
		//doFilterȣ�⹮�� �������� ȣ�⹮ �տ� ���ǵ� ��ɹ��� request�� �� ����ǰ�
		//ȣ�⹮ �ڿ� ���ǵ� ��ɹ��� response�ɶ� ����ȴ�.
		chain.doFilter(req,res);
		System.out.println("TestFilter�� doFilterȣ����");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
