package com.ajla.app_asistencia;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ajla.app_asistencia.Entidades.Alumno;
import com.ajla.app_asistencia.Entidades.Materia;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_login;
    ConexionSQLiteHelper conect;
    EditText edt_nom;
    EditText edt_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_nom=findViewById(R.id.ET_nom_log);
        edt_pass=findViewById(R.id.ET_pass_log);

        conect= new ConexionSQLiteHelper(getApplicationContext());
        btn_login= findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent inte_inicio = new Intent(MainActivity.this,Alumno_Menu.class);
               inte_inicio.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
               startActivity(inte_inicio);

             String name= edt_nom.getText().toString();
             String pass = edt_pass.getText().toString();

             validacion(name,pass);


             //crear metodo que compare pass y name
            }
        });


    }

    private void validacion(String n, String p){ //donde n es nombre y p es password

        SQLiteDatabase base= conect.getReadableDatabase();
        Alumno alum = null;

        List<Alumno> ls_alum = new ArrayList<Alumno>();
        Cursor cursor= base.rawQuery("SELECT * FROM "+ConexionSQLiteHelper.DatosTabla.TABLA_ALUMNO,null);

        while(cursor.moveToNext()){

            alum = new Alumno(null, null, null, null);
            alum.setCarnet(cursor.getString(0));
            alum.setContra_alum(cursor.getString(3));
            ls_alum.add(alum);

        }

        for(Alumno stud:ls_alum){

            if (stud.getContra_alum().equals(p) && stud.getCarnet().equals(n)){

                Intent inte_alum = new Intent(MainActivity.this,Alumno_Menu.class);
                startActivity(inte_alum);

                cursor.close();

            }
        }


    }



    /*private void consultarlistamaterias() {

        SQLiteDatabase db=conect.getReadableDatabase();

        Materia materia=null;
        listamaterias = new ArrayList<Materia>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ConexionSQLiteHelper.DatosTabla.TABLA_MATERIA,null);

        while(cursor.moveToNext()){
            materia= new Materia(null,null);
            materia.setCod_materia(cursor.getString(0));
            materia.setNom_materia(cursor.getString(2));


            listamaterias.add(materia);

        }
        obtenerlista();

    }*/

}
