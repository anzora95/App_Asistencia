package com.ajla.app_asistencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AdminMateriasActualizarActivity extends AppCompatActivity {
    ConexionSQLiteHelper conn;
    EditText editcodmate;
    EditText editnombremate;
    EditText editdepamate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_materias_actualizar);
        conn = new ConexionSQLiteHelper(this);
        editcodmate = (EditText) findViewById(R.id.actcodmate);
        editnombremate= (EditText) findViewById(R.id.actnommateria);
        editdepamate = (EditText) findViewById(R.id.spinnerdepactmateria);




        Bundle listav= getIntent().getExtras();
        String isss= listav.getString("editcodnate");
        String nombre= listav.getString("editnombre");
        String apellido= listav.getString("apeac");


        editcodmate.setText(isss);
        editnombremate.setText(nombre);
        editdepamate.setText(apellido);

    }

    public void guardar(View view) {
    }
}
