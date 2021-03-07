package com.appcontrol.appcontroledu.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.appcontrol.appcontroledu.APIClient;
import com.appcontrol.appcontroledu.APIInterface;
import com.appcontrol.appcontroledu.R;
import com.appcontrol.appcontroledu.adapter.RegisterAdapter;
import com.appcontrol.appcontroledu.data.Contact;
import com.appcontrol.appcontroledu.data.GetPerfiles;
import com.appcontrol.appcontroledu.data.perfiles.Perfiles;
import com.appcontrol.appcontroledu.data.PutPersona;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AceptarPrefilesActivity extends AppCompatActivity {


    ArrayList<Contact> contacts;
    APIInterface apiInterface;
    RecyclerView rvContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aceptar_perfiles);
        //getSupportActionBar().hide();
        rvContacts = (RecyclerView) findViewById(R.id.recyclerView);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        GetPerfiles sendPerfil = new GetPerfiles();
        sendPerfil.setInstitucion("6033ca748239924854ebb4a4");
        getPerfiles(sendPerfil);
        // Initialize contacts
        //contacts = Contact.createContactsList(20);
        // Create adapter passing in the sample user data

        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        // That's all!
    }


    private Perfiles getPerfiles(GetPerfiles object){
        Call<List<Perfiles>> call = apiInterface.getPerfiles(object);
        call.enqueue(new Callback<List<Perfiles>>() {
            @Override
            public void onResponse(Call<List<Perfiles>> call, Response<List<Perfiles>> response) {
                if (response.isSuccessful()) {
                    Log.d("getperfiles", response.body().toString());
                    RegisterAdapter adapter = new RegisterAdapter(createContactsList(response.body().size(),response.body()));
                    //Attach the adapter to the recyclerview to populate items
                    rvContacts.setAdapter(adapter);



                    ;


                } else {
                    Log.d("erro peticion","estoy aqui");


                }

            }

            @Override
            public void onFailure(Call<List<Perfiles>> call, Throwable t) {
                Log.d("erro peticion",t.getMessage());
            }
        });
        return null;
    }

    private static int lastContactId = 0;
    public static ArrayList<Contact> createContactsList(int numContacts, List<Perfiles> perfil) {
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        int counter = 0;
        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Contact(perfil.get(counter).getPersona().get(0).getNombres()  + "\n" +perfil.get(counter).getPersona().get(0).getApellidos() , perfil.get(counter).getTipoUsuario().get(0).getNombre(), perfil.get(counter).getPersona().get(0).getSalon().get(0).getNombre(),i <= numContacts / 2));
            counter++;
        }

        return contacts;
    }

}