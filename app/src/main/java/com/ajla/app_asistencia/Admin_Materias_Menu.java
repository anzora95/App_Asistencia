package com.ajla.app_asistencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Admin_Materias_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__materias__menu);
    }

    public void matmenu(View view) {
        Intent MMenuBoton = null;
        switch (view.getId()){

            case R.id.btnOfertaCiclo:
                MMenuBoton = new Intent(Admin_Materias_Menu.this,Admin_Menu_Oferta_Ciclo.class);
                break;
            //case R.id.btnCatalogoMaterias:

        }
        startActivity(MMenuBoton);
    }
}
