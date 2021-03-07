package com.appcontrol.appcontroledu.data.perfiles;

import java.util.List;

public class SalonItem{
	private String codigo;
	private int V;
	private String institucion;
	private List<String> tipoSalon;
	private String id;
	private String nombre;

	public void setCodigo(String codigo){
		this.codigo = codigo;
	}

	public String getCodigo(){
		return codigo;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setInstitucion(String institucion){
		this.institucion = institucion;
	}

	public String getInstitucion(){
		return institucion;
	}

	public void setTipoSalon(List<String> tipoSalon){
		this.tipoSalon = tipoSalon;
	}

	public List<String> getTipoSalon(){
		return tipoSalon;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return nombre;
	}
}