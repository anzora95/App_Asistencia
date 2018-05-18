package com.ajla.app_asistencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class Admin_Inicio extends AppCompatActivity {
    ImageView imagen1;
    ImageView imagen2;
    ImageView imagen3;
    ImageView imagen4;
    Intent Boton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__inicio);

        imagen1 = (ImageView) findViewById(R.id.maestro);
        imagen2 = (ImageView) findViewById(R.id.materias);
        imagen3 = (ImageView) findViewById(R.id.locales);
        imagen4 = (ImageView) findViewById(R.id.alumno);

        imagen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menu= new Intent(Admin_Inicio.this, AdminMestroActivity.class);
                startActivity(menu);
            }
        });

        imagen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menu= new Intent(Admin_Inicio.this, Admin_Materias_Menu.class);
                startActivity(menu);
            }
        });
        imagen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menu= new Intent(Admin_Inicio.this, AdminLocalesActivity.class);
                startActivity(menu);

            }
        });
        imagen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menu= new Intent( Admin_Inicio.this,AdminAlumnoActivity.class);
                startActivity(menu);

            }
        });

    }


    }


