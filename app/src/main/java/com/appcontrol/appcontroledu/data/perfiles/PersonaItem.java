package com.appcontrol.appcontroledu.data.perfiles;

import java.util.List;

public class PersonaItem{
	private String apellidos;
	private String telefonoResponsable;
	private List<String> estado;
	private String barrio;
	private String fechaNacimiento;
	private List<String> institucion;
	private String direccion;
	private boolean isUsed;
	private String nombres;
	private List<String> tipoDocumento;
	private String nombreResponsable;
	private String apellidoResponsable;
	private int V;
	private String emailResponsable;
	private String id;
	private String telefono;
	private String correoElectronico;
	private List<SalonItem> salon;

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

	public void setEstado(List<String> estado){
		this.estado = estado;
	}

	public List<String> getEstado(){
		return estado;
	}

	public void setBarrio(String barrio){
		this.barrio = barrio;
	}

	public String getBarrio(){
		return barrio;
	}

	public void setFechaNacimiento(String fechaNacimiento){
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaNacimiento(){
		return fechaNacimiento;
	}

	public void setInstitucion(List<String> institucion){
		this.institucion = institucion;
	}

	public List<String> getInstitucion(){
		return institucion;
	}

	public void setDireccion(String direccion){
		this.direccion = direccion;
	}

	public String getDireccion(){
		return direccion;
	}

	public void setIsUsed(boolean isUsed){
		this.isUsed = isUsed;
	}

	public boolean isIsUsed(){
		return isUsed;
	}

	public void setNombres(String nombres){
		this.nombres = nombres;
	}

	public String getNombres(){
		return nombres;
	}

	public void setTipoDocumento(List<String> tipoDocumento){
		this.tipoDocumento = tipoDocumento;
	}

	public List<String> getTipoDocumento(){
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

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setEmailResponsable(String emailResponsable){
		this.emailResponsable = emailResponsable;
	}

	public String getEmailResponsable(){
		return emailResponsable;
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

	public void setCorreoElectronico(String correoElectronico){
		this.correoElectronico = correoElectronico;
	}

	public String getCorreoElectronico(){
		return correoElectronico;
	}

	public void setSalon(List<SalonItem> salon){
		this.salon = salon;
	}

	public List<SalonItem> getSalon(){
		return salon;
	}
}