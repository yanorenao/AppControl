package com.appcontrol.appcontroledu;


import com.appcontrol.appcontroledu.activity.ReporteSaludActivity;
import com.appcontrol.appcontroledu.data.GetPerfiles;
import com.appcontrol.appcontroledu.data.InfoReporteSalud;
import com.appcontrol.appcontroledu.data.Institucion;
import com.appcontrol.appcontroledu.data.Login;
import com.appcontrol.appcontroledu.data.instituciones.GetInstitucion;
import com.appcontrol.appcontroledu.data.instituciones.Instituciones;
import com.appcontrol.appcontroledu.data.perfiles.Perfiles;
import com.appcontrol.appcontroledu.data.Persona;
import com.appcontrol.appcontroledu.data.PutPersona;
import com.appcontrol.appcontroledu.data.ReporteSalud;
import com.appcontrol.appcontroledu.data.Salon;
import com.appcontrol.appcontroledu.data.User;
import com.appcontrol.appcontroledu.data.Usuario;
import com.appcontrol.appcontroledu.data.persona.PostPersona;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface APIInterface {

    @Headers({
            "Content-type: application/json"
    })



    @POST("usuarios/login")
    Call<JsonObject> sendLogin(@Body Login logins);

    @POST("institucion/existe")
    Call<Institucion> exist(@Body Institucion instituciones);

    @POST("salon/all")
    Call<List<Salon>> GetAllSalon(@Body Salon salones);

    @POST("persona/getInstitucion")
    Call<Instituciones> getInfoInstitucion(@Body GetInstitucion infoInstitucion);

    @POST("persona")
    Call<PostPersona> sendPersona(@Body PostPersona personas);

    @PUT("persona")
    Call<PutPersona> sendPutPersona(@Body PutPersona personas);

    @POST("usuarios")
    Call<Usuario> sendUsuario(@Body Usuario usuarios);

    @POST("autoreporte")
    Call<ReporteSalud> sendReporte(@Body ReporteSalud reporte);

    @POST("autoreporte/existe")
    Call<InfoReporteSalud> existReporte(@Body InfoReporteSalud infoReporteSalud);

    @POST("persona/getPerfiles")
    Call<List<Perfiles>> getPerfiles(@Body GetPerfiles perfiles);

}

