package com.appcontrol.appcontroledu.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.appcontrol.appcontroledu.APIClient;
import com.appcontrol.appcontroledu.APIInterface;
import com.appcontrol.appcontroledu.R;
import com.appcontrol.appcontroledu.data.InfoReporteSalud;
import com.appcontrol.appcontroledu.data.InfoUsuario;
import com.appcontrol.appcontroledu.data.ReporteSalud;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuPrincipalUserActivity extends AppCompatActivity {
    APIInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal_user);
        getSupportActionBar().hide();
        CardView cardView_reportarSalud = (CardView) findViewById(R.id.reportar_salud);
        CardView cardView_modificaPerfil = (CardView) findViewById(R.id.modificar_perfil);
        apiInterface = APIClient.getClient().create(APIInterface.class);


        cardView_reportarSalud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoReporteSalud existe = new InfoReporteSalud();
                existe.setPersona(getIntent().getStringExtra("id"));
                PostExisteReporteSalud(existe);
                //Toast.makeText(getApplicationContext(), ob.getInfoUser().getPersona().toString(), Toast.LENGTH_LONG).show();

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

    private void PostExisteReporteSalud(InfoReporteSalud object) {
        Call<InfoReporteSalud> call = apiInterface.existReporte(object);
        call.enqueue(new Callback<InfoReporteSalud>() {
            @Override
            public void onResponse(Call<InfoReporteSalud> call, Response<InfoReporteSalud> response) {
                if (response.isSuccessful()) {
                    if (true) {
                        //response.body().getPersona() == null
                        Intent myIntent = new Intent(MenuPrincipalUserActivity.this, ReporteSaludActivity.class);
                        myIntent.putExtra("id", getIntent().getStringExtra("id"));
                        myIntent.putExtra("myjson", getIntent().getStringExtra("myjson"));
                        startActivity(myIntent);

                    }
                else {
                        showCustomDialog();
                    }



                } else {

                    try {
                        Toast.makeText(getApplicationContext(), response.errorBody().string(), Toast.LENGTH_LONG).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<InfoReporteSalud> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showCustomDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_alert);
        dialog.setCancelable(true);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;



        ((AppCompatButton) dialog.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(getApplicationContext(), ((AppCompatButton) v).getText().toString() + " Clicked", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }


}