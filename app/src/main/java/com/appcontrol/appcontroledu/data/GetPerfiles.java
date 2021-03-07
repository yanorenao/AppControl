package com.appcontrol.appcontroledu.data;

import com.google.gson.annotations.SerializedName;

public class GetPerfiles{

	@SerializedName("institucion")
	private String institucion;

	public void setInstitucion(String institucion){
		this.institucion = institucion;
	}

	public String getInstitucion(){
		return institucion;
	}
}