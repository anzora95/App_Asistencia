package com.ajla.app_asistencia;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ajla.app_asistencia.Entidades.Materia;
import com.ajla.app_asistencia.Entidades.Solicitud_Diferido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class jefeListDiferidos extends AppCompatActivity {
    ListView listadif;
    ConexionSQLiteHelper conec;
    ArrayList<String> liDife;
    ArrayList<Solicitud_Diferido> listadoDife;
    String cod_oferta, codigo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jefe_list_diferidos);

        ActionBar action=getSupportActionBar();
        action.setDisplayHomeAsUpEnabled(true);

        listadif = (ListView) findViewById(R.id.listadif);
        conec = new ConexionSQLiteHelper(getApplicationContext());

        Bundle listav = getIntent().getExtras();
        codigo = listav.getString("jefecodmate");

        consultarlistadiferidos();

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, liDife);
        listadif.setAdapter(adaptador); //Adaptador
        listadif.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cod_oferta= listadoDife.get(position).getId_solicitud().toString();

                Intent oferta = new Intent(jefeListDiferidos.this, jefeDiferido.class);
                oferta.putExtra("jefecoddife",cod_oferta);
                startActivity(oferta);


            }
        });

    }

    private void consultarlistadiferidos() {
        SQLiteDatabase db = conec.getReadableDatabase();

        Solicitud_Diferido materiaO;
///aqui modificar
        String sql ="Select * from solicitud_diferido inner join asis_exam on solicitud_diferido.fecha_exam= asis_exam.fecha_exam inner join oferta_materia on asis_exam.cod_ofer_mate=oferta_materia.cod_ofer_mate where solicitud_diferido.isss='456789908' and oferta_materia.cod_materia=='"+codigo+"' and solicitud_diferido.estado== 0 ";
        Cursor cursor =db.rawQuery(sql,null);
        listadoDife = new ArrayList<Solicitud_Diferido>();
        while (cursor.moveToNext()) {
            materiaO = new Solicitud_Diferido();
            materiaO.setId_solicitud(cursor.getInt(0));
            materiaO.setCarnet(cursor.getString(1));
            materiaO.setIsss(cursor.getString(2));


            listadoDife.add(materiaO);
        }
        obtenerlista();
    }

    private void obtenerlista() {
        liDife=new ArrayList<String>();

        for(int i=0; i<listadoDife.size();i++)
        {
            liDife.add(listadoDife.get(i).getId_solicitud()+"   "+listadoDife.get(i).getCarnet());
        }
    }
}