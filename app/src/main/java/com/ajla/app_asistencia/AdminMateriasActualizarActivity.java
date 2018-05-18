package com.ajla.app_asistencia;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.ajla.app_asistencia.Entidades.Area;

import java.util.ArrayList;

public class AdminMateriasActualizarActivity extends AppCompatActivity {
    ConexionSQLiteHelper conn;
    EditText editcodmate;
    EditText editnombremate;
    Spinner sp_materasin;
    ArrayList listadepartamentos;
    ArrayList<Area> ls;
    String datospuente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_materias_actualizar);
        conn = new ConexionSQLiteHelper(this);
        editcodmate = (EditText) findViewById(R.id.actcodmate);
        editnombremate = (EditText) findViewById(R.id.actnommateria);
        sp_materasin = (Spinner) findViewById(R.id.spinnerdepactmateria);


        consultarlistadepartamento();


        Bundle listav = getIntent().getExtras();
        String cod = listav.getString("editcodmate");
        String nom = listav.getString("editmate");
        String depa= listav.getString("editcodarea");


        editcodmate.setText(cod);
        editnombremate.setText(nom);

        ArrayAdapter<String> adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listadepartamentos);
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
        SQLiteDatabase db = conn.getReadableDatabase();

        Area area = null;
        ls = new ArrayList<Area>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + ConexionSQLiteHelper.DatosTabla.TABLA_AREA, null);

        while (cursor.moveToNext()) {
            area = new Area();
            area.setCod_area(cursor.getString(0));
            area.setMon_area(cursor.getString(1));


            ls.add(area);

        }
        obtenerlista();

    }

    private void obtenerlista() {

        listadepartamentos = new ArrayList<String>();
        listadepartamentos.add("Seleccione");
        for (int i = 0; i < ls.size(); i++) {
            listadepartamentos.add(ls.get(i).getMon_area());
        }
    }

    public void guardar(View view) {
        String codigo_mate = editcodmate.getText().toString();
        String nombre_mate = editnombremate.getText().toString();


        ConexionSQLiteHelper co = new ConexionSQLiteHelper(getApplication());
        SQLiteDatabase db = co.getWritableDatabase();
        if (db != null) {
            ContentValues registro = new ContentValues();
            registro.put("cod_materia", codigo_mate);
            registro.put("nom_materia", nombre_mate);
            registro.put("cod_area", datospuente);
            db.execSQL("UPDATE materia set nom_materia = '" + nombre_mate + "' , cod_area = '" + datospuente + "' where cod_materia == '" + codigo_mate + "'");
        }
    }
}