package com.appcontrol.appcontroledu.data;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SalonItem{

	@SerializedName("codigo")
	private String codigo;

	@SerializedName("__v")
	private int V;

	@SerializedName("institucion")
	private String institucion;

	@SerializedName("tipoSalon")
	private List<String> tipoSalon;

	@SerializedName("_id")
	private String id;

	@SerializedName("nombre")
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