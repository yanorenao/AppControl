package com.appcontrol.appcontroledu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.appcontrol.appcontroledu.APIClient;
import com.appcontrol.appcontroledu.APIInterface;
import com.appcontrol.appcontroledu.R;
import com.appcontrol.appcontroledu.data.Login;
import com.appcontrol.appcontroledu.data.User;

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
        getSupportActionBar().hide();
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
                sendPost();

                // Call<List<User>> call2 = apiInterface.getUsers();
                /*call2.enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        if (!response.isSuccessful()) {
                            tvSign_up.setText("Code " + response.code());
                            return;
                        }

                        List<User> posts = response.body();

                        for (User post : posts) {
                            String content = "";
                            content += "ID: " + post.getId() + "\n";


                            tvSign_up.append(content);

                        }

                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {

                    }
                });*/
                //Intent myIntent = new Intent(LoginActivity.this, MenuPrincipalUserActivity.class);
                //startActivity(myIntent);
            }
        });
    }

    private void sendPost() {
        Login login = new Login();
        login.setEmail("pruba1321@gmail.com");
        login.setPassword("1234567");
        Call<List<User>> call2 = apiInterface.getUsers();
        Call<Login> call = apiInterface.sendLogin(login);
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                Toast.makeText(getApplicationContext(), response.body().getToken(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });


    }
}