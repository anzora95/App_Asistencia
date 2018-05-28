package com.ajla.app_asistencia;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminAlumnoNuevoActivity extends AppCompatActivity {
    EditText tv_isss, tv_nombre, tv_apellido, tv_contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_alumno_nuevo);
        tv_isss = (EditText) findViewById(R.id.carnetnuevo);
        tv_nombre = (EditText) findViewById(R.id.nomalumnnuevo);
        tv_apellido = (EditText) findViewById(R.id.apealumnuevo);
        tv_contraseña = (EditText) findViewById(R.id.contraalumnuevo);
    }

    public void guardarAl(View view) {
        String codigo_isss = tv_isss.getText().toString();
        String nombre_doce = tv_nombre.getText().toString();
        String apellido_doce = tv_apellido.getText().toString();
        String contra_doce = tv_contraseña.getText().toString();


        ConexionSQLiteHelper co = new ConexionSQLiteHelper(getApplication());
        SQLiteDatabase db = co.getWritableDatabase();
        if (db != null) {
            ContentValues registro = new ContentValues();
            registro.put("carnet", codigo_isss);
            registro.put("nom_alum", nombre_doce);
            registro.put("apel_alum", apellido_doce);
            registro.put("contra_alum", contra_doce);
            long i = db.insert("alumno", null, registro);


            if (i > 0) {
                Toast.makeText(AdminAlumnoNuevoActivity.this, "Guardado con exito", Toast.LENGTH_SHORT).show();
                Intent p = new Intent(AdminAlumnoNuevoActivity.this, AdminAlumnoActivity.class);
                startActivity(p);
            }
        }
    }
}
