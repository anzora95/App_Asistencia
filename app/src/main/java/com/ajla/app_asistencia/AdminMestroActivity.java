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
import com.ajla.app_asistencia.Entidades.Materia;

import java.util.ArrayList;

public class AdminMestroActivity extends AppCompatActivity {
    ListView listViewMaestros;
    ConexionSQLiteHelper conec;
    ArrayList<String> lmaesinfo;
    ArrayList<Docente> listamaestro;
    TextView tv_isss,tv_nombre,tv_apellido,tv_contraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mestro);

        conec= new ConexionSQLiteHelper(getApplicationContext());

        listViewMaestros = (ListView) findViewById(R.id.listmaestros);

        consultarlistamaestro();
       //Onda del video
        ArrayAdapter adaptado= new ArrayAdapter(this,android.R.layout.simple_list_item_1,lmaesinfo); //Onda del video
        listViewMaestros.setAdapter(adaptado);

        listViewMaestros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv_isss = (TextView) view.findViewById(R.id.editisss);
                tv_nombre =(TextView) view.findViewById(R.id.editNombre);
                tv_apellido= (TextView) view.findViewById(R.id.editApellido);
                tv_contraseña =(TextView) view.findViewById(R.id.editContraseña);

                String aux_isss = tv_isss.getText().toString();

                Intent lista = new Intent(AdminMestroActivity.this, MaestroNuevoActivity.class);  //Onda del video
                lista.putExtra("idisss",aux_isss);
                startActivity(lista);

            }
        });
        listViewMaestros.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
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

    }


    private void consultarlistamaestro() {

        SQLiteDatabase db=conec.getReadableDatabase();

        Docente doce =null;
        listamaestro = new ArrayList<Docente>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ConexionSQLiteHelper.DatosTabla.TABLA_DOCENTE,null );

        while(cursor.moveToNext()){
            doce= new Docente(null,null,null,null);
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
