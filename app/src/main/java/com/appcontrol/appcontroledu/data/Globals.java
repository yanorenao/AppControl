package com.appcontrol.appcontroledu.data;

import android.app.Application;

public class Globals extends Application {
    private int myIndex;
    private String idDocument;
    private String idSalon;
    private String idInstitucion;


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
}
