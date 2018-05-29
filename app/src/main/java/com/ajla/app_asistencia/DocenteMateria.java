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

    String issslogin = "456789908";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_materia);




        Bundle listav = getIntent().getExtras();
        codigo = listav.getString("codmateria");

        textogt = (TextView) findViewById(R.id.gt);

        listagt = (ListView) findViewById(R.id.listagt);


        textoeva = (TextView) findViewById(R.id.eva);

        listaeva = (ListView) findViewById(R.id.listaeva);

        botonasignar = (Button) findViewById(R.id.botonasignar);

        conec = new ConexionSQLiteHelper(getApplicationContext());


        consultarlistagruposteoricos();

        ArrayAdapter<String> adaptergt = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, lmateinfoteo);

       //ArrayAdapter<String> adaptereva = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, valoreseva);
        listagt.setAdapter(adaptergt);
        listagt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nuevoformulario = new Intent(DocenteMateria.this, DocenteAsistenciaGT.class);
                valor =grupoteorico.get(i).getId_ofer_teo();
                nuevoformulario.putExtra("Mate", valor);
                startActivity(nuevoformulario);
            }
        });






        //listaeva.setAdapter(adaptereva);
        listaeva.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nuevoformulario = new Intent(DocenteMateria.this, DocenteAsistenciaEVA.class);
                //NUEVO INTENT PARA QUE ME LLEVE A PANTALLAS DE GT, GL Y EVA

                //nuevoformulario.putExtra("Materias", valor);
                startActivity(nuevoformulario);
            }
        });





        //para que el boton lo lleve a otra pantalla
        botonasignar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(docente==coordinador) {
                    Intent siguientepantalla = new Intent(DocenteMateria.this, DocenteEvaluacion.class);
                    startActivity(siguientepantalla);
                }
                else{
                    Toast.makeText(DocenteMateria.this,"no es coordinador",Toast.LENGTH_LONG).show();
                }

            }
        }   );
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


