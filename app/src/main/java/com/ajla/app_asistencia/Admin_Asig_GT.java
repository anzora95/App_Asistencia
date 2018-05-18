package com.ajla.app_asistencia;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.ajla.app_asistencia.Entidades.Docente;
import com.ajla.app_asistencia.Entidades.Lugar;

import java.util.ArrayList;

public class Admin_Asig_GT extends AppCompatActivity {
    Spinner sp_gl, sp_doce, sp_local;
    ConexionSQLiteHelper conec;
    String puentegl,puentedoce, puentelocal;
    ArrayList listadedocentes, listadelugares;
    ArrayList<Docente> ld;
    ArrayList<Lugar> ll;
    String  codmate,codciclo,codoferta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__asig__gt);
        sp_gl=(Spinner) findViewById(R.id.spinnerGT);
        sp_doce=(Spinner)findViewById(R.id.spinnerDocenteGT);
        sp_local=(Spinner) findViewById(R.id.spinnerLocalGT);

        conec= new ConexionSQLiteHelper(getApplicationContext());

        Bundle listav = getIntent().getExtras();
        codmate = listav.getString("codigodelamateria");
        codciclo= listav.getString("ciclodelaoferta");
        codoferta = listav.getString("codigodelaoferta");

        consultarlistadocentes();
        consultarlistalocales();

        ArrayAdapter<String> adaptador= new ArrayAdapter(this,android.R.layout.simple_spinner_item,listadedocentes);
        sp_doce.setAdapter(adaptador);
        sp_doce.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                puentedoce = ld.get(i).getIsss();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> adaptador2= new ArrayAdapter(this,android.R.layout.simple_spinner_item,listadelugares);
        sp_local.setAdapter(adaptador2);
        sp_local.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                puentelocal = ll.get(i).getCod_Lugar();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        ArrayAdapter<CharSequence> adaptador1= ArrayAdapter.createFromResource(this,R.array.listateodis,android.R.layout.simple_spinner_item);
        sp_gl.setAdapter(adaptador1);
        sp_gl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                puentegl= parent.getItemAtPosition(i).toString();
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
        listadedocentes =new ArrayList<String>();
        for(int i=0; i<ld.size();i++)
        {
            listadedocentes.add(ld.get(i).getNom_doce());
        }
    }

    private void consultarlistalocales() {

        Lugar lug;

        SQLiteDatabase db=conec.getReadableDatabase();
        String sql ="Select * from lugar where tipo='S'";

        Cursor cursor =db.rawQuery(sql,null);
        ll = new ArrayList<Lugar>();
        while (cursor.moveToNext()) {
            lug=new Lugar();
            lug.setCod_Lugar(cursor.getString(0));

            ll.add(lug);
        }
        obtenerlistalugares();
    }

    private void obtenerlistalugares() {
        listadelugares =new ArrayList<String>();

        for(int i=0; i<ll.size();i++)
        {
            listadelugares.add(ll.get(i).getCod_Lugar());
        }
    }

    public void onGL(View view) {







        SQLiteDatabase db= conec.getWritableDatabase();

        if (db!=null){
            ContentValues registro= new ContentValues();

            registro.put("cod_lugar",puentelocal);
            registro.put("cod_ofer_mate",codmate);
            registro.put("isss",puentedoce);
            registro.put("num_grupo_teo",puentegl);
            long i=db.insert("oferta_teo",null,registro);


            if(i>0){
                Toast.makeText(Admin_Asig_GT.this,"Guardado con exito",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onGT(View view) {
        Toast.makeText(Admin_Asig_GT.this,"Grupo Guardado con exito",Toast.LENGTH_SHORT).show();
    }
}
