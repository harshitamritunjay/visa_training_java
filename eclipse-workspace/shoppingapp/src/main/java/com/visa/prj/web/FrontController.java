package com.visa.prj.web;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.visa.prj.dao.CustomerDao;
import com.visa.prj.dao.CustomerDaoJpaImpl;
import com.visa.prj.dao.DaoException;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.dao.ProductDaoJpaImpl;
import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Product;
import com.visa.prj.util.JPAUtil;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page="index.jsp";
		String uri=request.getRequestURI();
		if(uri!=null) {
			if(uri.endsWith("addProduct.do")) {
				ProductDao productDao= new ProductDaoJpaImpl();
				Product product= new Product();
				product.setName(request.getParameter("name"));
				product.setPrice(Double.parseDouble(request.getParameter("price")));
				product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
				try {
					productDao.addProduct(product);
				} catch (DaoException e) {
					e.printStackTrace();
				}
				response.sendRedirect(page+"?msg=Product added successfully!!!");
				
			}else if(uri.endsWith("login.do")) {
				
				EntityManager em=JPAUtil.getEntityManager();
				if(em.find(Customer.class, request.getParameter("email"))!=null) {
				HttpSession ses= request.getSession(); //request.getSession(boolean)
				ses.setAttribute("email", request.getParameter("email"));
				response.sendRedirect("index.jsp");
				}else {
					response.sendRedirect("index.jsp");
				}
			}else if(uri.endsWith("listProducts.do")){
				
				ProductDao productDao= new ProductDaoJpaImpl();
				 
				List<Product> prds = productDao.getProducts();
				request.setAttribute("products",prds);
				request.getRequestDispatcher("addCart.jsp").forward(request, response);
			}else if(uri.endsWith("addToCart.do")) {
	
				String[] checkboxValues=request.getParameterValues("prd");
				HttpSession ses= request.getSession(); //request.getSession(boolean)
				ses.setAttribute("values", checkboxValues);
				
				for(int i=0;i<checkboxValues.length;i++) {
					if(checkboxValues[i].equals("on")) {
						request.getRequestDispatcher("checkout.jsp").forward(request, response);
					}
				}
				
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
