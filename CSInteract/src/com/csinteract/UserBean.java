package com.csinteract;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import entities.User;


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
	private User u;
	private boolean isLoggedIn;
	
	
	public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.jsf?faces-redirect=true";
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


	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}
	
	
}
