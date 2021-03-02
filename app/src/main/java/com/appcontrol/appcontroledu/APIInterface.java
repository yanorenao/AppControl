package com.appcontrol.appcontroledu;


import com.appcontrol.appcontroledu.data.Institucion;
import com.appcontrol.appcontroledu.data.Login;
import com.appcontrol.appcontroledu.data.Persona;
import com.appcontrol.appcontroledu.data.Salon;
import com.appcontrol.appcontroledu.data.User;
import com.appcontrol.appcontroledu.data.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIInterface {

    @Headers({

            "Content-type: application/json"

    })

    @GET("users")
    Call<List<User>>getUsers();

    @POST("users/login")
    Call<Login> sendLogin(@Body Login logins);

    @POST("institucion/existe")
    Call<Institucion> exist(@Body Institucion instituciones);

    @POST("salon/all")
    Call<List<Salon>> GetAllSalon(@Body Salon salones);

    @POST("persona")
    Call<Persona> sendPersona(@Body Persona personas);

    @POST("usuarios")
    Call<Usuario> sendUsuario(@Body Usuario usuarios);

}

