package com.ajla.app_asistencia;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ajla.app_asistencia.Entidades.Docente;

import java.util.ArrayList;

public class AdminMestroActivity extends AppCompatActivity {
    ListView listViewMaestros;
    ConexionSQLiteHelper conec;
    ArrayList<String> lmaesinfo;
    ArrayList<Docente> listamaestro;
    String puen;
    String tv_isss,tv_nombre,tv_apellido,tv_contraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mestro);

        conec= new ConexionSQLiteHelper(getApplicationContext());

        listViewMaestros = (ListView) findViewById(R.id.listmaestros);


        consultarlistamaestro();



        ArrayAdapter adaptado= new ArrayAdapter(this,android.R.layout.simple_list_item_1,lmaesinfo);
        listViewMaestros.setAdapter(adaptado);

        listViewMaestros.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                puen = listamaestro.get(i).getIsss();

                Context context = AdminMestroActivity.this;
                AlertDialog.Builder DialogoAlerta = new AlertDialog.Builder(context);
                DialogoAlerta.setTitle("ELIMINAR CATEDRÁTICO");
                DialogoAlerta.setMessage("¿Realmente desea eliminiar este catedrático?");
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

        listViewMaestros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv_isss =listamaestro.get(i).getIsss();
                tv_nombre =listamaestro.get(i).getNom_doce();
                tv_apellido= listamaestro.get(i).getApe_doce();
                tv_contraseña =listamaestro.get(i).getContra_doce();



                Intent lista = new Intent(AdminMestroActivity.this, AdminMaestroActualizarActivity.class);  //Onda del video
                lista.putExtra("isssac",tv_isss);
                lista.putExtra("nomac",tv_nombre);
                lista.putExtra("apeac",tv_apellido);
                lista.putExtra("contrac",tv_contraseña);
                startActivity(lista);

            }
        });


    }


    private void consultarlistamaestro() {

        SQLiteDatabase db=conec.getReadableDatabase();

        Docente doce;
        listamaestro = new ArrayList<Docente>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ConexionSQLiteHelper.DatosTabla.TABLA_DOCENTE,null );

        while(cursor.moveToNext()){
            doce= new Docente();
            doce.setIsss(cursor.getString(0));
            doce.setNom_doce(cursor.getString(1));
            doce.setApe_doce(cursor.getString(2));
            doce.setContra_doce(cursor.getString(3));


            listamaestro.add(doce);

        }
        obtenerlista();
    }

    private void obtenerlista() {
        lmaesinfo=new ArrayList<String>();

        for(int i=0; i<listamaestro.size();i++)
        {
            lmaesinfo.add(listamaestro.get(i).getIsss()+"   "+listamaestro.get(i).getNom_doce()+"  "+listamaestro.get(i).getApe_doce());
        }
    }


    private void aceptar() {
        SQLiteDatabase db=conec.getWritableDatabase();
        db.execSQL("Delete from docente where isss='"+puen+"'");
        Toast.makeText(this,"FUNCIONA SIIII~", Toast.LENGTH_SHORT).show();
    }

    private void cancelar(){
        finish();
    }

    public void agregar(View view) {
        Intent lista = new Intent(AdminMestroActivity.this, MaestroNuevoActivity.class);  //Onda del video
        startActivity(lista);

    }
}
