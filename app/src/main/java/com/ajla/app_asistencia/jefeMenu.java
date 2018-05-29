package com.ajla.app_asistencia;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.ajla.app_asistencia.Entidades.Materia;

import java.util.ArrayList;


public class jefeMenu extends AppCompatActivity {

    TextView texto;
    ListView listMaterias_View; //Declaracion de variables.
    ConexionSQLiteHelper conec;
    ArrayList<String> liMate;
    ArrayList<Materia> listadoMate;
    String cod_oferta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jefe_menu);
        texto=findViewById(R.id.textView);




        conec = new ConexionSQLiteHelper(getApplicationContext()); //Conexion a la BD
        listMaterias_View = (ListView) findViewById(R.id.listm);

        consultarlistamaterias();

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, liMate);
        listMaterias_View.setAdapter(adaptador); //Adaptador
        listMaterias_View.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cod_oferta= listadoMate.get(position).getCod_materia().toString();

               Intent oferta = new Intent(jefeMenu.this, jefeListDiferidos.class);
                oferta.putExtra("jefecodmate",cod_oferta);
                startActivity(oferta);


            }
        });

        }

    private void consultarlistamaterias() {
        SQLiteDatabase db = conec.getReadableDatabase();

        Materia materiaO;
///aqui modificar
        String sql ="Select * from materia inner join area on materia.cod_area=area.cod_area inner join jefe_departamento on jefe_departamento.cod_area= area.cod_area inner join oferta_materia on materia.cod_materia = oferta_materia.cod_materia inner join ciclo on oferta_materia.ciclo_anio= ciclo.ciclo_anio where ciclo.estado_ciclo= '1' and jefe_departamento.isss=='456789908'";

        Cursor cursor =db.rawQuery(sql,null);
        listadoMate = new ArrayList<Materia>();
        while (cursor.moveToNext()) {
            materiaO = new Materia();
            materiaO.setCod_materia(cursor.getString(0));
            materiaO.setCod_area(cursor.getString(1));
            materiaO.setNom_materia(cursor.getString(2));

            listadoMate.add(materiaO);
        }
        obtenerlista();
    }

    private void obtenerlista() {
        liMate=new ArrayList<String>();

        for(int i=0; i<listadoMate.size();i++)
        {
            liMate.add(listadoMate.get(i).getCod_materia()+"   "+listadoMate.get(i).getNom_materia());
        }
    }
}
