package com.ajla.app_asistencia;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ajla.app_asistencia.Entidades.Area;

import java.util.ArrayList;

public class AdminLocalNuevoActivity extends AppCompatActivity {

    EditText codlocal,capacidad;
    String datospuente;
    ConexionSQLiteHelper conec;
    Spinner sp_tipo;

   // ArrayList<Area> ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_local_nuevo);

        codlocal = (EditText) findViewById(R.id.newLocal);
        capacidad = (EditText) findViewById(R.id.newCapaciLocal);
        sp_tipo=(Spinner) findViewById(R.id.spinerLocalTipo);

        conec= new ConexionSQLiteHelper(getApplicationContext());

        ArrayAdapter<CharSequence> adaptador= ArrayAdapter.createFromResource(this,R.array.listatipo,android.R.layout.simple_spinner_item);
        sp_tipo.setAdapter(adaptador);
        sp_tipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
               datospuente= parent.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void guardarLocal(View view) {
        String codigo_local=codlocal.getText().toString();
        String capa_local=capacidad.getText().toString();





        SQLiteDatabase db= conec.getWritableDatabase();

        if (db!=null){
            ContentValues registro= new ContentValues();
            registro.put("cod_lugar",codigo_local);
            registro.put("capacidad",capa_local);
            registro.put("tipo",datospuente);
            long i=db.insert("lugar",null,registro);


            if(i>0){
                Toast.makeText(AdminLocalNuevoActivity.this,"Guardado con exito",Toast.LENGTH_SHORT).show();
                Intent p= new Intent(this, AdminLocalesActivity.class);
                startActivity(p);
            }
        }
    }
}
