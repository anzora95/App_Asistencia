package com.ajla.app_asistencia.utilidades;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Utilidades {

    //Constantes campos tabla Alumno
   /* public static final String TABLA_ALUMNO = "alumno";
    public static final String CAMPO_CARNET = "carnet";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_APELLIDO = "apellido";
    public static final String CAMPO_CONTRA_ALUMNO="contraseña_alumno";

    public static final String CREAR_TABLA_ALUMNO ="CREATE TABLE "+TABLA_ALUMNO+"("+CAMPO_CARNET+" CHAR(7) PRIMARY KEY,"+CAMPO_NOMBRE+" VARCHAR(40) NOT NULL, "+CAMPO_APELLIDO+" VARCHAR(40) NOT NULL, "+CAMPO_CONTRA_ALUMNO+" VARCHAR(10) NOT NULL);";

  //Constantes campos tabla Administrador
    public static final String TABLA_ADMINISTRADOR="administrador";
    public static final String CAMPO_USUARIO="usuario";
    public static final String CAMPO_CONTRA_ADMIN="contraseña_admin";

    public static final String CREAR_TABLA_ADMINISTRADOR ="CREATE TABLE "+TABLA_ADMINISTRADOR+" ("+CAMPO_USUARIO+" CHAR(7) PRIMARY KEY,"+CAMPO_CONTRA_ADMIN+" VARCHAR(10) NOT NULL);";

    //Constantes campos tabla Area
    public static final String TABLA_AREA="area";
    public static final String CAMPO_COD_AREA="cod_area";
    public static final String CAMPO_NOM_AREA="nombre_area";

    public static final String CREAR_TABLA_AREA ="CREATE TABLE "+TABLA_AREA+" ("+CAMPO_COD_AREA+" CHAR(8) PRIMARY KEY,"+CAMPO_NOM_AREA+" VARCHAR(40) NOT NULL);";


    //Constantes campos tabla Ciclo
    public static final String TABLA_CICLO="ciclo";
    public static final String CAMPO_ESTADO="estado_ciclo";
    public static final String CAMPO_CICLO_ANIO="ciclo_anio";

    public static final String CREAR_TABLA_CICLO ="CREATE TABLE "+TABLA_CICLO+" ("+CAMPO_ESTADO+" VARCHAR(1) NOT NULL,"+CAMPO_CICLO_ANIO+" VARCHAR(6)PRIMARY KEY);";


    //Constantes campos tabla Docente
    public static final String TABLA_DOCENTE="docente";
    public static final String CAMPO_ISSS="isss_docente";
    public static final String CAMPO_NOM_DOCE="nombre_docente";
    public static final String CAMPO_APE_DOCE="apellido_docente";
    public static final String CAMPO_CONTRA_DOCE="contraseña_docente";

    public static final String CREAR_TABLA_DOCENTE ="CREATE TABLE "+TABLA_DOCENTE+" ("+CAMPO_ISSS+" CHAR(9) PRIMARY KEY,"+CAMPO_NOM_DOCE+" VARCHAR(40) NOT NULL,"+CAMPO_APE_DOCE+" VARCHAR(40) NOT NULL,"+CAMPO_CONTRA_DOCE+" INTEGER NOT NULL);";

    //Constantes campos tabla Inscripcion teorico
    public static final String TABLA_INSCRIPCION_TEO="inscripcion_teorico";
    public static final String CAMPO_ID_INSTEO="id_inscripcion_teorico";
    public static final String CAMPO_CARNET_INS_TEO=CAMPO_CARNET;

    public static final String CREAR_TABLA_INSCRIPCION_TEO ="CREATE TABLE "+TABLA_INSCRIPCION_TEO+" ("+CAMPO_ID_INSTEO+" INTEGER PRIMARY KEY AUTOINCREMENT,"+CAMPO_CARNET_INS_TEO+" CHAR(7) NOT NULL);";

    //Constantes campos tabla Inscripcion laboratorio
    public static final String TABLA_INSCRIPCION_LAB="inscripcion_teorico";
    public static final String CAMPO_ID_INSLAB="id_inscripcion_teorico";
    public static final String CAMPO_CARNET_INS_LAB=CAMPO_CARNET;

    public static final String CREAR_TABLA_INSCRIPCION_LAB ="CREATE TABLE "+TABLA_INSCRIPCION_LAB+" ("+CAMPO_ID_INSLAB+" INTEGER PRIMARY KEY AUTOINCREMENT,"+CAMPO_CARNET_INS_LAB+" CHAR(7) NOT NULL);";


    //Constantes campos tabla jefe departamento
    public static final String TABLA_JEFE_DEPARTAMENTO="jefe_departamento";
    public static final String CAMPO_COD_AREA_JEFE=CAMPO_COD_AREA; //FALTA PADRE
    public static final String CAMPO_ISSS_JEFE=CAMPO_ISSS; //FALTA PADRE
    public static final String CAMPO_PERIODO="periodo";
    public static final String CAMPO_CONTRA_JEFE="contraseña_jefe";

    public static final String CREAR_TABLA_JEFE_DEPARTAMENTO ="CREATE TABLE "+TABLA_JEFE_DEPARTAMENTO+" ("+CAMPO_COD_AREA_JEFE+" CHAR(8) NOT NULL,"+CAMPO_ISSS_JEFE+" CHAR(9) PRIMARY KEY,"+CAMPO_PERIODO+" CHAR(7) PRIMARY KEY,"+CAMPO_CONTRA_JEFE+" VARCHAR(10) NOT NULL);";


    //Constantes campos tabla lugar
    public static final String TABLA_LUGAR="lugar";
    public static final String CAMPO_COD_LUGAR="codigo_lugar";
    public static final String CAMPO_CAPACIDAD="capacidad";
    public static final String CAMPO_TIPO="tipo";

    public static final String CREAR_TABLA_LUGAR ="CREATE TABLE "+TABLA_LUGAR+" ("+CAMPO_COD_LUGAR+" VARCHAR(5) PRIMARY KEY,"+CAMPO_CAPACIDAD+" INTEGER NOT NULL,"+CAMPO_TIPO+" CHAR(1) NOT NULL);";

    //Constantes campos tabla materia
    public static final String TABLA_MATERIA="materia";
    public static final String CAMPO_COD_MATERIA="codigo_materia";
    public static final String CAMPO_COD_AREA_MATE=CAMPO_COD_AREA; //FALTA PADRE
    public static final String CAMPO_NOM_MATERIA="nombre_materia";

    public static final String CREAR_TABLA_MATERIA ="CREATE TABLE "+TABLA_MATERIA+" ("+CAMPO_COD_MATERIA+" CHAR(6) PRIMARY KEY,"+CAMPO_COD_AREA_MATE+" CHAR(8) NOT NULL,"+CAMPO_NOM_MATERIA+" VARCHAR(40) NOT NULL);";

    //Constantes campos tabla oferta materia
    public static final String TABLA_OFERTA_MATE="oferta_materia";
    public static final String CAMPO_COD_OFER_MATE="codigo_oferta_materia";
    public static final String CAMPO_COD_MATERIA_OFERMA=CAMPO_COD_MATERIA;//FALTA PADRE
    public static final String CAMPO_ISSS_OFERMA=CAMPO_ISSS;
    public static final String CAMPO_CICLO_ANIO_OFERMA=CAMPO_CICLO_ANIO; //FALTA PADRE

    public static final String CREAR_TABLA_OFERTA_MATE ="CREATE TABLE "+TABLA_OFERTA_MATE+" ("+CAMPO_COD_OFER_MATE+" INTEGER PRIMARY KEY AUTOINCREMENT,"+CAMPO_COD_MATERIA_OFERMA+" CHAR(6) NOT NULL,"+CAMPO_ISSS_OFERMA+" CHAR(9) NOT NULL,"+CAMPO_CICLO_ANIO_OFERMA+" VARCHAR(6) NOT NULL);";


    //Constantes campos tabla oferta laboratorio
    public static final String TABLA_OFERTA_LAB="oferta_laboratorio";
    public static final String CAMPO_ID_OFER_LAB="id_oferta_lab";
    public static final String CAMPO_COD_LUGAR_OFERLAB=CAMPO_COD_LUGAR;//FALTA PADRE
    public static final String CAMPO_COD_OFER_MATE_OFERLAB=CAMPO_COD_OFER_MATE; //FALTA PADRE
    public static final String CAMPO_ISSS_OFERLAB=CAMPO_ISSS;
    public static final String CAMPO_NUM_GRUPO_LAB="numero_grupos_laboratorio";

    public static final String CREAR_TABLA_OFERTA_LAB ="CREATE TABLE "+TABLA_OFERTA_LAB+" ("+CAMPO_ID_OFER_LAB+" INTEGER PRIMARY KEY AUTOINCREMENT,"+CAMPO_COD_LUGAR_OFERLAB+" VARCHAR(5) NOT NULL,"+CAMPO_COD_OFER_MATE_OFERLAB+" INTEGER NOT NULL,"+CAMPO_ISSS_OFERLAB+" CHAR(9) NOT NULL,"+CAMPO_NUM_GRUPO_LAB+" CHAR(2) NOT NULL);";

    //Constantes campos tabla Asistencia laboratorio
    public static final String TABLA_ASIS_LAB="asistencia_laboratorio";
    public static final String CAMPO_FECHA_LAB="fecha_laboratorio";
    public static final String CAMPO_ID_OFER_LAB_ASISLAB=CAMPO_ID_OFER_LAB; //FALTA PADRE

    public static final String CREAR_TABLA_ASIS_LAB ="CREATE TABLE "+TABLA_ASIS_LAB+" ("+CAMPO_FECHA_LAB+" DATE PRIMARY KEY,"+CAMPO_ID_OFER_LAB_ASISLAB+" INTEGER NOT NULL);";

    //Constantes campos tabla Control labotatorio
    public static final String TABLA_CONTROL_LAB="control_laboratorio";
    public static final String CAMPO_FECHA_LAB_CONTROL=CAMPO_FECHA_LAB; //FALTA PADRE
    public static final String CAMPO_ID_INSLAB_CONTROL=CAMPO_ID_INSLAB; //FALTA PADRE
    public static final String CAMPO_ASITENCIA_LAB="asistencia_exam";

    public static final String CREAR_TABLA_CONTROL_LAB ="CREATE TABLE "+TABLA_CONTROL_LAB+" ("+CAMPO_FECHA_LAB_CONTROL+" DATE PRIMARY KEY,"+CAMPO_ID_INSLAB_CONTROL+" INTEGER PRIMARY KEY NOT NULL,"+CAMPO_ASITENCIA_LAB+" CHAR(1) NOT NULL);";

    //Constantes campos tabla Asistencia examen
    public static final String TABLA_ASIS_EXAM="asistencia_examen";
    public static final String CAMPO_FECHA_EXAM="fecha_examen";
    public static final String CAMPO_COD_OFER_MATE_ASISEXA=CAMPO_COD_OFER_MATE; //FALTA PADRE
    public static final String CAMPO_COD_EVA="codigo_evaluacion";

    public static final String CREAR_TABLA_ASIS_EXAM ="CREATE TABLE "+TABLA_ASIS_EXAM+" ("+CAMPO_FECHA_EXAM+" DATE PRIMARY KEY,"+CAMPO_COD_OFER_MATE_ASISEXA+" INTEGER NOT NULL,"+CAMPO_COD_EVA+",VARCHAR(6) NOT NULL);";


    //Constantes campos tabla Control examen
    public static final String TABLA_CONTROL_EXAM="control_examen";
    public static final String CAMPO_FECHA_EXAM_CONTROL = CAMPO_FECHA_EXAM;
    public static final String CAMPO_CARNET_CONTROL_EXAM=CAMPO_CARNET;
    public static final String CAMPO_ASISTENCIA_EXAM="asistencia_exam";

    public static final String CREAR_TABLA_CONTROL_EXAM ="CREATE TABLE "+TABLA_CONTROL_EXAM+" ("+CAMPO_FECHA_EXAM_CONTROL+" DATE PRIMARY KEY,"+CAMPO_CARNET_CONTROL_EXAM+" CHAR(7) NOT NULL,"+CAMPO_ASISTENCIA_EXAM+" CHAR(1) NOT NULL);";


    //Constantes campos tabla oferta teorico
    public static final String TABLA_OFERTA_TEO="oferta_teorico";
    public static final String CAMPO_ID_OFER_TEO="id_oferta_teo";
    public static final String CAMPO_COD_LUGAR_OFERTEO=CAMPO_COD_LUGAR;//FALTA PADRE
    public static final String CAMPO_COD_OFER_MATE_OFERTEO=CAMPO_COD_OFER_MATE; //FALTA PADRE
    public static final String CAMPO_ISSS_OFERTEO=CAMPO_ISSS;
    public static final String CAMPO_NUM_GRUPO_TEO="numero_grupos_teoricos";

    public static final String CREAR_TABLA_OFERTA_TEO ="CREATE TABLE "+TABLA_OFERTA_TEO+" ("+CAMPO_ID_OFER_TEO+" INTEGER PRIMARY KEY AUTOINCREMENT,"+CAMPO_COD_LUGAR_OFERTEO+" VARCHAR(5) NOT NULL,"+CAMPO_COD_OFER_MATE_OFERTEO+" INTEGER NOT NULL,"+CAMPO_ISSS_OFERTEO+" CHAR(9) NOT NULL,"+CAMPO_NUM_GRUPO_TEO+" CHAR(2) NOT NULL);";

    //Constantes campos tabla Asistencia teoricos
    public static final String TABLA_ASIS_TEO="asistencia_teorico";
    public static final String CAMPO_FECHA_TEO="fecha_teorico";
    public static final String CAMPO_ID_OFER_TEO_ASISTEO=CAMPO_ID_OFER_TEO; //FALTA PADRE

    public static final String CREAR_TABLA_ASIS_TEO ="CREATE TABLE "+TABLA_ASIS_TEO+" ("+CAMPO_FECHA_TEO+" DATE PRIMARY KEY NOT NULL,"+CAMPO_ID_OFER_TEO_ASISTEO+" INTEGER NOT NULL);";


    //Constantes campos tabla Control teorico
    public static final String TABLA_CONTROL_TEO="control_teorico";
    public static final String CAMPO_FECHA_TEO_CONTROL=CAMPO_FECHA_TEO; //FALTA PADRE
    public static final String CAMPO_ID_INSTEO_CONTROL=CAMPO_ID_INSTEO; //FALTA PADRE
    public static final String CAMPO_ASITENCIA_TEO="asistencia_exam";

    public static final String CREAR_TABLA_CONTROL_TEO ="CREATE TABLE "+TABLA_CONTROL_TEO+" ("+CAMPO_FECHA_TEO_CONTROL+" DATE PRIMARY KEY,"+CAMPO_ID_INSTEO_CONTROL+" INTEGER PRIMARY KEY,"+CAMPO_ASITENCIA_TEO+" CHAR(1) NOT NULL);";
*/
    //Constantes campos tabla OpcionCRUD
    public static final String TABLA_OPCIONCRUD="opcionCrud";
    public static final String CAMPO_IDOPCION="idOpcion";
    public static final String CAMPO_DESOPCION="descripcionOpcion";
    public static final String CAMPO_NUMCRUD="numreoCrud";

    public static final String CREAR_TABLA_OPCIONCRUD ="CREATE TABLE "+TABLA_OPCIONCRUD+" ("+CAMPO_IDOPCION+" INTEGER PRIMARY KEY AUTOINCREMENT,"+CAMPO_DESOPCION+" VARCHAR(30) NOT NULL,"+CAMPO_NUMCRUD+" INTEGER NOT NULL);";
/*
    //Constantes campos tabla Solicitud Diferido
    public static final String TABLA_SOLICITUD_DIFERIDO="solicitud_diferido";
    public static final String CAMPO_ID_SOLICITUD="id_solicitud";
    public static final String CAMPO_CARNET_SOLDI=CAMPO_ISSS;//FALTA PADRE
    public static final String CAMPO_ISSS_SOLDI=CAMPO_PERIODO;//FALTA PADRE
    public static final String CAMPO_PERIODO_SOLDI=CAMPO_CARNET;//FALTA PADRE
    public static final String CAMPO_FECHA_EXAM_SOLDI=CAMPO_FECHA_EXAM;//FALTA PADRE
    public static final String CAMPO_ESTADODIFE="estado_soliDiferido";

    public static final String CREAR_TABLA_SOLICITUD_DIFERIDO ="CREATE TABLE "+TABLA_SOLICITUD_DIFERIDO+" ("+CAMPO_ID_SOLICITUD+" INTEGER PRIMARY KEY AUTOINCREMENT,"+CAMPO_CARNET_SOLDI+" CHAR(7) NOT NULL,"+CAMPO_ISSS_SOLDI+" CHAR(9) NOT NULL,"+CAMPO_PERIODO_SOLDI+" CHAR(7) NOT NULL,"+CAMPO_FECHA_EXAM_SOLDI+" DATE NOT NULL,"+CAMPO_ESTADODIFE+" VARCHAR(1) NOT NULL);";
*/
    //Constantes campos tabla usuario
    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_IDUSUARIO="idUsuario";
    public static final String CAMPO_NOMUSUARIO="nombreUsuario";
    public static final String CAMPO_CLAVE="clave";

    public static final String CREAR_TABLA_USUARIO ="CREATE TABLE "+TABLA_USUARIO+
            " ("+CAMPO_IDUSUARIO+" INTEGER PRIMARY KEY AUTOINCREMENT,"+CAMPO_NOMUSUARIO+
            " VARCHAR(30) NOT NULL,"+CAMPO_CLAVE+" CHAR(5) NOT NULL);";

    //Constastes campos tabla AccesoUsuario
    public static final String TABLA_ACESSOUSUARIO ="acceso_usuario";
    public static final String CAMPO_IDUSUARIO_ACCESO =CAMPO_IDUSUARIO;//FALTA PADRE
    public static final String CAMPO_IDOPCION_ACCESO =CAMPO_IDOPCION; //FALTA PADRE

    public static final String CREAR_TABLA_ACESSOUSUARIO ="CREATE TABLE "+TABLA_ACESSOUSUARIO+
            " ("+CAMPO_IDUSUARIO_ACCESO+" CHAR(3),"+CAMPO_IDOPCION_ACCESO+
            " CHAR(30) primary key ("+CAMPO_IDUSUARIO_ACCESO+", "+CAMPO_IDOPCION_ACCESO+")," +
            "constraint fK_IDOPCION foreign key ("+CAMPO_IDOPCION_ACCESO+")" + "references " +
            ""+TABLA_OPCIONCRUD+" ("+CAMPO_IDOPCION+"),constraint fK_IDUSUARIO foreign key " +
            "("+CAMPO_IDUSUARIO_ACCESO+")" + "references "+TABLA_USUARIO+" ("+CAMPO_IDUSUARIO+"));";

}
