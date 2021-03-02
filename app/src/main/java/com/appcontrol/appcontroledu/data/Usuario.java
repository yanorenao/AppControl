package com.appcontrol.appcontroledu.data;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Usuario{

	@SerializedName("estado")
	private List<String> estado;

	@SerializedName("clave")
	private String clave;

	@SerializedName("persona")
	private List<String> persona;

	@SerializedName("__v")
	private int V;

	@SerializedName("tipoUsuario")
	private List<String> tipoUsuario;

	@SerializedName("usuario")
	private String usuario;

	@SerializedName("_id")
	private String id;

	public void setEstado(List<String> estado){
		this.estado = estado;
	}

	public List<String> getEstado(){
		return estado;
	}

	public void setClave(String clave){
		this.clave = clave;
	}

	public String getClave(){
		return clave;
	}

	public void setPersona(List<String> persona){
		this.persona = persona;
	}

	public List<String> getPersona(){
		return persona;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setTipoUsuario(List<String> tipoUsuario){
		this.tipoUsuario = tipoUsuario;
	}

	public List<String> getTipoUsuario(){
		return tipoUsuario;
	}

	public void setUsuario(String usuario){
		this.usuario = usuario;
	}

	public String getUsuario(){
		return usuario;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}
}