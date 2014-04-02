package com.csinteract;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;





@ManagedBean
@SessionScoped
public class MessageBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public MessageBean()
	{
		
	}

	public String test()
	{
		return "TERSDSJFGEK";
	}
	public void readyMessage(ArrayList<String> msg, boolean state)
	{
		if(state && !msg.isEmpty())
		{
			message = "<div style='border: 2px solid black; border-radius: 15px; background-color: red; color: white; width: 100%; padding: 7px; font-size: 15px;'><span style='font-weight: bold'>Error:</span><br /><ul>";
			for(int x = 0; x < msg.size(); x++)
			{
				message += "<li>" + msg.get(x) + "</li>";
			}
			message += "</ul></div>";
		}
		else
		{
			message = "<div style='border: 2px solid black; border-radius: 15px; background-color: lightGreen; color: white; width: 100%; padding: 7px; font-size: 15px;'><span style='font-weight: bold'>Success:</span><br /><ul>";
			for(int x = 0; x < msg.size(); x++)
			{
				message += "<li>" + msg.get(x) + "</li>";
			}
			message += "</ul></div>";
		}
	}
	
	public String getMessage() {
		String temp = message;
		message = "";
		return temp;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
