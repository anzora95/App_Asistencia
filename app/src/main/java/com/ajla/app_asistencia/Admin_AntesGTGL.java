package com.ajla.app_asistencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Admin_AntesGTGL extends AppCompatActivity {

    private TextView nombreMateria; //Onda del video
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__antes_gtgl);
        nombreMateria=(TextView) findViewById(R.id.nombreMateria); //Onda del video
        Bundle parametrosXD =  getIntent().getExtras();
        if (parametrosXD != null){

            nombreMateria.setText(parametrosXD.getString("Materias"));
        }
    }

    public void AntesGTGL(View view) {
        Intent GTGLBoton= null;
        switch (view.getId()){

            case R.id.btnGT:
                GTGLBoton = new Intent(Admin_AntesGTGL.this,Admin_Asig_GT.class);
                break;
            case R.id.btnGL:
                GTGLBoton = new Intent (Admin_AntesGTGL.this, Admin_Asig_GL.class);
                break;
        }

        startActivity(GTGLBoton);
    }
}
