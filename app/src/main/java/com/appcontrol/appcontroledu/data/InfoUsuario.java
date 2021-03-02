package com.appcontrol.appcontroledu.data;

public class InfoUsuario{
	private InfoUser infoUser;
	private String token;

	public void setInfoUser(InfoUser infoUser){
		this.infoUser = infoUser;
	}

	public InfoUser getInfoUser(){
		return infoUser;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}
}
