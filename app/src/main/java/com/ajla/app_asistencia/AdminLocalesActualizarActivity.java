package com.ajla.app_asistencia;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AdminLocalesActualizarActivity extends AppCompatActivity {
    ConexionSQLiteHelper conn;
    EditText editcodlugar;
    EditText editcapacidad;
    Spinner sp_tipo;
    String datospuente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_locales_actualizar);

        conn = new ConexionSQLiteHelper(this);
        editcodlugar = (EditText) findViewById(R.id.editlocal);
        editcapacidad = (EditText) findViewById(R.id.editcapacidad);
        sp_tipo = (Spinner) findViewById(R.id.spinnerlocaledit);

        Bundle listav = getIntent().getExtras();
        String cod = listav.getString("editcodligar");
        String capa = listav.getString("editcapa");
        String tipo = listav.getString("edittipo");

        editcodlugar.setText(cod);
        editcapacidad.setText(capa);

        ArrayAdapter<CharSequence> adaptador= ArrayAdapter.createFromResource(this,R.array.listatipo,android.R.layout.simple_spinner_item);
        sp_tipo.setAdapter(adaptador);
        sp_tipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                datospuente= parent.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void editlocal(View view) {
        String codigo = editcodlugar.getText().toString();
        String capacidad = editcapacidad.getText().toString();


        ConexionSQLiteHelper co = new ConexionSQLiteHelper(getApplication());
        SQLiteDatabase db = co.getWritableDatabase();
        if (db != null) {
            ContentValues registro = new ContentValues();
            registro.put("cod_lugar",codigo);
            registro.put("capacidad",capacidad);
            registro.put("tipo",datospuente);
            db.execSQL("UPDATE lugar set capacidad = '" + capacidad + "' , tipo = '" + datospuente + "' where cod_lugar == '" + codigo + "'");

        }

    }
}
