package com.ajla.app_asistencia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MateriasIngresarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materias_ingresar);
    }

    public void guardar(View view) {
        Toast.makeText(MateriasIngresarActivity.this,"Guardado con exito",Toast.LENGTH_SHORT).show();
    //    Intent guardar= null;
      //  switch (view.getId()){
        //    case R.id.btnguardar:
          //      guardar=new Intent()
        //}

    }
}
