package com.appcontrol.appcontroledu.data.instituciones;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Instituciones{

	@SerializedName("infoInstitucion")
	private List<InfoInstitucionItem> infoInstitucion;

	@SerializedName("infoSalones")
	private List<InfoSalonesItem> infoSalones;

	public void setInfoInstitucion(List<InfoInstitucionItem> infoInstitucion){
		this.infoInstitucion = infoInstitucion;
	}

	public List<InfoInstitucionItem> getInfoInstitucion(){
		return infoInstitucion;
	}

	public void setInfoSalones(List<InfoSalonesItem> infoSalones){
		this.infoSalones = infoSalones;
	}

	public List<InfoSalonesItem> getInfoSalones(){
		return infoSalones;
	}
}