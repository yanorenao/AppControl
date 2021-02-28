package com.appcontrol.appcontroledu.data;

import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("type_user")
	private String typeUser;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("id")
	private int id;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	@SerializedName("status")
	private int status;

	public void setTypeUser(String typeUser){
		this.typeUser = typeUser;
	}

	public String getTypeUser(){
		return typeUser;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
}