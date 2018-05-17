package com.ajla.app_asistencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Admin_Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__inicio);

    }

    public void prueba(View view) {
        Intent MateriaBoton = null;
        switch (view.getId()){

            case R.id.btnMateria:
                MateriaBoton = new Intent(Admin_Inicio.this,Admin_Materias_Menu.class);
            break;
            // case R.id.btnMaestro:
            // case R.id.btnLocales:
            // case R.id.btnAlumno:
            // case R.id.Area:
        }

        startActivity(MateriaBoton);
    }
}
