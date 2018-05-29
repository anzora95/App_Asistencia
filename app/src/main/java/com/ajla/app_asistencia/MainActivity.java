package com.ajla.app_asistencia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ajla.app_asistencia.Entidades.Administrador;
import com.ajla.app_asistencia.Entidades.Alumno;
import com.ajla.app_asistencia.Entidades.Docente;
import com.ajla.app_asistencia.Entidades.Jefe_Departamento;
import com.ajla.app_asistencia.Entidades.Materia;

import java.util.ArrayList;
import java.util.List;

import static com.ajla.app_asistencia.ConexionSQLiteHelper.DatosTabla.CAMPO_USUARIO;

public class MainActivity extends AppCompatActivity {

    Button btn_login;
    ConexionSQLiteHelper conect;
    EditText edt_nom;
    EditText edt_pass;

    String name;
    String pass;
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


             name= edt_nom.getText().toString();
             pass = edt_pass.getText().toString();



            if( validacionAlumno(name,pass)){

                lanzarActi_alum(name);


            }else if(validacioAdmin(name,pass)){//validacion administrador


                lanzarActi_admin();

            }else if(validacionDocente(name,pass)){//validacion docente



                lanzarActi_Docente(name,pass);


            }else if(validacionJefe(name,pass)){//validacion de jefe de departamento
                lanzarActi_Jefe();

            }else{

                Toast.makeText(MainActivity.this,"datos equivocados",Toast.LENGTH_LONG).show();
            }



            }
        });


    }

    //------------------VALIDACION PARA EL ALUMNO------------------------

    private boolean validacionAlumno(String n, String p){ //donde n es nombre y p es password

        SQLiteDatabase base= conect.getReadableDatabase();
        boolean bandera=false;


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

                cursor.close();
                bandera=true;
                }
        }

        return bandera;


    }

    //----------LANZA ACTIVITY ALUMNO MENU-------------

    private void lanzarActi_alum(String name){



        Intent inte_alum = new Intent(MainActivity.this,Alumno_Menu.class);
        inte_alum.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(inte_alum);


    }

    //-----------------------VALIDACION ADMINISTRADOR-----------------


    private boolean validacioAdmin(String n, String p){

        SQLiteDatabase base= conect.getReadableDatabase();
        boolean bandera=false;

        Administrador admini = null;
        List <Administrador> ls_Admin = new ArrayList<>();

        Cursor cursor = base.rawQuery("SELECT * FROM "+ConexionSQLiteHelper.DatosTabla.TABLA_ADMINISTRADOR,null);

        while(cursor.moveToNext()){

            admini = new Administrador(null, null);
            admini.setUsuario(cursor.getString(0));
            admini.setContraseaña(cursor.getString(1));
            ls_Admin.add(admini);

        }
        for(Administrador admin:ls_Admin){

            if (admin.getContraseaña().equals(p) && admin.getUsuario().equals(n)){

                cursor.close();
                bandera=true;
            }
        }

        return bandera;


    }

    //--------LANZAR ACTIVITY ADMINISTRADOR MENU-----------------------

    private void lanzarActi_admin(){

        Intent inte_admin = new Intent(MainActivity.this,Admin_Inicio.class);
        inte_admin.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(inte_admin);

    }

    //----------------------------------VALIDACION DOCENTE------------------------------------

    private boolean validacionDocente(String n, String p){

        SQLiteDatabase base= conect.getReadableDatabase();
        boolean bandera=false;

        Docente docente = null;

        List <Docente> ls_docen = new ArrayList<>();

        Cursor cursor = base.rawQuery("SELECT * FROM "+ConexionSQLiteHelper.DatosTabla.TABLA_DOCENTE,null);

        while(cursor.moveToNext()){

            docente = new Docente(null, null, null,null);
            docente.setIsss(cursor.getString(0));
            docente.setContra_doce(cursor.getString(3));
            ls_docen.add(docente);

        }
        for(Docente doc:ls_docen){

            if (doc.getContra_doce().equals(p) && doc.getIsss().equals(n)){

                cursor.close();
                bandera=true;
            }
        }

        return bandera;


    }

    //--------------------------------------------LANZAR ACTIVITY DOCENTE-------------------------

    private void lanzarActi_Docente(String u, String p){

        if(!edt_nom.equals(null)){

            String nom = edt_nom.getText().toString();

        }

        Intent inte_doc = new Intent(MainActivity.this,DocenteMenu.class);
        inte_doc.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        inte_doc.putExtra("nombre",edt_nom.getText().toString());
        startActivity(inte_doc);

    }

    //--------------------------------------------VALIDACION JEFE DE DEPARTAMENTO------------------------------------

    private boolean validacionJefe(String n, String p){ //donde n es nombre y p es password

        SQLiteDatabase base= conect.getReadableDatabase();
        boolean bandera=false;


        Jefe_Departamento jefe = null;
        List<Jefe_Departamento> ls_jefe = new ArrayList<>();
        Cursor cursor= base.rawQuery("SELECT * FROM "+ConexionSQLiteHelper.DatosTabla.TABLA_JEFE_DEPARTAMENTO,null);

        while(cursor.moveToNext()){

            jefe = new Jefe_Departamento(null, null, null, null);
            jefe.setIsss(cursor.getString(1));
            jefe.setContraseña(cursor.getString(3));
            ls_jefe.add(jefe);

        }

        for(Jefe_Departamento boss:ls_jefe){

            if (boss.getContraseña().equals(p) && boss.getIsss().equals(n)){

                cursor.close();
                bandera=true;
            }
        }

        return bandera;


    }

    //----------LANZA ACTIVITY ALUMNO MENU-------------

    private void lanzarActi_Jefe(){

        Intent inte_jefe = new Intent(MainActivity.this,jefeMenu.class);
        inte_jefe.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        inte_jefe.putExtra("nombre",edt_nom.getText().toString());
        startActivity(inte_jefe);


    }










}
