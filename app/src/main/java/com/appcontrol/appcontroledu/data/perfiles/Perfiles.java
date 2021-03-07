package com.appcontrol.appcontroledu.data.perfiles;

import java.util.List;

public class Perfiles{
	private List<String> estado;
	private String clave;
	private List<PersonaItem> persona;
	private int V;
	private List<TipoUsuarioItem> tipoUsuario;
	private String usuario;
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