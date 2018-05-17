package com.ajla.app_asistencia;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MaestroNuevoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maestro_nuevo);
    }

    public void guardar(View view) {
        /*ConexionSQLiteHelper managerBD= new ConexionSQLiteHelper(getApplicationContext());
        SQLiteDatabase db=managerBD.getReadableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(ConexionSQLiteHelper.DatosTabla.CAMPO_CARNET,"gr");
        valores.put(ConexionSQLiteHelper.DatosTabla.CAMPO_NOMBRE,"ganuza");
        valores.put(ConexionSQLiteHelper.DatosTabla.CAMPO_APELLIDO,"galdamez");
        valores.put(ConexionSQLiteHelper.DatosTabla.CAMPO_CONTRA_ALUMNO,"tyuo");
        Long Idguardado= db.insert(ConexionSQLiteHelper.DatosTabla.TABLA_ALUMNO,ConexionSQLiteHelper.DatosTabla.CAMPO_CARNET,valores);
        Toast.makeText(getApplicationContext(),"lo hizo"+Idguardado,Toast.LENGTH_LONG).show();
        Toast.makeText(MaestroNuevoActivity.this,"Guardado con exito",Toast.LENGTH_SHORT).show();
    */
    }
}
