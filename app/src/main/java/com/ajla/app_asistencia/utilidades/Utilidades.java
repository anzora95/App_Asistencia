package com.ajla.app_asistencia.utilidades;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Utilidades {

    //Constantes campos tabla Alumno
    public static final String TABLA_ALUMNO = "alumno";
    public static final String CAMPO_CARNET = "carnet";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_APELLIDO = "apellido";

    public static final String CREAR_TABLA_ALUMNO ="CREATE TABLE "+TABLA_ALUMNO+" ("+CAMPO_CARNET+" Character,"+CAMPO_NOMBRE+" Variable characters, "+CAMPO_APELLIDO+" Variable characters)";
}
