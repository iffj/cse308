package com.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author APL
 */
@ManagedBean
@SessionScoped
public class MainBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new instance of MainBean
	 */
	// //Persistence variables
	// @PersistenceContext
	// EntityManager em;
	// @Resource
	// UserTransaction utx;

	private String username;

	public MainBean() {

	}

	public String saveAttribute() {

	
		username = "ABCDEFG";
		
		Key userKey = KeyFactory.createKey("Username", username);
		Entity person = new Entity("Person", userKey);
		person.setProperty("username2", username);

		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		datastore.put(person);
		return null;

	}

	public String getAttribute() {
		username = "ABCDEFG";
		try {
			DatastoreService datastore = DatastoreServiceFactory
					.getDatastoreService();
			Key userKey = KeyFactory.createKey("Username", username);
			Query query = new Query("Person", userKey);
			Entity usersList = datastore.prepare(query).asSingleEntity();
			System.out.println(usersList.getProperty("username2"));
			return (String) usersList.getProperty("username2");
		} catch (Exception e) {
			return "Not Found";
		}

	}

	public String test() {

		return "<p style='color: red'>This is running on the Google App Engine yay!</p>";
	}

	@PostConstruct
	public void initialize() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
