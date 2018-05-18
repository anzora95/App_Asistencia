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
import android.widget.Toast;


import com.ajla.app_asistencia.Entidades.Materia;

import java.util.ArrayList;

public class AdminMateriasCatalogoActivity extends AppCompatActivity {
    ListView listViewmaterias;
    ConexionSQLiteHelper conec;
    ArrayList<String> lmateinfo;
    ArrayList<Materia> listamaterias;
    String puente;
    String cod_mate,cod_area,nom_mate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_materias_catalogo);

        conec= new ConexionSQLiteHelper(getApplicationContext());

        listViewmaterias = (ListView) findViewById(R.id.listmaterias);

        consultarlistamaterias();

        ArrayAdapter adaptado= new ArrayAdapter(this,android.R.layout.simple_list_item_1,lmateinfo);
        listViewmaterias.setAdapter(adaptado);
        listViewmaterias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cod_mate =listamaterias.get(i).getCod_materia();
                cod_area=listamaterias.get(i).getCod_area();
                nom_mate= listamaterias.get(i).getNom_materia();




                Intent lista = new Intent(AdminMateriasCatalogoActivity.this, AdminMateriasActualizarActivity.class);  //Onda del video
                lista.putExtra("editcodmate",cod_mate);
                lista.putExtra("editcodarea",cod_area);
                lista.putExtra("editmate",nom_mate);
                startActivity(lista);


            }
        });

        listViewmaterias.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
           public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                puente = listamaterias.get(i).getCod_materia();
                Context context = AdminMateriasCatalogoActivity.this;
                AlertDialog.Builder DialogoAlerta = new AlertDialog.Builder(context);
                DialogoAlerta.setTitle("ELIMINAR MATERIA");
                DialogoAlerta.setMessage("¿Realmente desea eliminiar esta materia?");
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

    private void consultarlistamaterias() {

        SQLiteDatabase db=conec.getReadableDatabase();

        Materia materia=null;
        listamaterias = new ArrayList<Materia>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ConexionSQLiteHelper.DatosTabla.TABLA_MATERIA,null);

        while(cursor.moveToNext()){
            materia= new Materia();
            materia.setCod_materia(cursor.getString(0));
            materia.setCod_area(cursor.getString(1));
            materia.setNom_materia(cursor.getString(2));


            listamaterias.add(materia);

        }
        obtenerlista();

    }

    private void obtenerlista() {

        lmateinfo=new ArrayList<String>();

        for(int i=0; i<listamaterias.size();i++)
        {
            lmateinfo.add(listamaterias.get(i).getCod_materia()+"   "+listamaterias.get(i).getNom_materia());
        }
    }


    private void aceptar() {
        SQLiteDatabase db=conec.getWritableDatabase();
        db.execSQL("Delete from materia where cod_materia='"+puente+"'");
        Toast.makeText(this,"FUNCIONA SIIII~", Toast.LENGTH_SHORT).show();


    }

    private void cancelar() {
        finish();
    }

    public void agregar(View view) {
        Intent intn= new Intent(AdminMateriasCatalogoActivity.this,MateriasIngresarActivity.class);
        startActivity(intn);
    }
}