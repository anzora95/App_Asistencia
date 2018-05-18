package com.ajla.app_asistencia;



import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.ajla.app_asistencia.Entidades.Alumno;
import com.ajla.app_asistencia.Entidades.Materia;
import com.ajla.app_asistencia.Entidades.Oferta_Materia;

import java.util.ArrayList;
import java.util.List;


public class Alumno_Materia extends AppCompatActivity {

    ArrayList<String> itemseleccionados=new ArrayList<>();
    Button btn_guarda;
    ConexionSQLiteHelper conect;
    ArrayList <String> lmateinfo;
    ArrayList<Oferta_Materia> listadoMate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno__materia);


        ListView chl = (ListView) findViewById(R.id.check_ls);
        btn_guarda=findViewById(R.id.btn_guardar_materiaAlum);
        conect=new ConexionSQLiteHelper(getApplication());


        chl.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        consultarlistamaterias();
        //String[] item = {"Alejandra Campos", "Andres MC", "Nathaly MC", "Eliana RM", "Nehemias M"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.txt_lan, lmateinfo);
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

    private void consultarlistamaterias() {

        SQLiteDatabase db = conect.getReadableDatabase();

        Oferta_Materia materiaO;

        String sql ="Select * from oferta_materia inner join ciclo on oferta_materia.ciclo_anio= ciclo.ciclo_anio where ciclo.estado_ciclo=='1'";

        Cursor cursor =db.rawQuery(sql,null);
        listadoMate = new ArrayList<Oferta_Materia>();
        while (cursor.moveToNext()) {
            materiaO = new Oferta_Materia(null,null,null,null);
            materiaO.setCod_ofer_mate(cursor.getInt(0));


            listadoMate.add(materiaO);
        }
        obtenerlista();

    }

    private void obtenerlista() {



        for(int i=0; i<listadoMate.size();i++)
        {

            lmateinfo.add(listadoMate.get(i).getCod_materia().toString());

        }
    }






}
