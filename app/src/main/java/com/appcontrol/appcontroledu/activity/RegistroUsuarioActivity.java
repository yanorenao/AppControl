package com.appcontrol.appcontroledu.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.appcontrol.appcontroledu.APIClient;
import com.appcontrol.appcontroledu.APIInterface;
import com.appcontrol.appcontroledu.R;
import com.appcontrol.appcontroledu.data.Globals;
import com.appcontrol.appcontroledu.data.InfoUsuario;
import com.appcontrol.appcontroledu.data.Institucion;
import com.appcontrol.appcontroledu.data.Persona;
import com.appcontrol.appcontroledu.data.PutPersona;
import com.appcontrol.appcontroledu.data.Salon;
import com.appcontrol.appcontroledu.data.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegistroUsuarioActivity extends AppCompatActivity {

    APIInterface apiInterface;
    HashMap<String, String> documento = new HashMap<String, String>();
    String institucion = "";
    String salon = "";


    //EditText et_salon = (EditText)findViewById(R.id.et_salon);
    private Institucion statistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        Globals globalIndex = ((Globals) getApplicationContext());
        apiInterface = APIClient.getClient().create(APIInterface.class);
        EditText et_fechaNacimiento = findViewById(R.id.et_fechaNacimiento);
        EditText et_nit = findViewById(R.id.et_nit);
        EditText et_salon = findViewById(R.id.et_salon);
        EditText et_documento = findViewById(R.id.et_tipoDocumento);
        EditText et_nombres = findViewById(R.id.et_nombres);
        EditText et_apellidos = findViewById(R.id.et_apellidos);
        EditText et_email = findViewById(R.id.et_email);
        EditText et_telefono = findViewById(R.id.et_telefono);
        EditText et_numeroDocumento = findViewById(R.id.et_numeroDocumento);
        EditText et_barrio = findViewById(R.id.et_barrio);
        EditText et_direccion = findViewById(R.id.et_direccion);
        EditText et_nombreResponsable = findViewById(R.id.et_nombreResponsable);
        EditText et_apellidoResponsable = findViewById(R.id.et_apellidoResponsable);
        EditText et_emailResponsable = findViewById(R.id.et_emailResponsable);
        EditText et_TelefonoResponsable = findViewById(R.id.et_TelefonoResponsable);


        final Button btn_guardar = (Button) findViewById(R.id.bt_submit);
        documento.put("6033d144738cb125f84770a3", "TARJETA DE IDENTIDAD");
        documento.put("6033d151738cb125f84770a4", "CÉDULA DE CIUDADANÍA");
        documento.put("6033d15d738cb125f84770a5", "TARJETA DE EXTRANJERÍA");
        documento.put("6033d166738cb125f84770a6", "CÉDULA DE EXTRANJERÍA");

        if (getIntent().getStringExtra("id") != null) {
            Gson gson = new Gson();
            InfoUsuario infoUsuario = gson.fromJson(getIntent().getStringExtra("myjson"), InfoUsuario.class);
            et_salon.setText(infoUsuario.getInfoUser().getPersona().get(0).getSalon().get(0).getNombre());
            et_nombres.setText(infoUsuario.getInfoUser().getPersona().get(0).getNombres());
            et_apellidos.setText(infoUsuario.getInfoUser().getPersona().get(0).getApellidos());
            et_email.setText(infoUsuario.getInfoUser().getPersona().get(0).getCorreoElectronico());
            et_telefono.setText(infoUsuario.getInfoUser().getPersona().get(0).getTelefono());
            et_fechaNacimiento.setText(infoUsuario.getInfoUser().getPersona().get(0).getFechaNacimiento().substring(0, 10));
            et_documento.setText(infoUsuario.getInfoUser().getPersona().get(0).getTipoDocumento().get(0).getNombre());
            et_numeroDocumento.setText(infoUsuario.getInfoUser().getUsuario());
            et_barrio.setText(infoUsuario.getInfoUser().getPersona().get(0).getBarrio());
            et_direccion.setText(infoUsuario.getInfoUser().getPersona().get(0).getDireccion());
            et_nombreResponsable.setText(infoUsuario.getInfoUser().getPersona().get(0).getNombreResponsable());
            et_apellidoResponsable.setText(infoUsuario.getInfoUser().getPersona().get(0).getApellidoResponsable());
            et_emailResponsable.setText(infoUsuario.getInfoUser().getPersona().get(0).getEmailResponsable());
            et_TelefonoResponsable.setText(infoUsuario.getInfoUser().getPersona().get(0).getTelefono());
            institucion = infoUsuario.getInfoUser().getPersona().get(0).getInstitucion().get(0);
            salon = infoUsuario.getInfoUser().getPersona().get(0).getSalon().get(0).getId();


        }

        et_salon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Name = et_nit.getText().toString();
                final String word = et_nit.getText().toString();
                if (Name.length() == 0) {
                    et_nit.requestFocus();
                    et_nit.setError("El campo Nit no puede estar vacío");

                } else if (!Name.matches("(^[0-9]+-{1}[0-9]{1})")) {
                    et_nit.requestFocus();
                    et_nit.setError("Solo se permite numero y guion ");


                } else if (word.length() == 0) {
                    et_nit.requestFocus();
                    et_nit.setError("El campo Nit no puede estar vacío");

                } else {
                    existsInstitution(et_nit.getText().toString());
                }
            }
        });

        et_nit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    et_nit.setText("");
                    et_nit.setText("");

                }
            }
        });

        et_documento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] valuesDocuement = documento.values().toArray(new String[0]);
                String[] keysDocuement = documento.keySet().toArray(new String[0]);
                showStateDialogDocument(v, valuesDocuement, keysDocuement);

                Log.d("retrofit", " documento: " + globalIndex.getIdDocument() + " salones: " + globalIndex.getIdSalon() + " Institucion:" + globalIndex.getIdInstitucion());


            }
        });

        et_fechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialogDatePickerDark((EditText) view);

            }
        });



            btn_guardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ((getIntent().getStringExtra("id") == null)) {
                        if (!validateEditText(idsEditText())) {
                            globalIndex.setIdTipoPerosna(getPutExtra(savedInstanceState));
                            PostPersona(getValuesPersona());
                        } else {
                            Toast.makeText(getApplicationContext(), "Por favor valide el ingreso de la información.", Toast.LENGTH_LONG).show();
                        }
                    } else {

                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        //Log.d("perosna",persona);
                        PutPersona personas = getPutValuesPersona();
                        PutPersonas(personas);
                        String json = gson.toJson(personas);// obj is your objectjosn
                        Log.d("Json",json);
                        Toast.makeText(getApplicationContext(),"modificar perfil",Toast.LENGTH_SHORT).show();
                    }

                }
            });


    }


    private void existsInstitution(String nit) {
        Institucion institucion = new Institucion();
        institucion.setNit(nit);
        Call<Institucion> call = apiInterface.exist(institucion);
        call.enqueue(new Callback<Institucion>() {
            @Override
            public void onResponse(Call<Institucion> call, Response<Institucion> response) {
                Globals globalIndex = ((Globals) getApplicationContext());
                EditText et_salon = (EditText) findViewById(R.id.et_salon);
                et_salon.setTextColor(Color.parseColor("#ffffff"));
                et_salon.setText(response.body().getId());
                GetAllSalon(response.body().getId());


            }

            @Override
            public void onFailure(Call<Institucion> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Por favor contacte al administrador Nit no registrado.", Toast.LENGTH_LONG).show();


            }
        });


    }

    private void PutPersonas(PutPersona object) {
        Call<PutPersona> call = apiInterface.sendPutPersona(object);
        call.enqueue(new Callback<PutPersona>() {
            @Override
            public void onResponse(Call<PutPersona> call, Response<PutPersona> response) {

            }

            @Override
            public void onFailure(Call<PutPersona> call, Throwable t) {

            }
        });
    }

    private void PostUsuario(Usuario object) {
        Call<Usuario> call = apiInterface.sendUsuario(object);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                //Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                if (response.isSuccessful()) {
                    showCustomDialog();

                } else {

                    try {
                        Toast.makeText(getApplicationContext(), response.errorBody().string(), Toast.LENGTH_LONG).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

    private void PostPersona(Persona object) {
        Call<Persona> call = apiInterface.sendPersona(object);
        call.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, Response<Persona> response) {

                Globals globalIdPersona = ((Globals) getApplicationContext());
                globalIdPersona.setIdPersona(response.body().getId());
                //HashMap dataz = new HashMap<String, String>(getValuesEditext(idsEditText()));
                //Gson gson = new GsonBuilder().setPrettyPrinting().create();
                //String json = gson.toJson(getValuesUsuario());// obj is your objectjosn
                //Log.d("Json",json);
                PostUsuario(getValuesUsuario());


            }

            @Override
            public void onFailure(Call<Persona> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }

    private int[] idsEditText() {
        int[] ids = new int[]
                {
                        R.id.et_salon,
                        R.id.et_nombres,
                        R.id.et_apellidos,
                        R.id.et_apellidos,
                        R.id.et_email,
                        R.id.et_telefono,
                        R.id.et_fechaNacimiento,
                        R.id.et_tipoDocumento,
                        R.id.et_numeroDocumento,
                        R.id.et_contraseña,
                        R.id.et_barrio,
                        R.id.et_direccion,
                        R.id.et_nombreResponsable,
                        R.id.et_apellidoResponsable,
                        R.id.et_emailResponsable,
                        R.id.et_TelefonoResponsable

                };

        return ids;
    }

    private List stringToList(String value) {
        List<String> list = new ArrayList<>();
        list.add(value);
        return list;
    }

    private HashMap getValuesEditext(int[] ids) {
        HashMap<String, String> registros = new HashMap<String, String>();
        for (int id : ids) {
            EditText t = findViewById(id);
            String key = t.getResources().getResourceEntryName(t.getId());
            registros.put(key, t.getText().toString());
        }
        return registros;
    }

    //

    private Usuario getValuesUsuario() {
        Globals global = ((Globals) getApplicationContext());
        HashMap dataz = new HashMap<String, String>(getValuesEditext(idsEditText()));
        Usuario usuario = new Usuario();
        usuario.setPersona(stringToList(global.getIdPersona()));
        usuario.setTipoUsuario(stringToList(global.getIdTipoPerosna()));
        usuario.setEstado(stringToList("6033d0cc738cb125f8477099"));
        usuario.setUsuario(dataz.get("et_numeroDocumento").toString());
        usuario.setClave(dataz.get("et_contraseña").toString());
        return usuario;

    }

    private Persona getValuesPersona() {
        Globals global = ((Globals) getApplicationContext());
        HashMap dataz = new HashMap<String, String>(getValuesEditext(idsEditText()));
        Persona persona = new Persona();
        persona.setTipoDocumento(stringToList(global.getIdDocument()));
        persona.setId("true");
        persona.setEstado(stringToList("6033d0cc738cb125f8477099"));
        persona.setInstitucion(stringToList(global.getIdInstitucion()));
        persona.setSalon(stringToList(global.getIdSalon()));
        //id tipo persona
        persona.setId(global.getIdTipoPerosna());
        persona.setNombre(dataz.get("et_nombres").toString());
        persona.setApellidos(dataz.get("et_apellidos").toString());
        persona.setCorreoElectronico(dataz.get("et_email").toString());
        persona.setTelefono(dataz.get("et_telefono").toString());
        persona.setFechaNacimiento(dataz.get("et_fechaNacimiento").toString());
        global.setDocument(dataz.get("et_numeroDocumento").toString());
        global.setContraseña(dataz.get("et_contraseña").toString());
        persona.setBarrio(dataz.get("et_barrio").toString());
        persona.setDireccion(dataz.get("et_direccion").toString());
        persona.setNombreResponsable(dataz.get("et_nombreResponsable").toString());
        persona.setApellidoResponsable(dataz.get("et_apellidoResponsable").toString());
        persona.setEmailResponsable(dataz.get("et_emailResponsable").toString());
        persona.setTelefonoResponsable(dataz.get("et_TelefonoResponsable").toString());
        return persona;
    }


    public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }


    private PutPersona getPutValuesPersona() {
        Globals global = ((Globals) getApplicationContext());
        HashMap dataz = new HashMap<String, String>(getValuesEditext(idsEditText()));
        PutPersona persona = new PutPersona();
        //id tipo persona
        persona.setIdPersona(getIntent().getStringExtra("id"));
        String tipoDocumento = dataz.get("et_tipoDocumento").toString();
        persona.setNombre(dataz.get("et_nombres").toString());
        persona.setApellidos(dataz.get("et_apellidos").toString());
        persona.setCorreoElectronico(dataz.get("et_email").toString());
        persona.setTelefono(dataz.get("et_telefono").toString());
        persona.setFechaNacimiento(dataz.get("et_fechaNacimiento").toString());
        global.setDocument(dataz.get("et_numeroDocumento").toString());
        global.setContraseña(dataz.get("et_contraseña").toString());
        persona.setBarrio(dataz.get("et_barrio").toString());
        persona.setDireccion(dataz.get("et_direccion").toString());
        persona.setNombreResponsable(dataz.get("et_nombreResponsable").toString());
        persona.setApellidoResponsable(dataz.get("et_apellidoResponsable").toString());
        persona.setEmailResponsable(dataz.get("et_emailResponsable").toString());
        persona.setTelefonoResponsable(dataz.get("et_TelefonoResponsable").toString());
        persona.setIsUsed("true");
        persona.setEstado("6033d0cc738cb125f8477099");
        persona.setTipoDocumento(getKeyFromValue(documento,tipoDocumento).toString());
        persona.setInstitucion(institucion);
        persona.setSalon(salon);
        return persona;
    }


    private void GetAllSalon(String idInstitucion) {
        Globals globalIndex = ((Globals) getApplicationContext());
        globalIndex.setIdInstitucion(idInstitucion);
        Salon salon = new Salon();
        salon.setInstitucion(idInstitucion);
        Call<List<Salon>> call = apiInterface.GetAllSalon(salon);
        call.enqueue(new Callback<List<Salon>>() {
            @Override
            public void onResponse(Call<List<Salon>> call, Response<List<Salon>> response) {
                if (response.isSuccessful()) {

                    List<Salon> posts = response.body();
                    HashMap<String, String> aulas = new HashMap<String, String>();

                    for (Salon post : posts) {

                        aulas.put(post.getId(), post.getNombre());
                        Log.d("retrofit", "HasMap: " + aulas.values().toArray());
                    }

                    Globals globalIndex = ((Globals) getApplicationContext());
                    String[] values = aulas.values().toArray(new String[0]);
                    String[] keys = aulas.keySet().toArray(new String[0]);
                    showStateDialog(values, keys);


                } else {
                    Log.d("retrofit", "erorrrrrr");
                }

            }

            @Override
            public void onFailure(Call<List<Salon>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }


    private void dialogDatePickerDark(final EditText bt) {
        Calendar cur_calender = Calendar.getInstance();
        DatePickerDialog datePicker = DatePickerDialog.newInstance(
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        long date_ship_millis = calendar.getTimeInMillis();
                        ((TextView) findViewById(R.id.et_fechaNacimiento)).setError(null);
                        ((TextView) findViewById(R.id.et_fechaNacimiento)).clearFocus();
                        ((TextView) findViewById(R.id.et_fechaNacimiento)).setText(getFormattedDateSimple(date_ship_millis));
                    }
                },
                cur_calender.get(Calendar.YEAR),
                cur_calender.get(Calendar.MONTH),
                cur_calender.get(Calendar.DAY_OF_MONTH)
        );
        //set dark theme
        datePicker.setThemeDark(true);
        datePicker.setAccentColor(getResources().getColor(R.color.colorPrimary));
        datePicker.show(getFragmentManager(), "Datepickerdialog");
    }


    public static String getFormattedDateSimple(Long dateTime) {
        SimpleDateFormat newFormat = new SimpleDateFormat("MMMM dd, yyyy");
        return newFormat.format(new Date(dateTime));
    }


    public String getPutExtra(Bundle savedInstanceState) {
        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                newString = null;
            } else {
                newString = extras.getString("tipoUsuario");

            }
        } else {
            newString = (String) savedInstanceState.getSerializable("tipoUsuario");

        }
        return newString;
    }

    // validar Nit colombia
    public static int calcularDigito(@NotNull String nit) {
        int digito = 0, acum = 0, residuo = 0;
        char[] nit_array = nit.toCharArray();
        int[] primos = {3, 7, 13, 17, 19, 23, 29, 37, 41, 43, 47, 53, 39, 67, 71};
        int max = nit_array.length;

        for (int i = 0; i < nit.length(); i++) {
            acum += Integer.parseInt(String.valueOf(nit_array[max - 1])) * primos[i];
            max--;
        }

        residuo = acum % 11;
        if (residuo > 1) {
            digito = 11 - residuo;
        } else {
            digito = residuo;
        }

        return digito;
    }

    private void showStateDialog(String[] values, String[] keys) {
        Globals globalIndex = ((Globals) getApplicationContext());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Salas");
        builder.setSingleChoiceItems(values, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                globalIndex.setIdSalon(keys[i]);
                ((EditText) findViewById(R.id.et_salon)).setText(values[i]);
                ((EditText) findViewById(R.id.et_salon)).setTextColor(Color.parseColor("#000000"));
                dialogInterface.dismiss();

            }
        });
        builder.show();
    }


    private String showStateDialogDocument(final View v, String[] valuesDocuement, String[] keysDocuement) {
        Globals globalIndex = ((Globals) getApplicationContext());
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle("Documento");
        builder2.setSingleChoiceItems(valuesDocuement, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int w) {
                globalIndex.setIdDocument(keysDocuement[w]);
                ((EditText) v).setError(null);
                v.clearFocus();
                ((EditText) v).setText(valuesDocuement[w]);
                dialogInterface.dismiss();
            }
        });
        builder2.show();

        return keysDocuement[globalIndex.getMyIndex()];
    }

    public boolean validateEditText(int[] ids) {
        boolean isEmpty = false;

        for (int id : ids) {
            EditText et = (EditText) findViewById(id);

            if (TextUtils.isEmpty(et.getText().toString())) {
                et.requestFocus();
                et.setError("Ingresa un valor.");
                isEmpty = true;
            }
        }

        return isEmpty;
    }


    private void showCustomDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_warning);
        dialog.setCancelable(true);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;


        ((AppCompatButton) dialog.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(RegistroUsuarioActivity.this, LoginActivity.class);
                startActivity(myIntent);
                //Toast.makeText(getApplicationContext(), ((AppCompatButton) v).getText().toString() + " Clicked", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }


}
