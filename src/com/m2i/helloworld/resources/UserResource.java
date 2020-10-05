package com.m2i.helloworld.resources;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.m2i.helloworld.jpaentities.User;

@Path("users")
public class UserResource {
	
	@GET
	@Produces("application/json")
	public List<User> getUsers(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HelloWorld");
		EntityManager entityManager =entityManagerFactory.createEntityManager();

		List<User> users = entityManager.createNamedQuery("User.findAll").getResultList();
		
		return users ;
		
		
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public User getUser(@PathParam("id") int id){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HelloWorld");
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		
		User u = (User)entityManager.createNamedQuery("User.findById").setParameter("userId",id).getSingleResult();
		return u;
	}
	
	
	@POST
	@Consumes("application/json")
	public void addUser(User u) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HelloWorld");
		EntityManager entityManager =entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();		
		entityManager.persist(u);
		entityManager.getTransaction().commit();
		//return users ;
	
			
	}
}
