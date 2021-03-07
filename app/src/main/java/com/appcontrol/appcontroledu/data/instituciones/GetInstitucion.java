package com.appcontrol.appcontroledu.data.instituciones;

import com.google.gson.annotations.SerializedName;

public class GetInstitucion{

	@SerializedName("persona")
	private String persona;

	public void setPersona(String persona){
		this.persona = persona;
	}

	public String getPersona(){
		return persona;
	}
}