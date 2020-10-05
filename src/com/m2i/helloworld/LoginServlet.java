package com.m2i.helloworld;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.m2i.helloworld.dao.UserDAO;
import com.m2i.helloworld.entities.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/jeeDB");
			
			try (Connection conn = ds.getConnection()){
				
				
				response.getWriter().append("OK");
			}
			catch(Exception e) {
				response.getWriter().append("KO").append(e.toString());
			}
			
		}
		catch(Exception e) {
			response.getWriter().append("KO").append(e.toString());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		HttpSession session = request.getSession();
				
				
		String userName = request.getParameter("login");
		String userPassword = request.getParameter("password");
		
		session.setAttribute("userNameSession", userName);
		
		if (userName.compareTo("admin") == 0 && userPassword.compareTo("12345") == 0) {

			
			try (UserDAO dao  = new UserDAO()){
				List<User> list = dao.findAll();
				session.setAttribute("users", list);

				for(User u:list) {
					System.out.println(u);
					
				}
			
				response.sendRedirect("main.jsp");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
					
			
		} else {
			response.sendRedirect("error.jsp");
		}

	}

}
