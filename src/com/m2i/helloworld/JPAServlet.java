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

import com.m2i.helloworld.jpaentities.User;

/**
 * Servlet implementation class JPAServlet
 */
@WebServlet("/JPAServlet")
public class JPAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JPAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HelloWorld");
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		
		User u = entityManager.find(User.class, 1);
		
  
		System.out.println(u);
	
		
		List<User> users = entityManager.createNamedQuery("User.findAll").getResultList();
		/*
		for(User e:users) {
			System.out.println(e);
		}
				
		User u2 = (User)entityManager.createNamedQuery("User.findById").setParameter("userId",3).getSingleResult();
		System.out.println(u2);
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath()).append(u.toString());
		*/
	}

}
