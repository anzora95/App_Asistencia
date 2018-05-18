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
import android.widget.Toast;

import com.ajla.app_asistencia.Entidades.Solicitud_Diferido;

import java.util.ArrayList;
import java.util.List;

public class jefeListDiferidos extends AppCompatActivity implements ListView.OnItemClickListener {
    private ListView listadif;
    ConexionSQLiteHelper conn;
    ArrayList<Solicitud_Diferido> solicitud;
    //ArrayList<Materia> listdiferidos;
    ArrayList diferidos;
    String materiadif = "908756789";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jefe_list_diferidos);

        listadif = (ListView) findViewById(R.id.listadif);
        conn = new ConexionSQLiteHelper(getApplicationContext());
        consultardiferidos();

//dastos de la lista

       /* List<String> diferidos = new ArrayList<String>();
        diferidos.add("dif 1");
        diferidos.add("dif 2");
        diferidos.add("dif 3");
        diferidos.add("dif 4");
        diferidos.add("dif 5");*/


        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, diferidos);
        listadif.setOnItemClickListener(this);
        // listadif.setAdapter(adapter);
    }

    private void consultardiferidos() {
        SQLiteDatabase db = conn.getReadableDatabase();

        Solicitud_Diferido solicitudn = null;
        solicitud = new ArrayList<Solicitud_Diferido>();
        Cursor cursor = db.rawQuery("SELECT * FROM solicitud_diferido", null);

        while (cursor.moveToNext()) {
            solicitudn = new Solicitud_Diferido(null, null, null, null, null, null);
            solicitudn.setIsss(cursor.getString(0));
            solicitudn.setIsss(cursor.getString(1));
            solicitudn.setIsss(cursor.getString(2));

            //if(materiadif.compareToIgnoreCase(solicitudn.getIsss())==1){
            //  Toast.makeText(this,"es igual",Toast.LENGTH_SHORT).show();




        solicitud.add(solicitudn);


    }

    obtenerlista();

}


    private void obtenerlista() {
        diferidos=new ArrayList<String>();

        for(int i=0; i<solicitud.size();i++)
        {
           diferidos.add(solicitud.get(i).getIsss()+"h");
        }
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String valor = (String) parent.getItemAtPosition(position);
        Intent nuevoformulario = new Intent(jefeListDiferidos.this, jefeDiferido.class);
        nuevoformulario.putExtra("Diferidos", valor);
        startActivity(nuevoformulario);
    }
}