package com.ajla.app_asistencia;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    ConexionSQLiteHelper BDHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BDHelper= new ConexionSQLiteHelper(this);
        BDHelper.cerrar();
    }

}
