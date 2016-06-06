package com.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction  extends ActionSupport{
	private static final long serialVersionUID=1L;
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute()throws Exception{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("cache-Control", "no-cache");
		response.getWriter().println("success");
		if(name.equals("tom")&&password.equals("123")){
			response.getWriter().println("Welcome login!");
			
		}else{
			response.getWriter().println("error, please input again!");
		}
		
		return SUCCESS;
	}

}
