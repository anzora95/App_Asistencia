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

import com.ajla.app_asistencia.Entidades.Materia;

import java.util.ArrayList;
import java.util.List;

public class jefeMenu extends AppCompatActivity implements ListView.OnItemClickListener {
    private ListView listam;
    TextView texto;
    ConexionSQLiteHelper conn;
    ArrayList<Materia> listamaterias;
    ArrayList<String> lmateriasinfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jefe_menu);
        texto=findViewById(R.id.textView);
        listam=(ListView) findViewById(R.id.listm);
        conn= new ConexionSQLiteHelper(getApplication());
        consultarlistamaterias();



//datos de la lista


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lmateriasinfo);
        listam.setOnItemClickListener(this);
        listam.setAdapter(adapter);

        }



    private void consultarlistamaterias() {

        SQLiteDatabase db=conn.getReadableDatabase();
//String[] parametro={campoId.getText().toString()};        PODRIA USARLO PARA COMPARAR

        Materia materia=null;
        listamaterias = new ArrayList<Materia>();
        //String consulta="SELECT * FROM \"+ConexionSQLiteHelper.DatosTabla.TABLA_MATERIA,null";

        Cursor cursor=db.rawQuery("SELECT * FROM "+ConexionSQLiteHelper.DatosTabla.TABLA_MATERIA,null);
        //Cursor prueba=db.query(ConexionSQLiteHelper.)

        while(cursor.moveToNext()){
            materia= new Materia(null,null);
            materia.setCod_materia(cursor.getString(0));
            materia.setNom_materia(cursor.getString(2));


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
