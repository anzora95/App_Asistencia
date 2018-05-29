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

import com.ajla.app_asistencia.Entidades.Materia;

import java.util.ArrayList;
import java.util.List;

public class DocenteMenu extends AppCompatActivity{
    ListView listamaterias,listmatelabs;
    ConexionSQLiteHelper conn;
    String puente;

    ArrayList<String> lmateriasinfo,lmateriasinfolab;
    ArrayList<Materia> listaMaterias,listaMlabs;

    String codigoisss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

  Bundle listav = getIntent().getExtras();
        codigoisss = listav.getString("nombre");


        setContentView(R.layout.activity_docente_menu);
        conn = new ConexionSQLiteHelper(getApplicationContext());


        listamaterias = (ListView) findViewById(R.id.listamaterias);
        consultarlistamaterias();

        listmatelabs= (ListView) findViewById(R.id.listalabsdoce);
        consultarlistamateriaslabs();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lmateriasinfo);
        listamaterias.setAdapter(adapter);
        listamaterias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                puente =listaMaterias.get(i).getCod_materia();
                String valor= puente;
                Intent nuevoformulario= new Intent(DocenteMenu.this,DocenteMateria.class);
                nuevoformulario.putExtra("codmateria",valor);
                startActivity(nuevoformulario);
                }
                });

        ArrayAdapter<String> adapters = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lmateriasinfolab);
        listmatelabs.setAdapter(adapters);
        listmatelabs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                puente =listaMlabs.get(i).getCod_materia();
                String valor= puente;
                Intent nuevoformulario= new Intent(DocenteMenu.this,DocenteLabActivity.class);
                nuevoformulario.putExtra("codmaterialabsdoce",valor);
                startActivity(nuevoformulario);


            }
        });


    }

    private void consultarlistamateriaslabs() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Materia materia =null; //paty no null
        listaMlabs = new ArrayList<Materia>();




        String sql="SELECT DISTINCT materia.cod_materia FROM materia INNER JOIN oferta_materia ON materia.cod_materia=oferta_materia.cod_materia INNER JOIN oferta_lab ON oferta_materia.cod_ofer_mate=oferta_lab.cod_ofer_mate where  oferta_lab.isss='"+codigoisss+"'";
        Cursor cursor=db.rawQuery(sql,null);

        while(cursor.moveToNext()){
            materia=new Materia();

            materia.setCod_materia(cursor.getString(0));  // haciendo la union manual de las tablas en base a una guia de hdp115 en esas posiciones quedan cod y nombre
            listaMlabs.add(materia);

        }
        obtenerListalabs();
    }

    private void obtenerListalabs() {
        lmateriasinfolab = new ArrayList<String>();

        for (int i = 0; i < listaMlabs.size(); i++) {
            lmateriasinfolab.add(listaMlabs.get(i).getCod_materia() + "   " );
        }

    }

    private void consultarlistamaterias() {

        SQLiteDatabase db=conn.getReadableDatabase();

        Materia materia=null; //paty no null
        listaMaterias = new ArrayList<Materia>();


        String sql="SELECT DISTINCT materia.cod_materia FROM materia INNER JOIN oferta_materia ON materia.cod_materia=oferta_materia.cod_materia INNER JOIN oferta_teo ON oferta_materia.cod_ofer_mate=oferta_teo.cod_ofer_mate  where  oferta_teo.isss='"+codigoisss+"'";
        Cursor cursor=db.rawQuery(sql,null);

        while(cursor.moveToNext()){
            materia=new Materia();

            materia.setCod_materia(cursor.getString(0));  // haciendo la union manual de las tablas en base a una guia de hdp115 en esas posiciones quedan cod y nombre
            listaMaterias.add(materia);

        }
        obtenerLista();
    }

    private void obtenerLista() {
        lmateriasinfo = new ArrayList<String>();

        for (int i = 0; i < listaMaterias.size(); i++) {
            lmateriasinfo.add(listaMaterias.get(i).getCod_materia() + "   " );
        }

    }

}