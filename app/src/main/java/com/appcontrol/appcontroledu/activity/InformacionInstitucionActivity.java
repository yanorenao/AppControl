package com.appcontrol.appcontroledu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.appcontrol.appcontroledu.APIClient;
import com.appcontrol.appcontroledu.APIInterface;
import com.appcontrol.appcontroledu.R;
import com.appcontrol.appcontroledu.data.instituciones.GetInstitucion;
import com.appcontrol.appcontroledu.data.instituciones.InfoSalonesItem;
import com.appcontrol.appcontroledu.data.instituciones.Instituciones;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InformacionInstitucionActivity extends AppCompatActivity {


    TableLayout table;
    APIInterface apiInterface;
    EditText et_nombreInstitucion;
    EditText et_responsable;
    EditText et_nit;
    EditText et_direcion_institucion;
    Button bt_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_institucion);
        final TextView view = (TextView) findViewById(R.id.text_nuevo_salon);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        et_nombreInstitucion = findViewById(R.id.et_nombreInstitucion);
        et_responsable = findViewById(R.id.et_responsable);
        et_nit =  findViewById(R.id.et_nit);
        et_direcion_institucion =  findViewById(R.id.et_direcion_institucion);
        bt_submit = findViewById(R.id.bt_submit);
        GetInstitucion persona = new GetInstitucion();
        persona.setPersona("603d4c5969c6693870f1cc69");
        getInfoInstitucion(persona);



        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"informacion actualizada con exito",Toast.LENGTH_SHORT).show();
            }
        });






        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(InformacionInstitucionActivity.this, RegistroSalonActivity.class);
                startActivity(myIntent);
            }

        });
    }

    private void getInfoInstitucion(GetInstitucion object){
        Call<Instituciones> call = apiInterface.getInfoInstitucion(object);
        call.enqueue(new Callback<Instituciones>() {
            @Override
            public void onResponse(Call<Instituciones> call, Response<Instituciones> response) {
                if (response.isSuccessful()) {
                    Log.d("getperfiles", response.body().toString());
                    ArrayList<String> nombresList = createNombresList(response.body().getInfoSalones().size(),response.body().getInfoSalones());
                    ArrayList<String> codigosList = createCodigosList(response.body().getInfoSalones().size(),response.body().getInfoSalones());
                    ArrayList<String> salonesList = createSalonesList(response.body().getInfoSalones().size(),response.body().getInfoSalones());
                    et_nombreInstitucion.setText(response.body().getInfoInstitucion().get(0).getNombre());
                    et_responsable.setText(response.body().getInfoInstitucion().get(0).getResponsable());
                    et_nit.setText(response.body().getInfoInstitucion().get(0).getNit());
                    et_direcion_institucion.setText(response.body().getInfoInstitucion().get(0).getDireccion());
                    createTable(nombresList, codigosList, salonesList);
                    Log.d("erro peticion","estoy aqui");


                } else {
                    Log.d("erro peticion","estoy aqui");


                }
            }

            @Override
            public void onFailure(Call<Instituciones> call, Throwable t) {
                Log.d("error peticion",t.getMessage());

            }
        });

    }

    private void createTable(ArrayList<String> nombre, ArrayList<String> codigo, ArrayList<String> salon){

        table = (TableLayout)findViewById(R.id.TableLayout01);

        // 1) Create a tableLayout and its params
        TableLayout.LayoutParams tableLayoutParams = new TableLayout.LayoutParams();
        TableLayout tableLayout = new TableLayout(this);
        tableLayout.setBackgroundColor(Color.BLACK);

        // 2) create tableRow params
        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams();
        tableRowParams.setMargins(1, 1, 1, 1);

        for(int i=0;i<nombre.size();i++)
        {
            TableRow row=new TableRow(this);
            row.setBackgroundColor(Color.BLACK);
            ///
            String nombres = nombre.get(i);
            String codigos = codigo.get(i);
            String salones = salon.get(i);
            ///
            TextView tv1=new TextView(this);
            tv1.setTextAppearance(this, android.R.style.TextAppearance_Large);
            tv1.setGravity(Gravity.CENTER);
            tv1.setText(nombres);
            tv1.setBackgroundColor(Color.WHITE);
            ////
            TextView tv2=new TextView(this);
            tv2.setTextAppearance(this, android.R.style.TextAppearance_Large);
            tv2.setGravity(Gravity.CENTER);
            tv2.setText(codigos);
            tv2.setBackgroundColor(Color.WHITE);
            ////
            TextView tv3=new TextView(this);
            tv3.setTextAppearance(this, android.R.style.TextAppearance_Large);
            tv3.setGravity(Gravity.CENTER);
            tv3.setText(salones);
            tv3.setBackgroundColor(Color.WHITE);
            ////
            TextView tv4=new TextView(this);
            tv4.setTextAppearance(this, android.R.style.TextAppearance_Large);
            tv4.setGravity(Gravity.CENTER);
            tv4.setText(" ");
            tv4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.imc_delete, 0, 0, 0);
            tv4.setBackgroundColor(Color.WHITE);
            //
            ///
            row.addView(tv1,tableRowParams);
            row.addView(tv2,tableRowParams);
            row.addView(tv3,tableRowParams);
            row.addView(tv4,tableRowParams);
            ///
            table.addView(row,tableLayoutParams);
        }

    }


    public static ArrayList<String> createNombresList(int numContacts, List<InfoSalonesItem> infosalon) {
        ArrayList<String> data = new ArrayList<String>();
        int counter = 0;
        for (int i = 1; i <= numContacts; i++) {
            if(infosalon.get(counter).getNombre().length() >=9 ) {
            data.add(infosalon.get(counter).getNombre().substring(0,9));
            }
            else{
                data.add(infosalon.get(counter).getNombre());
            }
            counter++;
        }

        return data;
    }

    public static ArrayList<String> createCodigosList(int numContacts, List<InfoSalonesItem> infosalon) {
        ArrayList<String> data = new ArrayList<String>();
        int counter = 0;
        for (int i = 1; i <= numContacts; i++) {
            data.add(infosalon.get(counter).getCodigo());
            counter++;
        }

        return data;
    }

    public static ArrayList<String> createSalonesList(int numContacts, List<InfoSalonesItem> infosalon) {
        ArrayList<String> data = new ArrayList<String>();
        int counter = 0;
        for (int i = 1; i <= numContacts; i++) {
            data.add(infosalon.get(counter).getTipoSalon().get(0).getNombre());
                 counter++;
        }

        return data;
    }



}