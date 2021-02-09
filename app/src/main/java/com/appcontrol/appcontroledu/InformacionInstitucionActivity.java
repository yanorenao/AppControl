package com.appcontrol.appcontroledu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InformacionInstitucionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_institucion);
        final TextView view = (TextView) findViewById(R.id.text_nuevo_salon);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(InformacionInstitucionActivity.this, RegistroSalonActivity.class);
                startActivity(myIntent);
            }

        });
    }
}