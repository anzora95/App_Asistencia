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

public class jefeListDiferidos extends AppCompatActivity implements ListView.OnItemClickListener {
    private ListView listadif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jefe_list_diferidos);

        listadif = (ListView) findViewById(R.id.listadif);
//dastos de la lista
        List<String> diferidos = new ArrayList<String>();
        diferidos.add("dif 1");
        diferidos.add("dif 2");
        diferidos.add("dif 3");
        diferidos.add("dif 4");
        diferidos.add("dif 5");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, diferidos);
        listadif.setOnItemClickListener(this);
        listadif.setAdapter(adapter);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String valor = (String) parent.getItemAtPosition(position);
        Intent nuevoformulario = new Intent(jefeListDiferidos.this, jefeDiferido.class);
        nuevoformulario.putExtra("Diferidos", valor);
        startActivity(nuevoformulario);
    }
}