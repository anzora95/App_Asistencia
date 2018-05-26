package com.ajla.app_asistencia;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ajla.app_asistencia.Entidades.Area;
import com.ajla.app_asistencia.Entidades.Materia;

import java.util.ArrayList;

public class MateriasIngresarActivity extends AppCompatActivity {
    EditText codmate,nommate;
    String datospuente;
    ConexionSQLiteHelper conec;
    Spinner sp_materasin;
    ArrayList listadepartamentos;
    ArrayList<Area> ls;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materias_ingresar);

        codmate = (EditText) findViewById(R.id.insertcodmate);
        nommate = (EditText) findViewById(R.id.insertnommateria);
        sp_materasin=(Spinner) findViewById(R.id.spinnerdepartingresarmateria);

        conec= new ConexionSQLiteHelper(getApplicationContext());

        consultarlistadepartamento();

        ArrayAdapter<String> adaptador= new ArrayAdapter(this,android.R.layout.simple_spinner_item,listadepartamentos);
        sp_materasin.setAdapter(adaptador);
        sp_materasin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                datospuente = ls.get(i).getCod_area();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void consultarlistadepartamento() {

        SQLiteDatabase db=conec.getReadableDatabase();

       Area area=null;
        ls = new ArrayList<Area>();
        Cursor cursor=db.rawQuery("SELECT * FROM "+ConexionSQLiteHelper.DatosTabla.TABLA_AREA,null);

        while(cursor.moveToNext()){
            area= new Area();
            area.setCod_area(cursor.getString(0));
            area.setMon_area(cursor.getString(1));


            ls.add(area);

        }
        obtenerlista();

    }

    private void obtenerlista() {

        listadepartamentos =new ArrayList<String>();
        listadepartamentos.add("Seleccione");
        for(int i=0; i<ls.size();i++)
        {
            listadepartamentos.add(ls.get(i).getMon_area());
        }
    }

    public void guardar(View view) {

        String codigo_mate=codmate.getText().toString();
        String nombre_mate=nommate.getText().toString();





        SQLiteDatabase db= conec.getWritableDatabase();

         if (db!=null){
            ContentValues registro= new ContentValues();
            registro.put("cod_materia",codigo_mate);
            registro.put("nom_materia",nombre_mate);
            registro.put("cod_area",datospuente);
            long i=db.insert("materia",null,registro);


            if(i>0){
                Toast.makeText(MateriasIngresarActivity.this,"Guardado con exito",Toast.LENGTH_SHORT).show();
                Intent p= new Intent(this, AdminMateriasCatalogoActivity.class);
                startActivity(p);
            }
        }



    }
}
