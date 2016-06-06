package com.action;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction  extends ActionSupport{
	private static final long serialVersionUID=1L;
	private String helo;
	public String getHelo(){
		return helo;
	}
	public void  setHelo(String helo){
		this.helo=helo;
	}
	public String execute() throws Exception{
		helo="hello ,world";
		return SUCCESS;
	}
	

}
