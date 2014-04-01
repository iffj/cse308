package com.csinteract;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;


@ManagedBean
@SessionScoped
public class UserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public UserBean()
	{
		
	}
	
	@PostConstruct
	public void init()
	{
		email="testing this postConstruct";
	}
	private int userId;
	private String email = "drgdrgdrg";
	private String name;
	
	
	public String getEmail()
	{
		return email;
	}
	public String getName()
	{
		return name;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String testThisMethod()
	{
		return null;
	}
}
