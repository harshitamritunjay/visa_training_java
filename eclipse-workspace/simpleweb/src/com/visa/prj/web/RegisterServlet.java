package com.visa.prj.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String email=request.getParameter("email");
		String name=request.getParameter("name");
		String age=request.getParameter("age"); //we will always get string, after that we can parse
		
		//string lang[]=request.getParameterValues("lang"); //if multiple values are sent[checkbox,list]
		
		out.print("<br/>Email : " + email);
		out.print("<br/>Name : " + name);
		out.print("<br/>Age : " + age);
		
		out.print("<br/><a href=\"index.html\">Back</a>");
	}

}