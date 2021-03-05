package com.appcontrol.appcontroledu.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InfoUser{

	@SerializedName("infoUser")
	private InfoUser infoUser;

	@SerializedName("token")
	private String token;

	@SerializedName("estado")
	private List<String> estado;

	@SerializedName("clave")
	private String clave;

	@SerializedName("persona")
	private List<PersonaItem> persona;

	@SerializedName("__v")
	private int V;

	@SerializedName("tipoUsuario")
	private List<TipoUsuarioItem> tipoUsuario;

	@SerializedName("usuario")
	private String usuario;

	@SerializedName("_id")
	private String id;

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

	public void setPersona(List<PersonaItem> persona){
		this.persona = persona;
	}

	public List<PersonaItem> getPersona(){
		return persona;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setTipoUsuario(List<TipoUsuarioItem> tipoUsuario){
		this.tipoUsuario = tipoUsuario;
	}

	public List<TipoUsuarioItem> getTipoUsuario(){
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