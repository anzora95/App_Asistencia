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
import android.widget.Toast;

import com.ajla.app_asistencia.Entidades.Control_Exam;
import com.ajla.app_asistencia.Entidades.Oferta_Lab;
import com.ajla.app_asistencia.Entidades.Oferta_Teo;

import java.util.ArrayList;

public class DocenteMateria extends AppCompatActivity {
    ListView listagt;//para instanciar la lista y mostrarlo pero como ,lista nada mas
    TextView textogt;
    ArrayList<Oferta_Teo> grupoteorico;



    ListView listaeva;
    TextView textoeva;
    ArrayList<Control_Exam> grupoeva;

    String coordinador,codigo;
    String docente= coordinador;
    Button botonasignar;
    Integer valor;

    ConexionSQLiteHelper conec;
    ArrayList<String> lmateinfoteo;
    ArrayList<String> lmateinfolab;

    String issslogin ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_materia);


        Bundle listav = getIntent().getExtras();
        codigo = listav.getString("codmateria");
        issslogin=listav.getString("otronombre");

        textogt = (TextView) findViewById(R.id.gt);

        listagt = (ListView) findViewById(R.id.listagt);


        botonasignar = (Button) findViewById(R.id.botonasignar);

        conec = new ConexionSQLiteHelper(getApplicationContext());


        consultarlistagruposteoricos();

        ArrayAdapter<String> adaptergt = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, lmateinfoteo);


        listagt.setAdapter(adaptergt);
        listagt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nuevoformulario = new Intent(DocenteMateria.this, DocenteAsistenciaGT.class);
                valor =grupoteorico.get(i).getId_ofer_teo();
                nuevoformulario.putExtra("Mate5", valor);
                startActivity(nuevoformulario);
            }
        });

    }

    private void consultarlistagruposteoricos() {

        SQLiteDatabase db=conec.getReadableDatabase();


        Oferta_Teo ofteo=null;

        grupoteorico= new ArrayList<Oferta_Teo>();
        String sql="SELECT * FROM oferta_teo INNER JOIN oferta_materia ON oferta_teo.cod_ofer_mate=oferta_materia.cod_ofer_mate where oferta_materia.cod_materia='"+codigo+"' and oferta_teo.isss='"+ issslogin+"'";
        Cursor cursor =db.rawQuery(sql,null);

        while(cursor.moveToNext()){
            ofteo= new Oferta_Teo();
            ofteo.setId_ofer_teo(cursor.getInt(0));
            ofteo.setCod_lugar(cursor.getString(1));
            ofteo.setNum_grup_teo(cursor.getString(4));


            grupoteorico.add(ofteo);

        }
        obtenerlistateo();

    }

    private void obtenerlistateo() {

        lmateinfoteo=new ArrayList<String>();

        for(int i=0; i<grupoteorico.size();i++)
        {
            lmateinfoteo.add(grupoteorico.get(i).getNum_grup_teo() + "   "+grupoteorico.get(i).getCod_lugar() +  "   "+grupoteorico.get(i).getId_ofer_teo());
        }
    }









}


