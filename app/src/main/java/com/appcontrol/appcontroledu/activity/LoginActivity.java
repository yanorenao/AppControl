package com.appcontrol.appcontroledu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.appcontrol.appcontroledu.APIClient;
import com.appcontrol.appcontroledu.APIInterface;
import com.appcontrol.appcontroledu.R;
import com.appcontrol.appcontroledu.data.Login;
import com.appcontrol.appcontroledu.data.Persona;
import com.appcontrol.appcontroledu.data.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //getSupportActionBar().hide();
        final Button btn_iniciar = (Button) findViewById(R.id.btn_iniciar);
        final TextView tvSign_up = (TextView) findViewById(R.id.sign_up);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        //metodo para llamar el formulario de perfil registro
        tvSign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LoginActivity.this, RegistroPerfilActivity.class);
                startActivity(myIntent);
            }
        });

        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateTextInputEditText(idsEditText())){
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(getValuesLogin());// obj is your objectjosn/
                Log.d("Json",json);
                    PostPersona(getValuesLogin());
                }

            }
        });
    }

    private void PostPersona(Login object) {
        Call<JsonObject> call = apiInterface.sendLogin(object);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject myJson = response.body().getAsJsonObject();
                    Log.d("Json", " " + myJson.toString());
                    Intent myIntent = new Intent(LoginActivity.this, MenuPrincipalUserActivity.class);
                    myIntent.putExtra("id", response.body().getAsJsonObject().getAsJsonObject("infoUser").getAsJsonArray("persona").get(0).getAsJsonObject().get("_id").toString().replace("\"",""));
                    myIntent.putExtra("myjson", myJson.toString());
                    startActivity(myIntent);

                } else {

                    try {
                        Toast.makeText(getApplicationContext(), response.errorBody().string(), Toast.LENGTH_LONG).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private Login getValuesLogin(){
        HashMap dataz = new HashMap<String, String>(getValuesTextInputEditText(idsEditText()));
        Login login = new Login();
        login.setUsuario(dataz.get("et_login").toString());
        login.setClave(dataz.get("et_password").toString());
    return login;
    }


    private HashMap getValuesTextInputEditText(int[] ids){
        HashMap<String, String> registros = new HashMap<String, String>();
        for(int id : ids){
            TextInputEditText t = findViewById(id);
            String key = t.getResources().getResourceEntryName(t.getId());
            registros.put(key,t.getText().toString());
        }
        return registros;
    }

    public boolean validateTextInputEditText(int[] ids){
        boolean isEmpty = false;

        for(int id: ids)
        {
            TextInputEditText et = findViewById(id);

            if(TextUtils.isEmpty(et.getText().toString()))
            {
                et.requestFocus();
                et.setError("Ingresa un valor.");
                isEmpty = true;
            }
        }

        return isEmpty;
    }

    private int[]  idsEditText(){
        int[] ids = new int[]
                {
                        R.id.et_password,
                        R.id.et_login
                };

        return ids;
    }


}