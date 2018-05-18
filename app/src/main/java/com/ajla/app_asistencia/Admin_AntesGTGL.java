package com.ajla.app_asistencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Admin_AntesGTGL extends AppCompatActivity {

    String datospuente, codmate,codciclo,codoferta;

    private TextView nombreMateria; //Onda del video
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__antes_gtgl);
        nombreMateria=(TextView) findViewById(R.id.nombreMateria); //Onda del video
        Bundle parametrosXD =  getIntent().getExtras();
        if (parametrosXD != null){

        Bundle listav = getIntent().getExtras();
        codmate = listav.getString("ofercodmate");
        codciclo= listav.getString("cicloofer");
        codoferta = listav.getString("codoferta");//Onda del video

    }

    public void AntesGTGL(View view) {
        Intent GTGLBoton= null;
        switch (view.getId()){

            case R.id.btnGT:
                GTGLBoton = new Intent(Admin_AntesGTGL.this,Admin_Asig_GT.class);
                GTGLBoton.putExtra("codigodelamateria", codmate);
                GTGLBoton.putExtra("ciclodelaoferta",codciclo);
                GTGLBoton.putExtra("codigodelaoferta",codoferta);
                startActivity(GTGLBoton);
                break;
            case R.id.btnGL:
                GTGLBoton = new Intent (Admin_AntesGTGL.this, Admin_Asig_GL.class);
                GTGLBoton.putExtra("codigodelamateria", codmate);
                GTGLBoton.putExtra("ciclodelaoferta",codciclo);
                GTGLBoton.putExtra("codigodelaoferta",codoferta);
                startActivity(GTGLBoton);
                break;
        }

        startActivity(GTGLBoton);
    }
}
