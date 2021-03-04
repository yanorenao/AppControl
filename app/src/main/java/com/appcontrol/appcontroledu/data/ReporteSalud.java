package com.appcontrol.appcontroledu.data;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ReporteSalud{

	@SerializedName("fecha")
	private String fecha;

	@SerializedName("estado")
	private String estado;

	@SerializedName("respuestas")
	private List<RespuestasItem> respuestas;

	@SerializedName("persona")
	private String persona;

	@SerializedName("__v")
	private int V;

	@SerializedName("_id")
	private String id;

	public void setFecha(String fecha){
		this.fecha = fecha;
	}

	public String getFecha(){
		return fecha;
	}

	public void setEstado(String estado){
		this.estado = estado;
	}

	public String getEstado(){
		return estado;
	}

	public void setRespuestas(List<RespuestasItem> respuestas){
		this.respuestas = respuestas;
	}

	public List<RespuestasItem> getRespuestas(){
		return respuestas;
	}

	public void setPersona(String persona){
		this.persona = persona;
	}

	public String getPersona(){
		return persona;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}
}