package com.appcontrol.appcontroledu.data;

import com.google.gson.annotations.SerializedName;

public class InfoReporteSalud{

	@SerializedName("persona")
	private String persona;

	public void setPersona(String persona){
		this.persona = persona;
	}

	public String getPersona(){
		return persona;
	}
}