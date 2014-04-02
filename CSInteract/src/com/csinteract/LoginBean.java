package com.csinteract;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import BCrypt.BCrypt;
import entities.User;

@ManagedBean
@RequestScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String cPassword;

	@ManagedProperty(value = "#{userBean}")
	private UserBean ub;

	@ManagedProperty(value="#{databaseManager}")
	private DatabaseManager dbm;

	public LoginBean() {

	}

	public String login() {
	
		if(!authenticate())
		{
			return null;
		}
		
		ub.setLoggedIn(true);
		return "profile.jsf";
	}

	public boolean authenticate()
	{
		
		User u;
	
			
		try
        {
			u = dbm.getUserByUsername(username);
            if (!BCrypt.checkpw(password, u.getPassword()))
            {
                
                    return false;
            }
        }
		catch(Exception e)
		{
			return false;
		}
		ub.setU(u);
		return true;
	}

	// Getters and Setters

	public String getUsername() {
		return username;
	}

	public UserBean getUb() {
		return ub;
	}

	public void setUb(UserBean ub) {
		this.ub = ub;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

	public DatabaseManager getDbm() {
		return dbm;
	}

	public void setDbm(DatabaseManager dbm) {
		this.dbm = dbm;
	}

}
