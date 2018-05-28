package com.ajla.app_asistencia;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Admin_Materias_Menu extends AppCompatActivity {
    ConexionSQLiteHelper conec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__materias__menu);
        conec= new ConexionSQLiteHelper(getApplicationContext());
    }

    public void matmenu(View view) {
        //Intent MMenuBoton = null;
        switch (view.getId()){

            case R.id.btnOfertaCiclo:
                AlertDialog.Builder DialogoAlerta = new AlertDialog.Builder(this);
                DialogoAlerta.setTitle("APERTURA DE NUEVO CICLO");
                DialogoAlerta.setMessage("¿Realmente desea iniciar un nuevo ciclo?");
                DialogoAlerta.setCancelable(false);
                DialogoAlerta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {


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
                break;
            case R.id.btnCatalogoMaterias:
          Intent MMenuBoton= new Intent(Admin_Materias_Menu.this,AdminMateriasCatalogoActivity.class);
          startActivity(MMenuBoton);
          break;
        }

    }

    private void aceptar() {
        SQLiteDatabase db=conec.getWritableDatabase();
        db.execSQL("UPDATE ciclo set estado_ciclo = '0' where estado2 == '1'");
        db.execSQL("INSERT INTO ciclo values ('1', ?,'1')");
        Intent MMenu = new Intent(Admin_Materias_Menu.this,Admin_Menu_Oferta_Ciclo.class);
        startActivity(MMenu);


    }

    private void cancelar() {
        closeContextMenu();
    }
}
