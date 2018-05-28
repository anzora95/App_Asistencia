package com.ajla.app_asistencia;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AdminAlumnoActualizarActivity extends AppCompatActivity {
    ConexionSQLiteHelper conn;
    EditText editcarnet;
    EditText editnom;
    EditText editApe;
    EditText editcontraA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_alumno_actualizar);
        editcarnet = (EditText) findViewById(R.id.editcarnet);
        editnom = (EditText) findViewById(R.id.editNombreA);
        editApe = (EditText) findViewById(R.id.editApellidoA);
        editcontraA = (EditText) findViewById(R.id.editContraseñaA);

        Bundle listav= getIntent().getExtras();
        String isss= listav.getString("carnetac");
        String nombre= listav.getString("nomAlumac");
        String apellido= listav.getString("apeAlumac");
        String contra =listav.getString ("contrAlumac");

        editcarnet.setText(isss);
        editnom.setText(nombre);
        editApe.setText(apellido);
        editcontraA.setText(contra);
    }
    public void editalumno(View view) {

        String codigo = editcarnet.getText().toString();
        String nombre_alum = editnom.getText().toString();
        String apellido_alum = editApe.getText().toString();
        String contra_alum = editcontraA.getText().toString();


        ConexionSQLiteHelper co = new ConexionSQLiteHelper(getApplication());
        SQLiteDatabase db = co.getWritableDatabase();
        if (db != null) {

            db.execSQL("UPDATE alumno set nom_alum = '"+nombre_alum+"' , apel_alum= '"+apellido_alum+"', contra_alum = '"+contra_alum+"'  where carnet == '"+codigo+"'");

            Intent p= new Intent(this, AdminAlumnoActivity.class);
            startActivity(p);

        }

    }
}
