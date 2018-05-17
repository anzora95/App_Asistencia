package com.ajla.app_asistencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Admin_Asig_GL extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__asig__gl);
    }

    public void onGL(View view) {
        Toast.makeText(Admin_Asig_GL.this,"Grupo Guardado con exito",Toast.LENGTH_SHORT).show();
    }
}
