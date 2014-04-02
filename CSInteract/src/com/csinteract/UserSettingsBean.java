package com.csinteract;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import BCrypt.BCrypt;


@ManagedBean
@RequestScoped
public class UserSettingsBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String name;
	private String currentPassword;
	private String newPassword;
	private String cPassword;
	
	
	
	@ManagedProperty(value = "#{userBean}")
	private UserBean ub;

	@ManagedProperty(value="#{databaseManager}")
	private DatabaseManager dbm;
	
	@ManagedProperty(value="#{messageBean}")
	private MessageBean mb;
	
	public MessageBean getMb() {
		return mb;
	}



	public void setMb(MessageBean mb) {
		this.mb = mb;
	}



	public UserSettingsBean()
	{
		
	}
	
	
	
	public String saveSettings()
	{
		
		ArrayList<String> msg = new ArrayList<String>();
		if (!BCrypt.checkpw(currentPassword, ub.getU().getPassword()))
        {
                msg.add("Current password entered is incorrect.");
        }
		if(!newPassword.equals(cPassword) && (!newPassword.isEmpty() && !cPassword.isEmpty()))
		{
			msg.add("New password and confirmation password entry do not match.");
		}
		else if(newPassword.length() < 6 || newPassword.length() > 30 && (!newPassword.isEmpty() && !cPassword.isEmpty()))
		{
			msg.add("Password length has to be at least 6 characters, and at most 30 characters.");
		}
		if(name.length() < 3 && !name.isEmpty())
		{
			msg.add("Name is too short. Please enter a name larger than 2 characters.");
		}
		else if(name.length() > 30)
		{
			msg.add("Name is too long. Please enter a name smaller than 30 characters.");
		}
		if(msg.isEmpty())
		{
			if(!name.isEmpty() && !name.equals(ub.getU().getName()))
			{
				ub.getU().setName(name);
				msg.add("Name changed successfully");
			}
			if(!newPassword.isEmpty())
			{
				String salt = BCrypt.gensalt(12);
		        String hashed = BCrypt.hashpw(newPassword, salt);
		        ub.getU().setPassword(hashed);
		        msg.add("Password changed successfully");
			}
	        dbm.mergeEntity(ub.getU());
	        ub.setU(dbm.getUserByUsername(ub.getU().getUsername()));
	        
	        mb.readyMessage(msg, false);
		}
		else
		{
			mb.readyMessage(msg, true);
		}
		
		return null;
	}



	
	//Getters and Setters
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCurrentPassword() {
		return currentPassword;
	}



	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}



	public String getNewPassword() {
		return newPassword;
	}



	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
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
	

	
	
	
	
	
	
	
}
