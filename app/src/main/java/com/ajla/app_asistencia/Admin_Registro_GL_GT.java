package com.ajla.app_asistencia;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import com.ajla.app_asistencia.Entidades.ListaOfertas;
import com.ajla.app_asistencia.Entidades.Listagrupos;
import com.ajla.app_asistencia.Entidades.Materia;
import com.ajla.app_asistencia.Entidades.Oferta_Materia;

import java.util.ArrayList;

//Onda del video que me dio error
public class Admin_Registro_GL_GT extends AppCompatActivity {

    ListView listMaterias_View; //Declaracion de variables.
    ConexionSQLiteHelper conec;
    ArrayList<String> liMate;
    ArrayList<ListaOfertas> listadoMate;
    String cod_oferta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__registro__gl__gt);

        conec = new ConexionSQLiteHelper(getApplicationContext()); //Conexion a la BD
        listMaterias_View = (ListView) findViewById(R.id.listMateriasCiclo);

        consultarlistamaterias();

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, liMate);
        listMaterias_View.setAdapter(adaptador); //Adaptador
        listMaterias_View.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cod_oferta= listadoMate.get(position).getCodmateria().toString();

                Intent oferta = new Intent(Admin_Registro_GL_GT.this, Admin_ListadoOfertas.class);
                oferta.putExtra("codoferta",cod_oferta);
                startActivity(oferta);


                }
                });


        }

        private void consultarlistamaterias() {

        SQLiteDatabase db = conec.getReadableDatabase();

        ListaOfertas materiaO;

        String sql ="Select oferta_materia.cod_ofer_mate, oferta_materia.cod_materia, docente.nom_doce from oferta_materia inner join docente on oferta_materia.isss=docente.isss inner join ciclo on oferta_materia.ciclo_anio= ciclo.ciclo_anio where ciclo.estado_ciclo=='1'";

        Cursor cursor =db.rawQuery(sql,null);
        listadoMate = new ArrayList<ListaOfertas>();
        while (cursor.moveToNext()) {
            materiaO = new ListaOfertas();
            materiaO.setCodmateria(cursor.getString(0));
            materiaO.setCodoferta(cursor.getString(1));
            materiaO.setCoordinador(cursor.getString(2));

            listadoMate.add(materiaO);
            }
            obtenerlista();

        }

        private void obtenerlista() {

        liMate=new ArrayList<String>();

        for(int i=0; i<listadoMate.size();i++)
        {
            liMate.add(listadoMate.get(i).getCodoferta()+"   "+listadoMate.get(i).getCoordinador());
            }




            }
}
