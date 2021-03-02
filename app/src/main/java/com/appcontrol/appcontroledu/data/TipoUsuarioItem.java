package com.appcontrol.appcontroledu.data;

public class TipoUsuarioItem{
	private int estado;
	private String parametro;
	private int V;
	private String valor;
	private String id;
	private String nombre;

	public void setEstado(int estado){
		this.estado = estado;
	}

	public int getEstado(){
		return estado;
	}

	public void setParametro(String parametro){
		this.parametro = parametro;
	}

	public String getParametro(){
		return parametro;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setValor(String valor){
		this.valor = valor;
	}

	public String getValor(){
		return valor;
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
