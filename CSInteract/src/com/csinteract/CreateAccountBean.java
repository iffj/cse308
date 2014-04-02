package com.csinteract;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;






import entities.User;
import BCrypt.BCrypt;


@ManagedBean
@RequestScoped
public class CreateAccountBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public CreateAccountBean()
	{
		
	}
	
	private String username;
	private String password;
	private String cPassword;
	private String email;
	private String name;
	
	//admin testing ================================================================================================
	private boolean admin;
	

	 @ManagedProperty(value="#{userBean}")
	  private UserBean ub;
	 
	 @ManagedProperty(value="#{databaseManager}")
	  private DatabaseManager dbm;
	
	public String createAccount()
	{
		
		
		if(!password.equals(cPassword))
        {
            
            return null;
        }
        String salt = BCrypt.gensalt(12);
        String hashed = BCrypt.hashpw(password, salt);
        
        User u = new User();
        u.setEmail(email);
        u.setName(name);
        u.setUsername(username);
        u.setPassword(hashed);
        u.setUsername(username);
        
        //Admin setting just for test======================================================================
        u.setAdmin(admin);
        
        dbm.saveEntity(u);
        ub.setU(u);
        ub.setLoggedIn(true);
        
		return "profile.jsf";
	}
	
	

	
	//Getters and Setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
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

	public UserBean getUb() {
		return ub;
	}

	public void setUb(UserBean ub) {
		this.ub = ub;
	}

	public DatabaseManager getDbm() {
		return dbm;
	}

	public void setDbm(DatabaseManager dbm) {
		this.dbm = dbm;
	}
	
	
	
	
	//ADMIN TESTING ================================================================================================
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public boolean getAdmin() {
		return admin;
	}
	
	
	

}
