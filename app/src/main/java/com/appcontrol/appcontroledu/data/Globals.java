package com.appcontrol.appcontroledu.data;

import android.app.Application;

public class Globals extends Application {
    private int myIndex;
    private String idDocument;
    private String idSalon;
    private String idInstitucion;
    private String idTipoPerosna;
    private String idPersona;
    private String document;
    private String contraseña;


    public int getMyIndex() {
        return myIndex;
    }

    public void setMyIndex(int myIndex) {
        this.myIndex = myIndex;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    public String getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(String idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(String idSalon) {
        this.idSalon = idSalon;
    }



    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getIdTipoPerosna() {
        return idTipoPerosna;
    }

    public void setIdTipoPerosna(String idTipoPerosna) {
        this.idTipoPerosna = idTipoPerosna;
    }
}
