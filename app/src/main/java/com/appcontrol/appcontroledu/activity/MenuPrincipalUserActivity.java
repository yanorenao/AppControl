package com.appcontrol.appcontroledu.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.appcontrol.appcontroledu.R;

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
                Intent myIntent = new Intent(MenuPrincipalUserActivity.this, ReporteSaludActivity.class);
                startActivity(myIntent);
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