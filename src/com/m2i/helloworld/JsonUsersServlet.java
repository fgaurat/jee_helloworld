package com.m2i.helloworld;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.m2i.helloworld.jpaentities.User;

/**
 * Servlet implementation class JsonUsersServlet
 */
@WebServlet("/json")
public class JsonUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Gson gson = new Gson();

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HelloWorld");
		EntityManager entityManager =entityManagerFactory.createEntityManager();

		List<User> users = entityManager.createNamedQuery("User.findAll").getResultList();
		String jsonUsers = gson.toJson(users);

		response.setContentType("application/json");
		response.getWriter().append(jsonUsers);
		
		
		
		
	}

}
