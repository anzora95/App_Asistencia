package com.ajla.app_asistencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class jefeDiferido extends AppCompatActivity implements View.OnClickListener {
    TextView nombre;
    TextView materia;
    TextView motivo;
    Button baceptar;
    Button bdenegar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jefe_diferido);
        nombre=(TextView) findViewById(R.id.idnombre);
        materia=(TextView) findViewById(R.id.idMateria);
        motivo=(TextView) findViewById(R.id.idmotivo);
        baceptar=(Button) findViewById(R.id.aceptar);
        bdenegar=(Button) findViewById(R.id.denegar);
        baceptar.setOnClickListener(this);
        bdenegar.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.aceptar:
            //String datoaprob= "al alumno"+nombre.getText()+"se le aprobo su solicitud";
                Toast.makeText(jefeDiferido.this,"se aprobo la solicitud",Toast.LENGTH_LONG).show();
            break;
            case R.id.denegar:
                //String datoden= "al alumno"+nombre.getText()+"se le denego su solicitud";
                Toast.makeText(jefeDiferido.this,"se denego la solicitud",Toast.LENGTH_LONG).show();
                //ver video 14" curso introduccion a android: pasar datos entre actividades de codigofacilito
            break;
        }
    }
}
