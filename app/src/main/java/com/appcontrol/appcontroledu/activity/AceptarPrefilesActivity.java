package com.appcontrol.appcontroledu.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.appcontrol.appcontroledu.R;
import com.appcontrol.appcontroledu.data.Contact;

import java.util.ArrayList;

public class AceptarPrefilesActivity extends AppCompatActivity {

    ArrayList<Contact> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aceptar_prefiles);

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.recyclerView);

        // Initialize contacts
        contacts = Contact.createContactsList(20);
        // Create adapter passing in the sample user data
        RegisterAdapter adapter = new RegisterAdapter(contacts);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        // That's all!
    }
}