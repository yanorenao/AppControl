package com.appcontrol.appcontroledu.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.appcontrol.appcontroledu.APIClient;
import com.appcontrol.appcontroledu.APIInterface;
import com.appcontrol.appcontroledu.R;
import com.appcontrol.appcontroledu.data.InfoReporteSalud;
import com.appcontrol.appcontroledu.data.InfoUsuario;
import com.appcontrol.appcontroledu.data.ReporteSalud;
import com.appcontrol.appcontroledu.data.RespuestasItem;
import com.appcontrol.appcontroledu.data.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.security.AccessController.getContext;

public class ReporteSaludActivity extends AppCompatActivity {

    private static final int MAX_STEP = 6;
    private int current_step = 0;
    private ProgressBar progressBar;
    private TextView status;
    private TextView title;
    private RadioGroup radioGroup;
    List<RespuestasItem> respuestasItems = new ArrayList<>();
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_salud);
        //initToolbar();
        initComponent();
    }

    private HashMap<String, String> getQuestions() {
        HashMap<String, String> questions = new HashMap<String, String>();
        questions.put("6036c14edb966d180ccf086c", "¿Tiene fiebre o la ha tenido en los últimos 14 días? , esto es, una temperatura mayor o igual a 38°C.");
        questions.put("6036c167db966d180ccf086d", "¿Tiene o ha tenido en los últimos 14 días dificultad respiratoria o algún otro síntoma respiratorio como tos. secreción nasal, pérdida del olfato?");
        questions.put("6036c17adb966d180ccf086e", "¿Tiene o ha tenido en los últimos 14 días diarrea u otras molestias digestivas?");
        questions.put("6036c191db966d180ccf086f", "¿Tiene o ha tenido sensación de mucho cansancio o malestar en los últimos 14 días?");
        questions.put("6036c19edb966d180ccf0870", "¿Ha notado una pérdida del sentido del gusto o del olfato en los últimos 14 días?");
        questions.put("6036c1a9db966d180ccf0871", "¿Ha estado en contacto o conviviendo con alguna persona sospechosa o confirmada de coronavirus por COVID-19?");
        questions.put("6036c1b7db966d180ccf0872", "En caso de haber presentado infección por COVID 19: ¿sigue usted en aislamiento?");
        return questions;
    }

    private void initComponent() {
        status = (TextView) findViewById(R.id.status);
        title = (TextView) findViewById(R.id.text_titulo_reporte);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        radioGroup = (RadioGroup) findViewById(R.id.answer);
        progressBar.setMax(MAX_STEP);
        progressBar.setProgress(current_step);
        progressBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        ((LinearLayout) findViewById(R.id.lyt_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backStep(current_step);
            }
        });

        ((LinearLayout) findViewById(R.id.lyt_next)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextStep(current_step);
            }
        });
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        String str_title = getString(R.string.tiltle_questions) + "\n" + currentDate;
        title.setText(str_title);


    }

    private void nextStep(int progress) {
        String[] valuesPregunta = getQuestions().values().toArray(new String[0]);
        String[] keysPregunta = getQuestions().keySet().toArray(new String[0]);
        boolean optionChecked = radioGroup.getCheckedRadioButtonId() == radioGroup.getChildAt(0).getId();
        setRespuestas(keysPregunta, optionChecked);
        if (progress < MAX_STEP) {
            progress++;
            current_step = progress;
            ViewAnimation.fadeOutIn(status);
        } else {
            Gson gson = new Gson();
            InfoUsuario persona = gson.fromJson(getIntent().getStringExtra("myjson"), InfoUsuario.class);
            ReporteSalud reporteSalud = new ReporteSalud();
            reporteSalud.setEstado(persona.getInfoUser().getEstado().get(0));
            reporteSalud.setFecha(getDate());
            reporteSalud.setPersona(getIntent().getStringExtra("id"));
            reporteSalud.setRespuestas(respuestasItems);
            InfoReporteSalud existe = new InfoReporteSalud();
            existe.setPersona(getIntent().getStringExtra("id"));
            PostReporteSalud(reporteSalud);
        }


        status.setText(valuesPregunta[current_step]);
        progressBar.setProgress(current_step);
    }

    private void backStep(int progress) {
        String[] valuesPregunta = getQuestions().values().toArray(new String[0]);
        if (progress > 1) {
            progress--;
            current_step = progress;
            ViewAnimation.fadeOutIn(status);
        }

        status.setText(valuesPregunta[current_step]);
        progressBar.setProgress(current_step);
    }

    private List stringToList(String value) {
        List<String> list = new ArrayList<>();
        list.add(value);
        return list;
    }

    private List booleanToList(boolean value) {
        List<Boolean> list = new ArrayList<>();
        list.add(value);
        return list;
    }

    private String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }


    private void setRespuestas(String[] keysPregunta, Boolean optionChecked) {
        RespuestasItem respuestas = new RespuestasItem();
        respuestas.setPregunta(keysPregunta[current_step]);
        respuestas.setRespuesta(optionChecked);
        respuestasItems.add(respuestas);
    }

    private void PostReporteSalud(ReporteSalud object) {
        Call<ReporteSalud> call = apiInterface.sendReporte(object);
        call.enqueue(new Callback<ReporteSalud>() {
            @Override
            public void onResponse(Call<ReporteSalud> call, Response<ReporteSalud> response) {
                if (response.isSuccessful()) {
                    if(response.body().getRespuestas() == null){
                        showCustomDialogNurse();
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
            public void onFailure(Call<ReporteSalud> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }


    private void showCustomDialog() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_info);
        dialog.setCancelable(true);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;



        ((AppCompatButton) dialog.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }

    private void showCustomDialogNurse() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_nurse);
        dialog.setCancelable(true);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;



        ((AppCompatButton) dialog.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //Toast.makeText(getApplicationContext(), ((AppCompatButton) v).getText().toString() + " Clicked", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }


}