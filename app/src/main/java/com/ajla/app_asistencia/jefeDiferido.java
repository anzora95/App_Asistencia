package com.ajla.app_asistencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class jefeDiferido extends AppCompatActivity {
    TextView caja1;
    TextView caja2;
    TextView caja3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jefe_diferido);
        caja1=(TextView) findViewById(R.id.idnombre);
        caja2=(TextView) findViewById(R.id.idMateria);
        caja3=(TextView) findViewById(R.id.idmotivo);



    }
}
