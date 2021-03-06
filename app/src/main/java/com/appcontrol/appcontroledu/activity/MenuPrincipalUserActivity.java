package com.appcontrol.appcontroledu.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.LAYOUT_DIRECTION_LTR;

public class MenuPrincipalUserActivity extends AppCompatActivity {
    APIInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal_user);

        CardView cardView_reportarSalud = (CardView) findViewById(R.id.reportar_salud);
        CardView cardView_modificaPerfil = (CardView) findViewById(R.id.modificar_perfil);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        initToolbar();


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
                myIntent.putExtra("id", getIntent().getStringExtra("id"));
                myIntent.putExtra("myjson", getIntent().getStringExtra("myjson"));
                startActivity(myIntent);

            }
        });

    }


    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.imc_close);
        toolbar.setNavigationIcon(drawable);
        toolbar.setLogoDescription("LOGO");
        toolbar.getNavigationIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Tools.setSystemBarColor(this, R.color.lime_600);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            dialogexit();
        }
        return super.onOptionsItemSelected(item);
    }


private void dialogexit(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("¿Está seguro que desea salir de la aplicación?");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
                System.exit(0);
            }
        });
        builder.setNegativeButton("No", null);
        builder.show();

}

    private void PostExisteReporteSalud(InfoReporteSalud object) {
        Call<InfoReporteSalud> call = apiInterface.existReporte(object);
        call.enqueue(new Callback<InfoReporteSalud>() {
            @Override
            public void onResponse(Call<InfoReporteSalud> call, Response<InfoReporteSalud> response) {
                if (response.isSuccessful()) {
                    if (response.body().getPersona() == null) {
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