package com.ajla.app_asistencia;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
                                                           //Onda del video que me dio error
public class Admin_Registro_GL_GT extends AppCompatActivity implements ListView.OnItemClickListener{

    private ListView listMateriasCiclo; //Onda del video
    private String datos[]={"IAI Introduccion a la Informatica","PDM Programacion para disporitivos moviles","HDP Herramientas de Productividad","a","b","c","d","","","","","","","",""};
    //Onda del video

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__registro__gl__gt);

        listMateriasCiclo = (ListView) findViewById(R.id.listMateriasCiclo); //Onda del video
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos); //Onda del video
        listMateriasCiclo.setOnItemClickListener(this); //Onda del video
        listMateriasCiclo.setAdapter(adaptador); //Onda del video
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) { //Onda creada por una cosa que me dio error arriba
      String valor= (String) parent.getItemAtPosition(position); //Onda del video
      Intent nuevoFormXD = new Intent(Admin_Registro_GL_GT.this, Admin_ListadoOfertas.class);  //Onda del video
      nuevoFormXD.putExtra("Materias",valor);
      startActivity(nuevoFormXD);
    }

}