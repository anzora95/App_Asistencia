package com.ajla.app_asistencia;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.ajla.app_asistencia.Entidades.Materia;
import com.ajla.app_asistencia.Entidades.Oferta_Lab;
import com.ajla.app_asistencia.Entidades.Oferta_Materia;
import com.ajla.app_asistencia.Entidades.Oferta_Teo;

import java.util.ArrayList;

public class Admin_ListadoOfertas extends AppCompatActivity {
    ConexionSQLiteHelper conec;
    String datospuente, codmate,codciclo,codoferta;
    ListView listViewmate;
    ArrayList<String> lmateinfo;
    ArrayList<Oferta_Lab> listalabo;
    ArrayList<Oferta_Teo> listateo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__listado_ofertas);


        conec = new ConexionSQLiteHelper(this);

        listViewmate = (ListView) findViewById(R.id.listOfertas);


        Bundle listav = getIntent().getExtras();
        codmate = listav.getString("cod_mate");
        codciclo= listav.getString("ciclo");
        codoferta = listav.getString("cod_oferta");

        ArrayAdapter adaptado= new ArrayAdapter(this,android.R.layout.simple_list_item_1,lmateinfo);

        consultarlistaofertas();

    }

    private void consultarlistaofertas() {
        SQLiteDatabase db = conec.getReadableDatabase();

        Oferta_Lab materiaO;

        String sql ="Select * from oferta_lab inner join oferta_materia on oferta_lab.cod_ofer_mate=oferta_materia.cod_ofer_mate inner join ciclo  on oferta_materia.ciclo_anio= ciclo.ciclo_anio where ciclo.estado_ciclo=='1' and oferta_materia.cod_materia =="+codmate;

        Cursor cursor =db.rawQuery(sql,null);
        listalabo = new ArrayList<Oferta_Lab>();
        while (cursor.moveToNext()) {
            materiaO = new Oferta_Lab();
            materiaO.setId_ofer_lab(cursor.getInt(0));
            materiaO.setCod_lugar(cursor.getString(1));
            materiaO.setCod_ofert_mate(cursor.getInt(2));
            materiaO.setIsss(cursor.getString(3));
            materiaO.setNum_grup_lab(cursor.getString(4));

            listalabo.add(materiaO);
        }
        obtenerlista();
    }
    private void obtenerlista() {

        lmateinfo=new ArrayList<String>();

        for(int i=0; i<listalabo.size();i++)
        {
            lmateinfo.add(listalabo.get(i).getCod_lugar() +"   "+listalabo.get(i).getIsss()+" "+listalabo.get(i).getNum_grup_lab());
        }
    }

    public void nuevOferrta(View view) {
        Intent intn= new Intent(Admin_ListadoOfertas.this,Admin_AntesGTGL.class);
        intn.putExtra("ofercodmate", codmate);
        intn.putExtra("cicloofer",codciclo);
        intn.putExtra("codoferta",codoferta);
        startActivity(intn);

    }
}
