package com.appcontrol.appcontroledu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ReporteSaludActivity extends AppCompatActivity {

    private static final int MAX_STEP = 6;
    private int current_step = 0;
    private ProgressBar progressBar;
    private TextView status;
    private TextView title;
    String questions[] = {
            "¿Tiene fiebre o la ha tenido en los últimos 14 días? , esto es, una temperatura mayor o igual a 38°C.",
            "¿Tiene o ha tenido en los últimos 14 días dificultad respiratoria o algún otro síntoma respiratorio como tos. secreción nasal, pérdida del olfato?",
            "¿Tiene o ha tenido en los últimos 14 días diarrea u otras molestias digestivas?",
            "¿Tiene o ha tenido sensación de mucho cansancio o malestar en los últimos 14 días?",
            "¿Ha notado una pérdida del sentido del gusto o del olfato en los últimos 14 días? ",
            "¿Ha estado en contacto o conviviendo con alguna persona sospechosa o confirmada de coronavirus por COVID-19?",
            "En caso de haber presentado infección por COVID 19: ¿sigue usted en aislamiento?"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_salud);
        //initToolbar();
        initComponent();
    }



    private void initComponent() {
        status = (TextView) findViewById(R.id.status);
        title = (TextView) findViewById(R.id.text_titulo_reporte);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        progressBar.setMax(MAX_STEP);
        progressBar.setProgress(current_step);
        progressBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);

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
        //Genera preguntas para el reporte de auto Salud
        status.setText(questions[current_step]);
    }

    private void nextStep(int progress) {
        if (progress < MAX_STEP) {
            progress++;
            current_step = progress;
            ViewAnimation.fadeOutIn(status);
        }

        status.setText(questions[current_step]);
        progressBar.setProgress(current_step);
    }

    private void backStep(int progress) {
        if (progress > 1) {
            progress--;
            current_step = progress;
            ViewAnimation.fadeOutIn(status);
        }

        status.setText(questions[current_step]);
        progressBar.setProgress(current_step);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}