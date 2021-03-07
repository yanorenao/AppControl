package com.appcontrol.appcontroledu.data;

import java.util.ArrayList;

public class Contact {
    private String mName;
    private String tipoUsurario;

    public Contact(String mName, String tipoUsurario, String tipoUSalon, boolean mOnline) {
        this.mName = mName;
        this.tipoUsurario = tipoUsurario;
        this.tipoUSalon = tipoUSalon;
        this.mOnline = mOnline;
    }

    private String tipoUSalon;
    private boolean mOnline;



    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<Contact> createContactsList(int numContacts) {
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Contact("Persona " + ++lastContactId,"Estudiante", "Salon 101 A",i <= numContacts / 2));
        }

        return contacts;
    }

    public String getTipoUsurario() {
        return tipoUsurario;
    }

    public void setTipoUsurario(String tipoUsurario) {
        this.tipoUsurario = tipoUsurario;
    }

    public String getTipoUSalon() {
        return tipoUSalon;
    }

    public void setTipoUSalon(String tipoUSalon) {
        this.tipoUSalon = tipoUSalon;
    }
}
