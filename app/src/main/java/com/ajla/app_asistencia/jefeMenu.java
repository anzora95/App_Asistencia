package com.ajla.app_asistencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class jefeMenu extends AppCompatActivity {
    private ListView listam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jefe_menu);

        listam=(ListView) findViewById(R.id.llistm);
//dastos de la lista
        List<String> materias = new ArrayList<String>();
        materias.add("Matematicas 1");
        materias.add("psicologia Social");
        materias.add("introduccion a la informatica");
        materias.add("Fisica 1");
        materias.add("metodos experiementales");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,materias);
        listam.setAdapter(adapter);

        }
}
