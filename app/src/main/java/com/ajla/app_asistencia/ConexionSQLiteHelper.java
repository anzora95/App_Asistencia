package com.ajla.app_asistencia;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ajla.app_asistencia.utilidades.Utilidades;


public class ConexionSQLiteHelper extends SQLiteOpenHelper{


    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Utilidades.CREAR_TABLA_ALUMNO);
        db.execSQL(Utilidades.CREAR_TABLA_ACESSOUSUARIO);
        db.execSQL(Utilidades.CREAR_TABLA_ADMINISTRADOR);
        db.execSQL(Utilidades.CREAR_TABLA_AREA);
        db.execSQL(Utilidades.CREAR_TABLA_ASIS_EXAM);
        db.execSQL(Utilidades.CREAR_TABLA_ASIS_LAB);
        db.execSQL(Utilidades.CREAR_TABLA_ASIS_TEO);
        db.execSQL(Utilidades.CREAR_TABLA_CICLO);
        db.execSQL(Utilidades.CREAR_TABLA_CONTROL_EXAM);
        db.execSQL(Utilidades.CREAR_TABLA_CONTROL_LAB);
        db.execSQL(Utilidades.CREAR_TABLA_CONTROL_TEO);
        db.execSQL(Utilidades.CREAR_TABLA_DOCENTE);
        db.execSQL(Utilidades.CREAR_TABLA_INSCRIPCION_LAB);
        db.execSQL(Utilidades.CREAR_TABLA_INSCRIPCION_TEO);
        db.execSQL(Utilidades.CREAR_TABLA_JEFE_DEPARTAMENTO);
        db.execSQL(Utilidades.CREAR_TABLA_LUGAR);
        db.execSQL(Utilidades.CREAR_TABLA_MATERIA);
        db.execSQL(Utilidades.CREAR_TABLA_OFERTA_LAB);
        db.execSQL(Utilidades.CREAR_TABLA_OFERTA_MATE);
        db.execSQL(Utilidades.CREAR_TABLA_OFERTA_TEO);
        db.execSQL(Utilidades.CREAR_TABLA_OPCIONCRUD);
        db.execSQL(Utilidades.CREAR_TABLA_SOLICITUD_DIFERIDO);
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ALUMNO);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ACESSOUSUARIO);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ADMINISTRADOR);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_USUARIO);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_OPCIONCRUD);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_SOLICITUD_DIFERIDO);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_OFERTA_TEO);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_OFERTA_LAB);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_JEFE_DEPARTAMENTO);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_DOCENTE);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CONTROL_EXAM);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CICLO);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ASIS_TEO);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ASIS_LAB);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ASIS_EXAM);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CONTROL_LAB);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CONTROL_TEO);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_OFERTA_MATE);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_MATERIA);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_AREA);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_INSCRIPCION_LAB);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_INSCRIPCION_TEO);
       db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_LUGAR);

       onCreate(db);
    }
}
