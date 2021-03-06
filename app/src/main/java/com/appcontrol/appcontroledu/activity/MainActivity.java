package com.appcontrol.appcontroledu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.appcontrol.appcontroledu.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();
        //metodo para mostrar la pantalla por 3 segundos
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, 3000);
    }
}