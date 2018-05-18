package com.ajla.app_asistencia;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MaestroNuevoActivity extends AppCompatActivity {
    EditText tv_isss,tv_nombre,tv_apellido,tv_contraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maestro_nuevo);

        tv_isss = (EditText) findViewById(R.id.isssnuevo);
        tv_nombre = (EditText) findViewById(R.id.nomdocenuevo);
        tv_apellido = (EditText) findViewById(R.id.apedocenuevo);
        tv_contraseña = (EditText) findViewById(R.id.contradocenuevo);


    }

    public void guardar(View view) {
        String codigo_isss = tv_isss.getText().toString();
        String nombre_doce = tv_nombre.getText().toString();
        String apellido_doce = tv_apellido.getText().toString();
        String contra_doce = tv_contraseña.getText().toString();


        ConexionSQLiteHelper co = new ConexionSQLiteHelper(getApplication());
        SQLiteDatabase db = co.getWritableDatabase();
        if (db != null) {
            ContentValues registro = new ContentValues();
            registro.put("isss", codigo_isss);
            registro.put("nom_doce", nombre_doce);
            registro.put("apel_doce", apellido_doce);
            registro.put("contra_doce", contra_doce);
            long i = db.insert("docente", null, registro);


            if (i > 0) {
                Toast.makeText(MaestroNuevoActivity.this, "Guardado con exito", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
