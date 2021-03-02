package com.appcontrol.appcontroledu.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.appcontrol.appcontroledu.R;
import com.appcontrol.appcontroledu.data.InfoUsuario;
import com.google.gson.Gson;

public class MenuPrincipalUserActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal_user);
        getSupportActionBar().hide();
        CardView cardView_reportarSalud = (CardView) findViewById(R.id.reportar_salud);
        CardView cardView_modificaPerfil = (CardView) findViewById(R.id.modificar_perfil);


        cardView_reportarSalud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
                InfoUsuario ob = gson.fromJson(getIntent().getStringExtra("myjson"), InfoUsuario.class);
                Log.d("persona",ob.getInfoUser().getPersona().get(0).getNombres());
                //Toast.makeText(getApplicationContext(), ob.getInfoUser().getPersona().toString(), Toast.LENGTH_LONG).show();
                //Intent myIntent = new Intent(MenuPrincipalUserActivity.this, ReporteSaludActivity.class);
                //startActivity(myIntent);
            }
        });

        cardView_modificaPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MenuPrincipalUserActivity.this, RegistroUsuarioActivity.class);
                startActivity(myIntent);

            }
        });

    }
}