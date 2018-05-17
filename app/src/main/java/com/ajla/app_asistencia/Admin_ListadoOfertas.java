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
import android.widget.TextView;
import android.widget.Toast;

public class Admin_ListadoOfertas extends AppCompatActivity implements ListView.OnItemClickListener, AdapterView.OnItemLongClickListener{

    private TextView textListadoOfertas; //Onda del video
    private ListView  listOfertas; //Onda del video
    private String ofertas[]={"oferta1","oferta2","oferta3","4","5","6","7","","","","","","","",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__listado_ofertas);

        listOfertas = (ListView) findViewById(R.id.listOfertas); //Onda del video
        ArrayAdapter<String> adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ofertas); //Onda del video
        listOfertas.setOnItemClickListener(this); //Onda del video
        listOfertas.setOnItemLongClickListener(this);

        listOfertas.setAdapter(adap);


        textListadoOfertas=(TextView) findViewById(R.id.textListadoOfertas); //Onda del video
        Bundle parametrosXD =  getIntent().getExtras();

        if (parametrosXD != null){

            textListadoOfertas.setText(parametrosXD.getString("Materias"));
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String val= (String) parent.getItemAtPosition(position); //Onda del video
        Intent nuevoFormXDp = new Intent(Admin_ListadoOfertas.this, Admin_AntesGTGL.class);  //Onda del video
        nuevoFormXDp.putExtra("Ofertas",val);
        startActivity(nuevoFormXDp);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        AlertDialog.Builder DialogoAlerta= new AlertDialog.Builder(this);
        DialogoAlerta.setTitle("ELIMINAR OFERTA CICLO");
        DialogoAlerta.setMessage("¿Realmente desea eliminiar esta oferta ciclo?");
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
        Toast.makeText(this,"FUNCION SIIII~",Toast.LENGTH_SHORT).show();
    }

    private void cancelar(){
        finish();
    }


    public void nuevaOferta(View view) {
        Intent OfertaBoton = null;
        switch (view.getId()) {

            case R.id.btnNuevaOferta:
                OfertaBoton = new Intent(Admin_ListadoOfertas.this, Admin_AntesGTGL.class);
                break;
        }
        startActivity(OfertaBoton);
    }

}
