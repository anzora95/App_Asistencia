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


import com.ajla.app_asistencia.Entidades.Docente;
import com.ajla.app_asistencia.Entidades.Materia;
import com.ajla.app_asistencia.Entidades.Oferta_Materia;

import java.util.ArrayList;
import java.util.List;

public class DocenteMenu extends AppCompatActivity implements ListView.OnItemClickListener {
    ListView listamaterias;
    ConexionSQLiteHelper conn;

    ArrayList<String> lmateriasinfo;
    ArrayList<Materia> listaMaterias;
    ArrayList<Docente> ls_docente;


    String isss = "456789908";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_menu);
        conn = new ConexionSQLiteHelper(getApplicationContext());

        listamaterias = (ListView) findViewById(R.id.listamaterias);


        consultarlistamaterias();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lmateriasinfo);
        listamaterias.setOnItemClickListener(this);
        listamaterias.setAdapter(adapter);


    }
/*

    private void  consultarlistamaterias(String isss){
        SQLiteDatabase db=conn.getReadableDatabase();

        Materia materia=null;
        listaMaterias = new ArrayList<Materia>();
        //Cursor cursor=db.rawQuery("SELECT * FROM "+ConexionSQLiteHelper.DatosTabla.TABLA_MATERIA,null);
        Cursor prueba=db.rawQuery("SELECT codmateria,nom_materia FROM oferta_materia  ",null);

        while(prueba.moveToNext()){
            materia= new Materia(null,null);
            materia.setCod_materia(prueba.getString(1));
            materia.setNom_materia(prueba.getString(2));


            listaMaterias.add(materia);

        }
        obtenerlista();

    }

    private void obtenerlista() {
        lmateriasinfo=new ArrayList<String>();

        for(int i=0; i<listaMaterias.size();i++)
        {
            lmateriasinfo.add(listaMaterias.get(i).getCod_materia()+"   "+listaMaterias.get(i).getNom_materia());
        }
    }
    "SELECT * FROM m.oferta_materia INNER JOIN t.oferta_teo ON m.cod_ofer_mate=t.cod_ofer_mate INNER JOIN l.oferta_lan ON m.isss=l.isss INNER JOIN c.ciclo ON c.ciclo_anio=m.ciclo_anio INNER JOIN d.docente ON m.isss=d.iddd where c.estado=='1' and d.isss=='datotraido'
*/
//----------------------------------------------------------------------   poner eso XD


    private void consultarlistamaterias() {
        SQLiteDatabase base = conn.getReadableDatabase();


        Oferta_Materia ofertaMateria = null;
        Materia materia=null;
        List<Oferta_Materia> listaMaterias = new ArrayList<Oferta_Materia>();
        //Cursor cursor = base.rawQuery("SELECT *FROM m.oferta_materia INNER JOIN t.oferta_teo ON m.cod_ofer_mate=t.cod_ofer_mate INNER JOIN l.oferta_lab ON m.isss=l.isss INNER JOIN c.ciclo ON c.ciclo_anio=m.ciclo_anio INNER JOIN d.docente ON m.isss=d.isss where c.estado=='1' and d.isss =='datotraido'"), null);
        Cursor cursor2=base.rawQuery("SELECT * FROM materia",null);

        //while (cursor.moveToNext()&&cursor2.moveToNext()) {

            ofertaMateria = new Oferta_Materia(null, null, null, null);
            materia= new Materia(null,null);

            //ofertaMateria.setCod_materia(cursor.getString(1));
            //ofertaMateria.setIsss(cursor.getString(2));
            ofertaMateria.getIsss().equals(isss);
            materia.setCod_materia(cursor2.getString(1));//halo cod:materia y isss y despues cod materia


            listaMaterias.add(ofertaMateria);

        } //obtenerLista();

        /*for (Oferta_Materia stud : listaMaterias) {

            if (stud.getIsss().equals(isss)) {
                Materia materia = null;
                List<Materia> ls_materia = new ArrayList<Materia>();
                Cursor cursormaterias = base.rawQuery("SELECT * FROM materias", null);

                while (cursormaterias.moveToNext()) {
                    materia = new Materia(null, null);
                    materia.setCod_materia(cursormaterias.getString(0));
                    materia.setNom_materia(cursormaterias.getString(2));

                    ls_materia.add(materia);

                }*/










    private void obtenerLista() {

        lmateriasinfo = new ArrayList<String>();

        for (int i = 0; i < listaMaterias.size(); i++) {
            lmateriasinfo.add(listaMaterias.get(i).getCod_materia() + "   " + listaMaterias.get(i).getNom_materia());
        }
    }


        public void onItemClick (AdapterView < ? > parent, View view,int position, long id ){
            String valor = (String) parent.getItemAtPosition(position);
            Intent nuevoformulario = new Intent(DocenteMenu.this, DocenteMateria.class);
            nuevoformulario.putExtra("Materias", valor);
            startActivity(nuevoformulario);


        }
    }




