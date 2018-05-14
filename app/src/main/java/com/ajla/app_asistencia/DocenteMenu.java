package com.ajla.app_asistencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DocenteMenu extends AppCompatActivity implements ListView.OnItemClickListener {
    private ListView listamaterias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_menu);
        listamaterias = (ListView) findViewById(R.id.listamaterias);
        List<String> materias = new ArrayList<String>();
        materias.add("Matematicas 1");
        materias.add("psicologia Social");
        materias.add("introduccion a la informatica");
        materias.add("Fisica 1");
        materias.add("metodos experiementales");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, materias);
        listamaterias.setOnItemClickListener(this);
        listamaterias.setAdapter(adapter);


    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String valor = (String) parent.getItemAtPosition(position);
        Intent nuevoformulario = new Intent(DocenteMenu.this, DocenteMateria.class);
        nuevoformulario.putExtra("Materias", valor);
        startActivity(nuevoformulario);

    }
}