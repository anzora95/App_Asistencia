package com.ajla.app_asistencia;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ajla.app_asistencia.Entidades.Alumno;
import com.ajla.app_asistencia.Entidades.Ciclo;

public class jefeDiferido extends AppCompatActivity implements View.OnClickListener {
    EditText solicitud,nombre,apellido,fecha;
    String codigo,nombres,apellidos;
    ConexionSQLiteHelper conec;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jefe_diferido);

        Bundle listav = getIntent().getExtras();
        codigo = listav.getString("jefecoddife");

        conec= new ConexionSQLiteHelper(getApplicationContext());

        solicitud=(EditText) findViewById(R.id.idnombre);
        nombre=(EditText) findViewById(R.id.idMateria);
        apellido=(EditText) findViewById(R.id.idapedif);


        solicitud.setText(codigo);


        Alumno alu;
        SQLiteDatabase db1= conec.getReadableDatabase();


        Cursor cursor =db1.rawQuery("SELECT * FROM alumno inner join solicitud_diferido on alumno.carnet=solicitud_diferido.carnet where solicitud_diferido.id_solicitud == "+codigo+"",null);
        while (cursor.moveToNext()) {
            alu =new Alumno();
            alu.setNom_alum(cursor.getString(1));
            alu.setApel_alum(cursor.getString(2));

            nombres = alu.getNom_alum().toString();
            apellidos= alu.getApel_alum().toString();

        }
        nombre.setText(nombres);
        apellido.setText(apellidos);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.aceptardife:
                SQLiteDatabase db = conec.getWritableDatabase();
                db.execSQL("UPDATE solicitud_diferido set estado = 1 where id_solicitud == '" + codigo+ "'");
                Toast.makeText(jefeDiferido.this,"se aprobo la solicitud",Toast.LENGTH_LONG).show();
                Intent inten = new Intent (jefeDiferido.this,jefeMenu.class);
                startActivity(inten);
            break;
            case R.id.denegardife:

                Toast.makeText(jefeDiferido.this,"se denego la solicitud",Toast.LENGTH_LONG).show();
                Intent inten1 = new Intent (jefeDiferido.this,jefeMenu.class);
                startActivity(inten1);
            break;
        }
    }
}
