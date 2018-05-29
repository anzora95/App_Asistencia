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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ajla.app_asistencia.Entidades.Ciclo;
import com.ajla.app_asistencia.Entidades.Docente;
import com.ajla.app_asistencia.Entidades.Materia;

import java.util.ArrayList;

public class AdminAsignarMaterias extends AppCompatActivity {
    Button botonguardaradmin;
    String puentemateria,puentedoce, puenteciclo;
    TextView textociclo;
    Spinner spinermaterias;
    Spinner spinercoordinador;
    ArrayList lsmaterias;
    ArrayList lscoordinador;
    ArrayList<Docente> ld;
    ArrayList<Materia> lm;
    ArrayList<Ciclo> lc;
    ConexionSQLiteHelper conec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_asignar_materias);
        botonguardaradmin = (Button) findViewById(R.id.botonguardaradmin);
        spinermaterias = (Spinner) findViewById(R.id.spinermaterias);
        spinercoordinador = (Spinner) findViewById(R.id.spinercoordinador);

        conec= new ConexionSQLiteHelper(getApplicationContext());

        consultarlistadocentes();
        consultarListaMaterias();

        ArrayAdapter<String> adaptador= new ArrayAdapter(this,android.R.layout.simple_spinner_item,lscoordinador);
        spinercoordinador.setAdapter(adaptador);
        spinercoordinador.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                puentedoce = ld.get(i).getIsss();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> adaptado= new ArrayAdapter(this,android.R.layout.simple_spinner_item,lsmaterias);
        spinermaterias.setAdapter(adaptado);
        spinermaterias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                puentemateria = lm.get(i).getCod_materia();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void consultarlistadocentes() {

        SQLiteDatabase db=conec.getReadableDatabase();

        Docente docent;
        ld = new ArrayList<Docente>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ConexionSQLiteHelper.DatosTabla.TABLA_DOCENTE,null);

        while(cursor.moveToNext()){
            docent= new Docente();
            docent.setIsss(cursor.getString(0));
            docent.setNom_doce(cursor.getString(1));

            ld.add(docent);

        }
        obtenerlistadocentes();

    }

    private void obtenerlistadocentes() {
        lscoordinador =new ArrayList<String>();
        for(int i=0; i<ld.size();i++)
        {
            lscoordinador.add(ld.get(i).getNom_doce());
        }
    }


    private void consultarListaMaterias(){
        SQLiteDatabase db=conec.getReadableDatabase();

        Materia mate;
        lm = new ArrayList<Materia>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ConexionSQLiteHelper.DatosTabla.TABLA_MATERIA,null);

        while(cursor.moveToNext()){
            mate= new Materia();
            mate.setCod_materia(cursor.getString(0));
           mate.setNom_materia(cursor.getString(2));

            lm.add(mate);

        }
        obtenerlistamateria();


    }

    private void obtenerlistamateria() {
        lsmaterias =new ArrayList<String>();
        for(int i=0; i<lm.size();i++)
        {
            lsmaterias.add(lm.get(i).getNom_materia());
        }
    }


    public void agregarasig(View view) {
        Ciclo cicl;
        SQLiteDatabase db1= conec.getReadableDatabase();


        Cursor cursor =db1.rawQuery("SELECT * FROM ciclo where estado_ciclo == '1'",null);
        while (cursor.moveToNext()) {
           cicl =new Ciclo();
           cicl.setCiclo_anio(cursor.getInt(1));
           //lc.add(cicl);
            puenteciclo = cicl.getCiclo_anio().toString();

        }

        SQLiteDatabase db= conec.getWritableDatabase();




        if (db!=null){
            db.execSQL("insert into oferta_materia values (null, '"+ puentemateria+"', '"+ puentedoce+"','"+puenteciclo+"' )");
            finish();

        }
    }
}