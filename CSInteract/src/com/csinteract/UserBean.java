package com.csinteract;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
		isLoggedIn = false;
	}
	private int userId;
	private String email = "drgdrgdrg";
	private String name;
	private boolean isLoggedIn;
	
	
	public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.jsf?faces-redirect=true";
    }
	
	
	
	
	
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

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	public String getTemplate()
	{
		if(isLoggedIn)
		{
			return "loggedInTemplate.xhtml";
		}
		else
		{
			return "loggedOutTemplate.xhtml";
					
		}
	}
	
	
}
