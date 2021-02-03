package com.appcontrol.appcontroledu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        final TextView tvSign_up = (TextView) findViewById(R.id.sign_up);
        //metodo para llamar el formulario de perfil registro
        tvSign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LoginActivity.this, RegistroPerfilActivity.class);
                startActivity(myIntent);
            }
        });
    }
}