package com.appcontrol.appcontroledu.data;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Institucion{

	@SerializedName("estado")
	private List<String> estado;

	@SerializedName("responsable")
	private String responsable;

	@SerializedName("__v")
	private int V;

	@SerializedName("nit")
	private String nit;

	@SerializedName("direccion")
	private String direccion;

	@SerializedName("_id")
	private String id;

	@SerializedName("telefono")
	private String telefono;

	@SerializedName("nombre")
	private String nombre;

	public void setEstado(List<String> estado){
		this.estado = estado;
	}

	public List<String> getEstado(){
		return estado;
	}

	public void setResponsable(String responsable){
		this.responsable = responsable;
	}

	public String getResponsable(){
		return responsable;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setNit(String nit){
		this.nit = nit;
	}

	public String getNit(){
		return nit;
	}

	public void setDireccion(String direccion){
		this.direccion = direccion;
	}

	public String getDireccion(){
		return direccion;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTelefono(String telefono){
		this.telefono = telefono;
	}

	public String getTelefono(){
		return telefono;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return nombre;
	}
}