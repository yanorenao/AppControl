package com.appcontrol.appcontroledu.data;

import com.google.gson.annotations.SerializedName;

public class PutPersona{

	@SerializedName("apellidos")
	private String apellidos;

	@SerializedName("telefonoResponsable")
	private String telefonoResponsable;

	@SerializedName("barrio")
	private String barrio;

	@SerializedName("estado")
	private String estado;

	@SerializedName("fechaNacimiento")
	private String fechaNacimiento;

	@SerializedName("direccion")
	private String direccion;

	@SerializedName("institucion")
	private String institucion;

	@SerializedName("nombre")
	private String nombre;

	@SerializedName("isUsed")
	private String isUsed;

	@SerializedName("IdPersona")
	private String idPersona;

	@SerializedName("tipoDocumento")
	private String tipoDocumento;

	@SerializedName("nombreResponsable")
	private String nombreResponsable;

	@SerializedName("apellidoResponsable")
	private String apellidoResponsable;

	@SerializedName("emailResponsable")
	private String emailResponsable;

	@SerializedName("telefono")
	private String telefono;

	@SerializedName("correoElectronico")
	private String correoElectronico;

	@SerializedName("salon")
	private String salon;

	public void setApellidos(String apellidos){
		this.apellidos = apellidos;
	}

	public String getApellidos(){
		return apellidos;
	}

	public void setTelefonoResponsable(String telefonoResponsable){
		this.telefonoResponsable = telefonoResponsable;
	}

	public String getTelefonoResponsable(){
		return telefonoResponsable;
	}

	public void setBarrio(String barrio){
		this.barrio = barrio;
	}

	public String getBarrio(){
		return barrio;
	}

	public void setEstado(String estado){
		this.estado = estado;
	}

	public String getEstado(){
		return estado;
	}

	public void setFechaNacimiento(String fechaNacimiento){
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaNacimiento(){
		return fechaNacimiento;
	}

	public void setDireccion(String direccion){
		this.direccion = direccion;
	}

	public String getDireccion(){
		return direccion;
	}

	public void setInstitucion(String institucion){
		this.institucion = institucion;
	}

	public String getInstitucion(){
		return institucion;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return nombre;
	}

	public void setIsUsed(String isUsed){
		this.isUsed = isUsed;
	}

	public String getIsUsed(){
		return isUsed;
	}

	public void setIdPersona(String idPersona){
		this.idPersona = idPersona;
	}

	public String getIdPersona(){
		return idPersona;
	}

	public void setTipoDocumento(String tipoDocumento){
		this.tipoDocumento = tipoDocumento;
	}

	public String getTipoDocumento(){
		return tipoDocumento;
	}

	public void setNombreResponsable(String nombreResponsable){
		this.nombreResponsable = nombreResponsable;
	}

	public String getNombreResponsable(){
		return nombreResponsable;
	}

	public void setApellidoResponsable(String apellidoResponsable){
		this.apellidoResponsable = apellidoResponsable;
	}

	public String getApellidoResponsable(){
		return apellidoResponsable;
	}

	public void setEmailResponsable(String emailResponsable){
		this.emailResponsable = emailResponsable;
	}

	public String getEmailResponsable(){
		return emailResponsable;
	}

	public void setTelefono(String telefono){
		this.telefono = telefono;
	}

	public String getTelefono(){
		return telefono;
	}

	public void setCorreoElectronico(String correoElectronico){
		this.correoElectronico = correoElectronico;
	}

	public String getCorreoElectronico(){
		return correoElectronico;
	}

	public void setSalon(String salon){
		this.salon = salon;
	}

	public String getSalon(){
		return salon;
	}
}