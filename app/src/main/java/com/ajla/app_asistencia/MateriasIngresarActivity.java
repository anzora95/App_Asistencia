package com.ajla.app_asistencia;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MateriasIngresarActivity extends AppCompatActivity {
    EditText codmate,nommate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materias_ingresar);
    }

    public void guardar(View view) {

        String codigo_mate=codmate.getText().toString();
        String nombre_mate=nommate.getText().toString();

        ConexionSQLiteHelper co= new ConexionSQLiteHelper(getApplication());
        SQLiteDatabase db= co.getWritableDatabase();
        if (db!=null){
            ContentValues registro= new ContentValues();
            registro.put("cod_materia",codigo_mate);
            registro.put("nom_materia",nombre_mate);
            long i=db.insert("materia",null,registro);


            if(i>0){
                Toast.makeText(MateriasIngresarActivity.this,"Guardado con exito",Toast.LENGTH_SHORT).show();
            }
        }



    }
}
