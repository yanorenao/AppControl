package com.appcontrol.appcontroledu.data;

import com.google.gson.annotations.SerializedName;

public class RespuestasItem{

	@SerializedName("_id")
	private String id;

	@SerializedName("respuesta")
	private boolean respuesta;

	@SerializedName("pregunta")
	private String pregunta;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setRespuesta(boolean respuesta){
		this.respuesta = respuesta;
	}

	public boolean isRespuesta(){
		return respuesta;
	}

	public void setPregunta(String pregunta){
		this.pregunta = pregunta;
	}

	public String getPregunta(){
		return pregunta;
	}
}