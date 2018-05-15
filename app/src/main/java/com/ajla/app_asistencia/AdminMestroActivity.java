package com.ajla.app_asistencia;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AdminMestroActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private ListView listMaestros; //Onda del video
    private String datos[]={"IAI Introduccion a la Informatica","PDM Programacion para disporitivos moviles","HDP Herramientas de Productividad","a","b","c","d","","","","","","","",""};
    //Onda del video

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mestro);

        listMaestros = (ListView) findViewById(R.id.listmaestros); //Onda del video
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos); //Onda del video
        listMaestros.setOnItemClickListener(this); //Onda del video
        listMaestros.setOnItemLongClickListener(this);
        listMaestros.setAdapter(adaptador); //Onda del video


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String valor= (String) adapterView.getItemAtPosition(i); //Onda del video
        Intent lista = new Intent(AdminMestroActivity.this, MaestroNuevoActivity.class);  //Onda del video
        lista.putExtra("Docente",valor);
        startActivity(lista);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        AlertDialog.Builder DialogoAlerta= new AlertDialog.Builder(this);
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

    private void aceptar() {
        Toast.makeText(this,"FUNCIONA SIIII~", Toast.LENGTH_SHORT).show();
    }

    private void cancelar(){
        finish();
    }
}
