package com.visa.prj.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Securityfilter
 */
//going to intercept all the requests
@WebFilter("/*")
public class Securityfilter implements Filter {

    /**
     * Default constructor. 
     */
    public Securityfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		System.out.println(req.getRequestURI());
		HttpSession ses= req.getSession(false);
		if((ses!=null && ses.getAttribute("user")!=null)||
				(req.getRequestURI().endsWith("login.jsp"))
				||(req.getRequestURI().endsWith("login.do"))) {
			chain.doFilter(request, response);
		}else {
			res.sendRedirect("login.jsp?msg=Please login");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
