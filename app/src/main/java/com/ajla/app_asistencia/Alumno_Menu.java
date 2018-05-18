package com.ajla.app_asistencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Alumno_Menu extends AppCompatActivity {
    Button btn_inscri_Alumenu;
    Button btn_asist_alumenu;
    Button btn_dif_alumen;
    TextView txtV_alumn_mennu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno__menu);

        btn_inscri_Alumenu=findViewById(R.id.btn_inscri_Alumenu);
        btn_dif_alumen=findViewById(R.id.btn_dif_alumen);
        btn_asist_alumenu=findViewById(R.id.btn_asist_alumenu);

        btn_inscri_Alumenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte_Inscri = new Intent(Alumno_Menu.this, Alumno_Materia.class);
                startActivity(inte_Inscri);
            }
        });

        btn_asist_alumenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte_Asis= new Intent(Alumno_Menu.this, Alumno_Asistencia.class);
                startActivity(inte_Asis);
            }
        });

        btn_dif_alumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte_Dif = new Intent(Alumno_Menu.this,Alumno_diferido.class);
                startActivity(inte_Dif);

            }
        });

    }
}
