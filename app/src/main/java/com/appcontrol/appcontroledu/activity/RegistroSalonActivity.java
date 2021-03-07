package com.appcontrol.appcontroledu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.appcontrol.appcontroledu.R;

public class RegistroSalonActivity extends AppCompatActivity {

    Button bt_submit_salones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_salon);
        bt_submit_salones = findViewById(R.id.bt_submit_salones);
        bt_submit_salones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"informacion actualizada con exito",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }


}