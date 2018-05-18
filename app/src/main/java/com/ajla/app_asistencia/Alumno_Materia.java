package com.ajla.app_asistencia;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class Alumno_Materia extends AppCompatActivity {

    ArrayList<String> itemseleccionados=new ArrayList<>();
    Button btn_guarda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno__materia);


        ListView chl = (ListView) findViewById(R.id.check_ls);
        btn_guarda=findViewById(R.id.btn_guardar_materiaAlum);

        chl.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] item = {"Alejandra Campos", "Andres MC", "Nathaly MC", "Eliana RM", "Nehemias M"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.txt_lan, item);
        chl.setAdapter(adapter);
        chl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicion, long id) {
                String itemsseleccionados = ((TextView) view).getText().toString();
                if (itemseleccionados.contains(itemseleccionados)) {
                    itemseleccionados.remove(itemseleccionados);
                } else itemseleccionados.add(itemsseleccionados);

            }
        });

        btn_guarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Alumno_Materia.this,Alumno_Inscripcion.class);
                startActivity(intent);
            }
        });



    }



}
