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

import com.ajla.app_asistencia.Entidades.Oferta_Lab;

import java.util.ArrayList;

public class DocenteLabActivity extends AppCompatActivity {

    ListView listagl;
    TextView textogl;
    ArrayList<Oferta_Lab> grupolab;
    String valor;
    ArrayList<String> lmateinfolab;
    ConexionSQLiteHelper conec;
    String codigo;
    String issslogin = "456789908";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_lab);

        Bundle listav = getIntent().getExtras();
        codigo = listav.getString("codmaterialabsdoce");


        textogl = (TextView) findViewById(R.id.gl);

        listagl = (ListView) findViewById(R.id.listagl);

        conec = new ConexionSQLiteHelper(getApplicationContext());
        consultarlistagruposlaboratorio();


        ArrayAdapter<String> adaptergl = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, lmateinfolab);
        listagl.setAdapter(adaptergl);
        listagl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nuevoformulario = new Intent(DocenteLabActivity.this, DocenteAsistenciaGL.class);
                valor =grupolab.get(i).getId_ofer_lab().toString();
                nuevoformulario.putExtra("Mateasislab", valor);
                startActivity(nuevoformulario);
            }
        });
        }

    private void consultarlistagruposlaboratorio() {
        SQLiteDatabase db=conec.getReadableDatabase();


        Oferta_Lab oflab=null;

        grupolab= new ArrayList<Oferta_Lab>();
        String sql="SELECT * FROM oferta_lab INNER JOIN oferta_materia ON oferta_lab.cod_ofer_mate=oferta_materia.cod_ofer_mate where oferta_materia.cod_materia='"+codigo+"' and oferta_lab.isss='"+ issslogin+"'";
        Cursor cursor=db.rawQuery(sql,null);
        //Cursor cursor=db.rawQuery("SELECT * FROM ot.ofertateo INNER JOIN om.ofertaMateria ON ot.cod_ofer_mate=om.cod_ofer_mate INNER JOIN d.docente ON ot.isss=om.isss ",null);

        while(cursor.moveToNext()){
            oflab= new Oferta_Lab();
            oflab.setId_ofer_lab(cursor.getInt(0));
            oflab.setCod_lugar(cursor.getString(1));
            oflab.setNum_grup_lab(cursor.getString(4));


            grupolab.add(oflab);

        }
        obtenerlistalab();

    }

    private void obtenerlistalab() {

        lmateinfolab=new ArrayList<String>();

        for(int i=0; i<grupolab.size();i++)
        {
            lmateinfolab.add(grupolab.get(i).getNum_grup_lab()+"   "+grupolab.get(i).getCod_lugar());
        }
    }
}
