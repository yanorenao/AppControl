package com.appcontrol.appcontroledu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.appcontrol.appcontroledu.R;

public class RegistroPerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_perfil);

        final Button btn_estudiante = (Button) findViewById(R.id.btn_estudiante);
        final Button btn_docente = (Button) findViewById(R.id.btn_docente);
        final Button btn_administrativo = (Button) findViewById(R.id.btn_administrativo);
        final Button btn_contratista = (Button) findViewById(R.id.btn_contratista);
        final Button btn_otro = (Button) findViewById(R.id.btn_otro);

        btn_estudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(RegistroPerfilActivity.this, RegistroUsuarioActivity.class);
                startActivity(myIntent);
            }
        });

        btn_administrativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(RegistroPerfilActivity.this, RegistroUsuarioActivity.class);
                startActivity(myIntent);
            }
        });

        btn_docente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(RegistroPerfilActivity.this, RegistroUsuarioActivity.class);
                startActivity(myIntent);
            }
        });

        btn_contratista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(RegistroPerfilActivity.this, RegistroUsuarioActivity.class);
                startActivity(myIntent);
            }
        });

        btn_otro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(RegistroPerfilActivity.this, RegistroUsuarioActivity.class);
                startActivity(myIntent);
            }
        });

    }
}