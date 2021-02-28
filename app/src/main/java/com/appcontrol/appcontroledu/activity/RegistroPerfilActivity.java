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
                String id_studiante = "6033d109738cb125f847709e";
                Intent estudianteIntent = new Intent(RegistroPerfilActivity.this, RegistroUsuarioActivity.class);
                estudianteIntent.putExtra("tipoUsuario", id_studiante);
                startActivity(estudianteIntent);
            }
        });

        btn_administrativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_administrativo = "6033d120738cb125f84770a0";
                Intent administrativoIntent = new Intent(RegistroPerfilActivity.this, RegistroUsuarioActivity.class);
                administrativoIntent.putExtra("tipoUsuario", id_administrativo);
                startActivity(administrativoIntent);
            }
        });

        btn_docente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_docente = "6033d119738cb125f847709f";
                Intent docenteIntent = new Intent(RegistroPerfilActivity.this, RegistroUsuarioActivity.class);
                docenteIntent.putExtra("tipoUsuario", id_docente);
                startActivity(docenteIntent);
            }
        });

        btn_contratista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_contratista = "6033d127738cb125f84770a1";
                Intent contratistaIntent = new Intent(RegistroPerfilActivity.this, RegistroUsuarioActivity.class);
                contratistaIntent.putExtra("tipoUsuario", id_contratista);
                startActivity(contratistaIntent);
            }
        });

        btn_otro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_otro = "6033d12e738cb125f84770a2";
                //tipoUsuario
                Intent otroIntent = new Intent(RegistroPerfilActivity.this, RegistroUsuarioActivity.class);
                otroIntent.putExtra("tipoUsuario", id_otro);
                startActivity(otroIntent);
            }
        });




    }


}