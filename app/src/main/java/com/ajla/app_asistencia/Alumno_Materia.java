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
    ArrayList<Materia> listadoMate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno__materia);


        ListView chl = findViewById(R.id.check_ls);
        btn_guarda=findViewById(R.id.btn_guardar_materiaAlum);
        conect=new ConexionSQLiteHelper(getApplication());


        chl.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        consultarlistamaterias();

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

        Materia materiaO;

        String sql ="Select * from materia";

        Cursor cursor =db.rawQuery(sql,null);
        cursor.moveToFirst();
        listadoMate = new ArrayList<Materia>();
        while (cursor.moveToNext()) {
            materiaO = new Materia();
            materiaO.setNom_materia(cursor.getString(2));
            listadoMate.add(materiaO);
        }
        obtenerlista();

    }

    private void obtenerlista() {

        lmateinfo=new ArrayList<>();

        for(int i=0; i<listadoMate.size();i++)
        {

            String nom = listadoMate.get(i).getNom_materia();
            lmateinfo.add(nom);

        }
    }






}
