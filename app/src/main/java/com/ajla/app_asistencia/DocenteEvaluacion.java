package com.ajla.app_asistencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class DocenteEvaluacion extends AppCompatActivity implements View.OnClickListener{
    Button btnguardar;
    Calendar calendario;
    TextView evaluacion;
    TextView fecha;
    EditText numeva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_evaluacion);
        btnguardar=(Button) findViewById(R.id.botonguardar);
        btnguardar.setOnClickListener(this);
        evaluacion=(TextView) findViewById(R.id.textoevaluacion);
        fecha=(TextView) findViewById(R.id.textofecha);
        numeva=(EditText) findViewById(R.id.editnumeva);

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(DocenteEvaluacion.this,"guardado",Toast.LENGTH_LONG).show();
    }
}
