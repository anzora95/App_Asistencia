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
import android.widget.Toast;

import com.ajla.app_asistencia.Entidades.Materia;

import java.util.ArrayList;
import java.util.List;

import static com.ajla.app_asistencia.ConexionSQLiteHelper.DatosTabla.CAMPO_COD_AREA_MATE;

public class jefeMenu extends AppCompatActivity implements ListView.OnItemClickListener {
     ListView listam;
    TextView texto;
    ConexionSQLiteHelper conn;
    ArrayList<Materia> listamaterias;
    ArrayList<String> lmateriasinfo;
    String stringjose="67";
    public String jefe1="23";
    public String jefe2="45";
    public String jefe3="67";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jefe_menu);
        texto=findViewById(R.id.textView);
        listam=(ListView) findViewById(R.id.listm);
        conn= new ConexionSQLiteHelper(getApplication());
        consultarlistamaterias();

        switch (stringjose){

            case "23":
                consultarlistamaterias();
                break;

            case "45":
                consultarlistamaterias45();
                break;

            case "67":
                consultarlistamaterias67();
             break;
             default:
                 Toast.makeText(this,"no esta registrado como jefe",Toast.LENGTH_SHORT).show();

        }



//datos de la lista


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lmateriasinfo);
        listam.setOnItemClickListener(this);
        listam.setAdapter(adapter);

        }




    private void consultarlistamaterias() {

        SQLiteDatabase db=conn.getReadableDatabase();

        Materia materia=null;
        listamaterias = new ArrayList<Materia>();
        //Cursor cursor=db.rawQuery("SELECT * FROM "+ConexionSQLiteHelper.DatosTabla.TABLA_MATERIA,null);
        Cursor prueba=db.rawQuery("SELECT * FROM materia where cod_area=23",null);

        while(prueba.moveToNext()){
                materia= new Materia(null,null);
                materia.setCod_materia(prueba.getString(0));
                materia.setNom_materia(prueba.getString(2));


            listamaterias.add(materia);

        }
        obtenerlista();

    }

//pa jefe 2
    private void consultarlistamaterias45() {

        SQLiteDatabase db=conn.getReadableDatabase();

        Materia materia=null;
        listamaterias = new ArrayList<Materia>();
        //Cursor cursor=db.rawQuery("SELECT * FROM "+ConexionSQLiteHelper.DatosTabla.TABLA_MATERIA,null);
        Cursor prueba=db.rawQuery("SELECT * FROM materia where cod_area=45",null);

        while(prueba.moveToNext()){
            materia= new Materia(null,null);
            materia.setCod_materia(prueba.getString(0));
            materia.setNom_materia(prueba.getString(2));


            listamaterias.add(materia);

        }
        obtenerlista();

    }

    //pal jefe 3
    private void consultarlistamaterias67() {

        SQLiteDatabase db=conn.getReadableDatabase();

        Materia materia=null;
        listamaterias = new ArrayList<Materia>();
        //Cursor cursor=db.rawQuery("SELECT * FROM "+ConexionSQLiteHelper.DatosTabla.TABLA_MATERIA,null);
        Cursor prueba=db.rawQuery("SELECT * FROM materia where cod_area=67",null);

        while(prueba.moveToNext()){
            materia= new Materia(null,null);
            materia.setCod_materia(prueba.getString(0));
            materia.setNom_materia(prueba.getString(2));


            listamaterias.add(materia);

        }
        obtenerlista();

    }


    private void obtenerlista() {

        lmateriasinfo=new ArrayList<String>();

        for(int i=0; i<listamaterias.size();i++)
        {
            lmateriasinfo.add(listamaterias.get(i).getCod_materia()+"   "+listamaterias.get(i).getNom_materia());
        }
    }




    public void onItemClick(AdapterView<?> parent, View view, int position, long id ){
        String valor= (String) parent.getItemAtPosition(position);
        Intent nuevoformulario= new Intent(jefeMenu.this,jefeListDiferidos.class);
        nuevoformulario.putExtra("Materias",valor);
        startActivity(nuevoformulario);


        }
}
