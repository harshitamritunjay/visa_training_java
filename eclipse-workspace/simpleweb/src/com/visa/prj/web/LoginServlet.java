package com.visa.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HashMap<String, String> users= new HashMap<>();
	
	public void init(ServletConfig config) throws ServletException {
		users.put("Gavin", "King123");
		users.put("Harry", "Secret123");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pwd= request.getParameter("pwd");
		if(users.containsKey(user)) {
			if(users.get(user).equals(pwd)) {
				//httpserver cookie //loosely coupled, if tomcat one is used
				//cookie is a key value pair
				Cookie c1= new Cookie("user",user);
				//long lived cookie
				//c1.setMaxAge(60*60*24);
				response.addCookie(c1);
				response.sendRedirect("index.html");
				//once redirected then return so that another redirect is not executed
				return;
			}
		}
		response.sendRedirect("login.html");
	}

}
