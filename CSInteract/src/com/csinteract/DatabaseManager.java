


package com.csinteract;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.User;


@ManagedBean
@SessionScoped
public class DatabaseManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public DatabaseManager()
	{
		
	}
	
	
	public void saveEntity(Object o)
	{
		EntityManager em = EMF.get().createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(o);
		et.commit();
		em.close();
	}
	
	
	
	public void mergeEntity(Object o)
	{
		EntityManager em = EMF.get().createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(o);
		et.commit();
		em.close();
	}
	
	
	//User queries
	public User getUserByID(int id)
	{
		EntityManager em = EMF.get().createEntityManager();
		User u = (User)em.createNamedQuery("User.findByUserId").setParameter("userId", id).getSingleResult();
		em.close();
		return u;
	}
	public User getUserByUsername(String username)
	{
		EntityManager em = EMF.get().createEntityManager();
		User u = (User)em.createNamedQuery("User.findByUsername").setParameter("username", username).getSingleResult();
		em.close();
		return u;
	}
	
}



