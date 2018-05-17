package com.ajla.app_asistencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.ajla.app_asistencia.Entidades.Docente;

public class AdminMaestroActualizarActivity extends AppCompatActivity {
ConexionSQLiteHelper conn;
EditText editisss;
EditText editnombre;
EditText editApellido;
EditText editcontra;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_maestro_actualizar);
        conn = new ConexionSQLiteHelper(this);
        editisss = (EditText) findViewById(R.id.editisss);
        editnombre = (EditText) findViewById(R.id.editNombre);
        editApellido = (EditText) findViewById(R.id.editApellido);
        editcontra = (EditText) findViewById(R.id.editContraseña);



        Bundle listav=this.getIntent().getExtras();
        String nombre= listav.getString("idisss");
        editisss.setText(nombre);

    }

    public void editdocente(View view) {
        Docente docente = new Docente(null,null,null,null);
        docente.setIsss(editisss.getText().toString());
        docente.setNom_doce(editnombre.getText().toString());
        docente.setApe_doce(editApellido.getText().toString());
        docente.setContra_doce(editcontra.getText().toString());

      //  String estado = conn.actualizar(docente);
        //conn.cerrar()
    }
}
