package com.appcontrol.appcontroledu.data.persona;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PostPersona {

	@SerializedName("apellidos")
	private String apellidos;

	@SerializedName("telefonoResponsable")
	private String telefonoResponsable;

	@SerializedName("barrio")
	private String barrio;

	@SerializedName("estado")
	private List<String> estado;

	@SerializedName("fechaNacimiento")
	private String fechaNacimiento;

	@SerializedName("direccion")
	private String direccion;

	@SerializedName("institucion")
	private List<String> institucion;

	@SerializedName("nombre")
	private String nombre;

	@SerializedName("isUsed")
	private boolean isUsed;

	@SerializedName("tipoDocumento")
	private List<String> tipoDocumento;

	@SerializedName("nombreResponsable")
	private String nombreResponsable;

	@SerializedName("apellidoResponsable")
	private String apellidoResponsable;

	@SerializedName("__v")
	private int V;

	@SerializedName("emailResponsable")
	private String emailResponsable;

	@SerializedName("_id")
	private String id;

	@SerializedName("telefono")
	private String telefono;

	@SerializedName("correoElectronico")
	private String correoElectronico;

	@SerializedName("salon")
	private List<String> salon;

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

	public void setEstado(List<String> estado){
		this.estado = estado;
	}

	public List<String> getEstado(){
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

	public void setInstitucion(List<String> institucion){
		this.institucion = institucion;
	}

	public List<String> getInstitucion(){
		return institucion;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return nombre;
	}

	public void setIsUsed(boolean isUsed){
		this.isUsed = isUsed;
	}

	public boolean isIsUsed(){
		return isUsed;
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

	public void setSalon(List<String> salon){
		this.salon = salon;
	}

	public List<String> getSalon(){
		return salon;
	}
}