package com.ajla.app_asistencia;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ajla.app_asistencia.Entidades.Alumno;
import com.ajla.app_asistencia.Entidades.Docente;

import java.util.ArrayList;

public class AdminAlumnoActivity extends AppCompatActivity {

    ListView listViewAlumnos;
    ConexionSQLiteHelper conec;
    ArrayList<String> laluminfo;
    ArrayList<Alumno> listaalumno;
    String puen;
    String tv_carnet,tv_nombre,tv_apellido,tv_contraseña;
    ArrayAdapter adaptado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_alumno);


        ActionBar action=getSupportActionBar();
        action.setDisplayHomeAsUpEnabled(true);

        conec= new ConexionSQLiteHelper(getApplicationContext());

        listViewAlumnos = (ListView) findViewById(R.id.listalumno);


        consultarlistaalumno();



        adaptado = new ArrayAdapter(this,android.R.layout.simple_list_item_1,laluminfo);
        listViewAlumnos.setAdapter(adaptado);

        listViewAlumnos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                puen = listaalumno.get(i).getCarnet();

                Context context = AdminAlumnoActivity.this;
                AlertDialog.Builder DialogoAlerta = new AlertDialog.Builder(context);
                DialogoAlerta.setTitle("ELIMINAR ALUMNO");
                DialogoAlerta.setMessage("¿Realmente desea eliminiar este alumno?");
                DialogoAlerta.setCancelable(false);
                DialogoAlerta.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {


                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        aceptar();
                    }
                });
                DialogoAlerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cancelar();
                    }
                });
                DialogoAlerta.show();
                return true;
            }
        });

        listViewAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv_carnet =listaalumno.get(i).getCarnet();
                tv_nombre =listaalumno.get(i).getNom_alum();
                tv_apellido= listaalumno.get(i).getApel_alum();
                tv_contraseña =listaalumno.get(i).getContra_alum();



                Intent lista = new Intent(AdminAlumnoActivity.this, AdminAlumnoActualizarActivity.class);  //Onda del video
                lista.putExtra("carnetac",tv_carnet);
                lista.putExtra("nomAlumac",tv_nombre);
                lista.putExtra("apeAlumac",tv_apellido);
                lista.putExtra("contrAlumac",tv_contraseña);
                startActivity(lista);

            }
        });

    }

    private void aceptar() {
        SQLiteDatabase db=conec.getWritableDatabase();
        db.execSQL("Delete from alumno where carnet='"+puen+"'");
        Toast.makeText(this,"Registro eliminado", Toast.LENGTH_SHORT).show();
        Intent P= new Intent(this,AdminAlumnoActivity.class);
        startActivity(P);
    }
    private void cancelar(){
        closeContextMenu();

    }

    private void consultarlistaalumno() {

        SQLiteDatabase db=conec.getReadableDatabase();

        Alumno doce;
        listaalumno = new ArrayList<Alumno>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ConexionSQLiteHelper.DatosTabla.TABLA_ALUMNO,null );

        while(cursor.moveToNext()){
            doce= new Alumno();
            doce.setCarnet(cursor.getString(0));
            doce.setNom_alum(cursor.getString(1));
            doce.setApel_alum(cursor.getString(2));
            doce.setContra_alum(cursor.getString(3));


            listaalumno.add(doce);

        }
        obtenerlista();
    }

    private void obtenerlista() {
        laluminfo=new ArrayList<String>();

        for(int i=0; i<listaalumno.size();i++)
        {
            laluminfo.add(listaalumno.get(i).getCarnet()+"   "+listaalumno.get(i).getNom_alum()+"  "+listaalumno.get(i).getApel_alum());
        }
    }


    public void agregara(View view) {
        Intent lista = new Intent(AdminAlumnoActivity.this, AdminAlumnoNuevoActivity.class);  //Onda del video
        startActivity(lista);


    }
}
