package com.ajla.app_asistencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdminAsignarMaterias extends AppCompatActivity {
    Button botonguardaradmin;
    EditText ciclo;
    TextView textociclo;
    Spinner spinermaterias;
    Spinner spinercoordinador;
    ArrayList<String> lsmaterias;
    ArrayList <String> lscoordinador;
    public String datospinermateria;
    public String datospinerdocente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_asignar_materias);
        botonguardaradmin = (Button) findViewById(R.id.botonguardaradmin);
        textociclo = (TextView) findViewById(R.id.textociclo);
        ciclo = (EditText) findViewById(R.id.editciclo);
        spinermaterias = (Spinner) findViewById(R.id.spinermaterias);
        spinercoordinador = (Spinner) findViewById(R.id.spinercoordinador);


        //lista spinner materias
        lsmaterias = new ArrayList<String>();
        lsmaterias.add("seleccione");
        for (int i = 0; i <= 4; i++) {

            lsmaterias.add("Materias" + i);
        }


        //lista spinner coordinador hacerlo en un private void obtener lista y con la base
        lscoordinador = new ArrayList<String>();
        lscoordinador.add("seleccione");
        for (int i = 0; i <= 4; i++) {

            lscoordinador.add("Cordinador" + i);
        }


        //---------------------------------------------------------------
        //LIstas para listview


        //Array Adapter para spinner

        ArrayAdapter<CharSequence> adapterspmat = new ArrayAdapter(AdminAsignarMaterias.this, android.R.layout.simple_spinner_item, lsmaterias);
        spinermaterias.setAdapter(adapterspmat);



        ArrayAdapter<CharSequence> adapterspcoor = new ArrayAdapter(AdminAsignarMaterias.this, android.R.layout.simple_spinner_item, lscoordinador);
        spinercoordinador.setAdapter(adapterspcoor);

    spinermaterias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            datospinermateria =adapterView.getSelectedItem().toString();
            Toast.makeText(AdminAsignarMaterias.this,"selecciono: "+datospinermateria,Toast.LENGTH_SHORT).show();


        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });

    spinercoordinador.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            datospinerdocente = adapterView.getSelectedItem().toString();
            Toast.makeText(AdminAsignarMaterias.this,"selecciono al coordinador "+datospinerdocente,Toast.LENGTH_SHORT).show();

        }


        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });

        botonguardaradmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent siguientepantalla = new Intent(AdminAsignarMaterias.this, DocenteEvaluacion.class);        NO QUIERO OTRA PANTALLA SOLO QUE GUARDE
                //startActivity(siguientepantalla);
                Toast.makeText(AdminAsignarMaterias.this,"guardado",Toast.LENGTH_LONG).show(); // pero tiene halar los datos del spinner VIDEO PATY WA


            }
        });


    }




    private void consultarListaMaterias(){ //para la base serviria


    }











}