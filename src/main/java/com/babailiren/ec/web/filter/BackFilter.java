package com.babailiren.ec.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.babailiren.ec.constants.Constants;
import com.babailiren.ec.web.session.BackSession;

public class BackFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		BackSession backSession = (BackSession) req.getSession().getAttribute(
				Constants.BACK_EMPLOYEE_SESSION);
		String uriStr = req.getRequestURI();
		
		if(!uriStr.contains("/admin/index.html")) {
			if(backSession != null && backSession.getEmployeeId() != null) {
				chain.doFilter(request, response);
				return;
			}
			
			if(backSession == null && uriStr.indexOf("login.html") > 0) {
				chain.doFilter(request, response);
				return;
			}
			req.getRequestDispatcher("/admin/index.html").forward(req, res);
			return;
		}
		chain.doFilter(request, response);
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
