package com.ajla.app_asistencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class jefeMenu extends AppCompatActivity implements ListView.OnItemClickListener {
    private ListView listam;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jefe_menu);
        texto=(TextView)findViewById(R.id.textView);

        listam=(ListView) findViewById(R.id.llistm);
//dastos de la lista
        List<String> materias = new ArrayList<String>();
        materias.add("Matematicas 1");
        materias.add("psicologia Social");
        materias.add("introduccion a la informatica");
        materias.add("Fisica 1");
        materias.add("metodos experiementales");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,materias);
        listam.setOnItemClickListener(this);
        listam.setAdapter(adapter);

        }



        public void onItemClick(AdapterView<?> parent, View view, int position, long id ){
        String valor= (String) parent.getItemAtPosition(position);
        Intent nuevoformulario= new Intent(jefeMenu.this,jefeListDiferidos.class);
        nuevoformulario.putExtra("Materias",valor);
        startActivity(nuevoformulario);


        }
}
