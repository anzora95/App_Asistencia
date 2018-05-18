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

import com.ajla.app_asistencia.Entidades.Materia;
import com.ajla.app_asistencia.Entidades.Oferta_Materia;

import java.util.ArrayList;

//Onda del video que me dio error
public class Admin_Registro_GL_GT extends AppCompatActivity {

                                                               ListView listMaterias_View; //Declaracion de variables.
                                                               ConexionSQLiteHelper conec;
                                                               ArrayList<String> liMate;
                                                               ArrayList<Oferta_Materia> listadoMate;
    String cod_mate,ciclo;
    Integer cod_oferta;


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
                                                                           cod_oferta= listadoMate.get(position).getCod_ofer_mate();
                                                                           cod_mate =listadoMate.get(position).getCod_materia();
                                                                           ciclo=listadoMate.get(position).getCiclo_anio();



                                                                           Intent listaMatOf = new Intent(Admin_Registro_GL_GT.this, Admin_ListadoOfertas.class);
 //Onda del video
                                                                           listaMatOf.putExtra("ofercodmate",cod_mate);
                                                                           listaMatOf.putExtra("cicloofer",ciclo);
                                                                           listaMatOf.putExtra("codoferta",cod_oferta);

                                                                           startActivity(listaMatOf);
                                                                       }
                                                                   }); //Onda del video


                                                               }

                                                               private void consultarlistamaterias() {

                                                                   SQLiteDatabase db = conec.getReadableDatabase();

                                                                   Oferta_Materia materiaO;

                                                                   String sql ="Select * from oferta_materia inner join ciclo on oferta_materia.ciclo_anio= ciclo.ciclo_anio where ciclo.estado_ciclo=='1'";

                                                                   Cursor cursor =db.rawQuery(sql,null);
                                                                   listadoMate = new ArrayList<Oferta_Materia>();
                                                                   while (cursor.moveToNext()) {
                                                                       materiaO = new Oferta_Materia();
                                                                       materiaO.setCod_ofer_mate(cursor.getInt(0));
                                                                       materiaO.setCod_materia(cursor.getString(1));
                                                                       materiaO.setIsss(cursor.getString(2));
                                                                       materiaO.setCiclo_anio(cursor.getString(3));

                                                                       listadoMate.add(materiaO);
                                                                   }
                                                                   obtenerlista();

                                                               }

                                                               private void obtenerlista() {

                                                                   liMate=new ArrayList<String>();

                                                                   for(int i=0; i<listadoMate.size();i++)
                                                                   {
                                                                       liMate.add(listadoMate.get(i).getCod_materia()+"   "+listadoMate.get(i).getIsss());
                                                                   }




                                                               }
}
