package com.ajla.app_asistencia;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.ajla.app_asistencia.Entidades.Listagrupos;
import com.ajla.app_asistencia.Entidades.Materia;
import com.ajla.app_asistencia.Entidades.Oferta_Lab;
import com.ajla.app_asistencia.Entidades.Oferta_Materia;
import com.ajla.app_asistencia.Entidades.Oferta_Teo;

import java.util.ArrayList;

public class Admin_ListadoOfertas extends AppCompatActivity {
    ConexionSQLiteHelper conec;
    String codferta;
    ListView listViewmate,listViewgt;
    ArrayList<String> lmateinfo;
    ArrayList<String> lmateinfogt;
    ArrayList<Listagrupos> listalabo;
    ArrayList<Listagrupos> listateo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__listado_ofertas);

        ActionBar action=getSupportActionBar();
        action.setDisplayHomeAsUpEnabled(true);



        conec = new ConexionSQLiteHelper(this);

        Bundle listav = getIntent().getExtras();
        codferta = listav.getString("codoferta");

        listViewmate = (ListView) findViewById(R.id.listOfertasGL);
        consultarlistaofertas();

        listViewgt = (ListView) findViewById(R.id.listOfertasGT);
        consultarlistaofertasG();

        ArrayAdapter adaptado= new ArrayAdapter(this,android.R.layout.simple_list_item_1,lmateinfo);
        listViewmate.setAdapter(adaptado);

        ArrayAdapter adaptado2= new ArrayAdapter(this,android.R.layout.simple_list_item_1,lmateinfogt);
        listViewgt.setAdapter(adaptado2);



    }

    private void consultarlistaofertasG() {
        SQLiteDatabase db = conec.getReadableDatabase();

        Listagrupos materiaO;

        String sql ="Select oferta_teo.num_grup_teo, docente.nom_doce, oferta_teo.cod_lugar from oferta_teo inner join docente on oferta_teo.isss=docente.isss where oferta_teo.cod_ofer_mate == "+codferta+"";

        Cursor cursor =db.rawQuery(sql,null);
        listateo = new ArrayList<Listagrupos>();
        while (cursor.moveToNext()) {
            materiaO = new Listagrupos();
            materiaO.setGrupo(cursor.getString(0));
            materiaO.setDocente(cursor.getString(1));
            materiaO.setSalon(cursor.getString(2));
            listateo.add(materiaO);
        }
        obtenerlistaT();
    }

    private void obtenerlistaT() {
        lmateinfogt=new ArrayList<String>();

        for(int i=0; i<listateo.size();i++)
        {
            lmateinfogt.add(listateo.get(i).getGrupo() +"   "+listateo.get(i).getDocente()+" "+listateo.get(i).getSalon());
        }

    }

    private void consultarlistaofertas() {
        SQLiteDatabase db = conec.getReadableDatabase();

        Listagrupos materiaO;

        String sql ="Select oferta_lab.num_grup_lab, docente.nom_doce, oferta_lab.cod_lugar from oferta_lab inner join docente on oferta_lab.isss=docente.isss where oferta_lab.cod_ofer_mate == "+codferta+"";

        Cursor cursor =db.rawQuery(sql,null);
        listalabo = new ArrayList<Listagrupos>();
        while (cursor.moveToNext()) {
            materiaO = new Listagrupos();
            materiaO.setGrupo(cursor.getString(0));
            materiaO.setDocente(cursor.getString(1));
            materiaO.setSalon(cursor.getString(2));

            listalabo.add(materiaO);
        }
        obtenerlista();
    }
    private void obtenerlista() {

        lmateinfo=new ArrayList<String>();

        for(int i=0; i<listalabo.size();i++)
        {
            lmateinfo.add(listalabo.get(i).getGrupo() +"   "+listalabo.get(i).getDocente()+" "+listalabo.get(i).getSalon());
        }
    }

    public void nuevOferrta(View view) {
        Intent intn= new Intent(Admin_ListadoOfertas.this,Admin_AntesGTGL.class);
        intn.putExtra("codioferta",codferta);
        startActivity(intn);

    }
}
