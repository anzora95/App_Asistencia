package com.ajla.app_asistencia;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AdminMaestroActualizarActivity extends AppCompatActivity {
ConexionSQLiteHelper conn;
EditText editisss;
EditText editnombre;
EditText editApellido;
EditText editcontra;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_maestro_actualizar);
        conn = new ConexionSQLiteHelper(this);
        editisss = (EditText) findViewById(R.id.editisss);
        editnombre = (EditText) findViewById(R.id.editNombre);
        editApellido = (EditText) findViewById(R.id.editApellido);
        editcontra = (EditText) findViewById(R.id.editContraseña);



        Bundle listav= getIntent().getExtras();
        String isss= listav.getString("isssac");
        String nombre= listav.getString("nomac");
        String apellido= listav.getString("apeac");
        String contra =listav.getString ("contrac");

        editisss.setText(isss);
        editnombre.setText(nombre);
        editApellido.setText(apellido);
        editcontra.setText(contra);

    }

    public void editdocente(View view) {

        String codigo_isss = editisss.getText().toString();
        String nombre_doce = editnombre.getText().toString();
        String apellido_doce = editApellido.getText().toString();
        String contra_doce = editcontra.getText().toString();


        ConexionSQLiteHelper co = new ConexionSQLiteHelper(getApplication());
        SQLiteDatabase db = co.getWritableDatabase();
        if (db != null) {
            ContentValues registro = new ContentValues();
            registro.put("isss", codigo_isss);
            registro.put("nom_doce", nombre_doce);
            registro.put("apel_doce", apellido_doce);
            registro.put("contra_doce", contra_doce);
           db.execSQL("UPDATE docente set nom_doce = '"+nombre_doce+"' , apel_doce = '"+apellido_doce+"' ,contra_doce= '"+contra_doce+"' where isss == '"+codigo_isss+"'");

            Intent p= new Intent(this, AdminMestroActivity.class);
            startActivity(p);

        }

    }
}
