package com.ajla.app_asistencia;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Admin_Menu_Oferta_Ciclo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__menu__oferta__ciclo);


        ActionBar action=getSupportActionBar();
        action.setDisplayHomeAsUpEnabled(true);
    }

    public void oferciclo(View view) {
        Intent RGtGl = null;
        switch ( view.getId()){

            case R.id.btnRegistGTGL:
                RGtGl = new Intent(Admin_Menu_Oferta_Ciclo.this, Admin_Registro_GL_GT.class);
                break;
             case R.id.btnAsigMaterias:
                RGtGl = new Intent(Admin_Menu_Oferta_Ciclo.this,AdminAsignarMaterias.class);
        }
        startActivity(RGtGl);
    }
}
