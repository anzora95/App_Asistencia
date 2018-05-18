package com.ajla.app_asistencia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;


public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    public static abstract class DatosTabla implements BaseColumns {
        //para alumno
        public static final String TABLA_ALUMNO = "alumno";
        public static final String CAMPO_CARNET = "carnet";
        public static final String CAMPO_NOMBRE = "nom_alum";
        public static final String CAMPO_APELLIDO = "apel_alum";
        public static final String CAMPO_CONTRA_ALUMNO= "contra_alum";

        //Constantes campos tabla Administrador
        public static final String TABLA_ADMINISTRADOR="administrador";
        public static final String CAMPO_USUARIO="usuario";
        public static final String CAMPO_CONTRA_ADMIN="contra_admin";

        //Constantes campos tabla Area
        public static final String TABLA_AREA="area";
        public static final String CAMPO_COD_AREA="cod_area";
        public static final String CAMPO_NOM_AREA="nom_area";

        //Constantes campos tabla Ciclo
        public static final String TABLA_CICLO="ciclo";
        public static final String CAMPO_ESTADO="estado_ciclo";
        public static final String CAMPO_CICLO_ANIO="ciclo_anio";

        //Constantes campos tabla Docente
        public static final String TABLA_DOCENTE="docente";
        public static final String CAMPO_ISSS="isss";
        public static final String CAMPO_NOM_DOCE="nom_doce";
        public static final String CAMPO_APE_DOCE="apel_doce";
        public static final String CAMPO_CONTRA_DOCE="contra_doce";

        //Constantes campos tabla Inscripcion teorico
        public static final String TABLA_INSCRIPCION_TEO="inscripcion_teo";
        public static final String CAMPO_ID_INSTEO="id_insTeo";
        public static final String CAMPO_CARNET_INS_TEO=CAMPO_CARNET;

        //Constantes campos tabla Inscripcion laboratorio
        public static final String TABLA_INSCRIPCION_LAB="inscripcion_lab";
        public static final String CAMPO_ID_INSLAB="id_insLab";
        public static final String CAMPO_CARNET_INS_LAB=CAMPO_CARNET;

        //Constantes campos tabla jefe departamento
        public static final String TABLA_JEFE_DEPARTAMENTO="jefe_departamento";
        public static final String CAMPO_COD_AREA_JEFE=CAMPO_COD_AREA; //FALTA PADRE
        public static final String CAMPO_ISSS_JEFE=CAMPO_ISSS; //FALTA PADRE
        public static final String CAMPO_PERIODO="periodo";
        public static final String CAMPO_CONTRA_JEFE="contra_jefe";

        //Constantes campos tabla lugar
        public static final String TABLA_LUGAR="lugar";
        public static final String CAMPO_COD_LUGAR="cod_lugar";
        public static final String CAMPO_CAPACIDAD="capacidad";
        public static final String CAMPO_TIPO="tipo";

        //Constantes campos tabla materia
        public static final String TABLA_MATERIA="materia";
        public static final String CAMPO_COD_MATERIA="cod_materia";
        public static final String CAMPO_COD_AREA_MATE=CAMPO_COD_AREA; //FALTA PADRE
        public static final String CAMPO_NOM_MATERIA="nom_materia";

        //Constantes campos tabla oferta materia
        public static final String TABLA_OFERTA_MATE="oferta_materia";
        public static final String CAMPO_COD_OFER_MATE="cod_ofer_mate";
        public static final String CAMPO_COD_MATERIA_OFERMA=CAMPO_COD_MATERIA;//FALTA PADRE
        public static final String CAMPO_ISSS_OFERMA=CAMPO_ISSS;
        public static final String CAMPO_CICLO_ANIO_OFERMA=CAMPO_CICLO_ANIO; //FALTA PADRE

        //Constantes campos tabla oferta laboratorio
        public static final String TABLA_OFERTA_LAB="oferta_lab";
        public static final String CAMPO_ID_OFER_LAB="id_ofer_lab";
        public static final String CAMPO_COD_LUGAR_OFERLAB=CAMPO_COD_LUGAR;//FALTA PADRE
        public static final String CAMPO_COD_OFER_MATE_OFERLAB=CAMPO_COD_OFER_MATE; //FALTA PADRE
        public static final String CAMPO_ISSS_OFERLAB=CAMPO_ISSS;
        public static final String CAMPO_NUM_GRUPO_LAB="num_grup_lab";

        //Constantes campos tabla oferta teorico
        public static final String TABLA_OFERTA_TEO="oferta_teo";
        public static final String CAMPO_ID_OFER_TEO="id_ofer_teo";
        public static final String CAMPO_COD_LUGAR_OFERTEO=CAMPO_COD_LUGAR;//FALTA PADRE
        public static final String CAMPO_COD_OFER_MATE_OFERTEO=CAMPO_COD_OFER_MATE; //FALTA PADRE
        public static final String CAMPO_ISSS_OFERTEO=CAMPO_ISSS;
        public static final String CAMPO_NUM_GRUPO_TEO="num_grup_teo";

        //Constantes campos tabla Asistencia laboratorio
        public static final String TABLA_ASIS_LAB="asis_lab";
        public static final String CAMPO_FECHA_LAB="fecha_lab";
        public static final String CAMPO_ID_OFER_LAB_ASISLAB=CAMPO_ID_OFER_LAB; //FALTA PADRE

        //Constantes campos tabla Control labotatorio
        public static final String TABLA_CONTROL_LAB="control_lab";
        public static final String CAMPO_FECHA_LAB_CONTROL=CAMPO_FECHA_LAB; //FALTA PADRE
        public static final String CAMPO_ID_INSLAB_CONTROL=CAMPO_ID_INSLAB; //FALTA PADRE
        public static final String CAMPO_ASITENCIA_LAB="asistencia_lab";


        //Constantes campos tabla Asistencia teoricos
        public static final String TABLA_ASIS_TEO="asis_teo";
        public static final String CAMPO_FECHA_TEO="fecha_teo";
        public static final String CAMPO_ID_OFER_TEO_ASISTEO=CAMPO_ID_OFER_TEO; //FALTA PADRE

        //Constantes campos tabla Control teorico
        public static final String TABLA_CONTROL_TEO="control_teo";
        public static final String CAMPO_FECHA_TEO_CONTROL=CAMPO_FECHA_TEO; //FALTA PADRE
        public static final String CAMPO_ID_INSTEO_CONTROL=CAMPO_ID_INSTEO; //FALTA PADRE
        public static final String CAMPO_ASITENCIA_TEO="asistencia_teo";

        //Constantes campos tabla Asistencia examen
        public static final String TABLA_ASIS_EXAM="asis_exam";
        public static final String CAMPO_FECHA_EXAM="fecha_exam";
        public static final String CAMPO_COD_OFER_MATE_ASISEXA=CAMPO_COD_OFER_MATE; //FALTA PADRE
        public static final String CAMPO_COD_EVA="codigo_evaluacion";

        //Constantes campos tabla Control examen
        public static final String TABLA_CONTROL_EXAM="control_exam";
        public static final String CAMPO_FECHA_EXAM_CONTROL = CAMPO_FECHA_EXAM;
        public static final String CAMPO_CARNET_CONTROL_EXAM=CAMPO_CARNET;
        public static final String CAMPO_ASISTENCIA_EXAM="asistencia_exam";

        //Constantes campos tabla Solicitud Diferido
        public static final String TABLA_SOLICITUD_DIFERIDO="solicitud_diferido";
        public static final String CAMPO_ID_SOLICITUD="id_solicitud";
        public static final String CAMPO_CARNET_SOLDI=CAMPO_ISSS;//FALTA PADRE
        public static final String CAMPO_ISSS_SOLDI=CAMPO_PERIODO;//FALTA PADRE
        public static final String CAMPO_PERIODO_SOLDI=CAMPO_CARNET;//FALTA PADRE
        public static final String CAMPO_FECHA_EXAM_SOLDI=CAMPO_FECHA_EXAM;//FALTA PADRE
        public static final String CAMPO_ESTADODIFE="estado";

        //Constantes campos tabla OpcionCRUD
        public static final String TABLA_OPCIONCRUD="opcionCrud";
        public static final String CAMPO_IDOPCION="idOpcion";
        public static final String CAMPO_DESOPCION="descripcionOpcion";
        public static final String CAMPO_NUMCRUD="numreoCrud";

        //Constantes campos tabla usuario
        public static final String TABLA_USUARIO="usuario";
        public static final String CAMPO_IDUSUARIO="idUsuario";
        public static final String CAMPO_NOMUSUARIO="nombreUsuario";
        public static final String CAMPO_CLAVE="clave";

        //Constastes campos tabla AccesoUsuario
        public static final String TABLA_ACESSOUSUARIO ="acceso_usuario";
        public static final String CAMPO_IDUSUARIO_ACCESO =CAMPO_IDUSUARIO;//FALTA PADRE
        public static final String CAMPO_IDOPCION_ACCESO =CAMPO_IDOPCION; //FALTA PADRE











        //Creaciom
        private static final String CREAR_TABLA_ADMINISTRADOR ="CREATE TABLE "+DatosTabla.TABLA_ADMINISTRADOR+" ("+DatosTabla.CAMPO_USUARIO+" Varchar (7) NOT NULL PRIMARY KEY,"+DatosTabla.CAMPO_CONTRA_ADMIN+" VARCHAR(10) NOT NULL)";
        private static final String CREAR_TABLA_ALUMNO ="CREATE TABLE "+DatosTabla.TABLA_ALUMNO+" ("+DatosTabla.CAMPO_CARNET+" Varchar(7) NOT NULL PRIMARY KEY,"+DatosTabla.CAMPO_NOMBRE+" Varchar(30) NOT NULL, "+DatosTabla.CAMPO_APELLIDO+" Varchar(30) NOT NULL,"+DatosTabla.CAMPO_CONTRA_ALUMNO+" Varchar(10) NOT NULL)";
        private static final String CREAR_TABLA_AREA ="CREATE TABLE "+DatosTabla.TABLA_AREA+" ("+DatosTabla.CAMPO_COD_AREA+" Varchar(8) NOT NULL PRIMARY KEY,"+DatosTabla.CAMPO_NOM_AREA+" VARCHAR(40) NOT NULL)";
        private static final String CREAR_TABLA_CICLO ="CREATE TABLE "+DatosTabla.TABLA_CICLO+" ("+DatosTabla.CAMPO_ESTADO+" VARCHAR(1) NOT NULL,"+DatosTabla.CAMPO_CICLO_ANIO+" VARCHAR(6) PRIMARY KEY)";
        private static final String CREAR_TABLA_DOCENTE ="CREATE TABLE "+DatosTabla.TABLA_DOCENTE+" ("+DatosTabla.CAMPO_ISSS+" CHAR(9) NOT NULL PRIMARY KEY,"+DatosTabla.CAMPO_NOM_DOCE+" VARCHAR(40) NOT NULL,"+DatosTabla.CAMPO_APE_DOCE+" VARCHAR(40) NOT NULL,"+DatosTabla.CAMPO_CONTRA_DOCE+" Varchar(10) NOT NULL)";
        private static final String CREAR_TABLA_INSCRIPCION_TEO ="CREATE TABLE "+DatosTabla.TABLA_INSCRIPCION_TEO+" ("+DatosTabla.CAMPO_ID_INSTEO+" INTEGER PRIMARY KEY AUTOINCREMENT,"+DatosTabla.CAMPO_CARNET_INS_TEO+" Varchar (7) NOT NULL,"+ "CONSTRAINT fk_inscripcion_teo FOREIGN KEY (carnet) REFERENCES alumno (carnet))";
        private static final String CREAR_TABLA_INSCRIPCION_LAB ="CREATE TABLE "+DatosTabla.TABLA_INSCRIPCION_LAB+" ("+DatosTabla.CAMPO_ID_INSLAB+" INTEGER PRIMARY KEY AUTOINCREMENT,"+DatosTabla.CAMPO_CARNET_INS_LAB+" Varchar (7) NOT NULL,"+ "CONSTRAINT fk_inscripcion_lab FOREIGN KEY (carnet) REFERENCES alumno (carnet))";
        private static final String CREAR_TABLA_JEFE_DEPARTAMENTO ="CREATE TABLE "+DatosTabla.TABLA_JEFE_DEPARTAMENTO+" ("+ DatosTabla.CAMPO_COD_AREA_JEFE+" CHAR(8) NOT NULL,"+DatosTabla.CAMPO_ISSS_JEFE+" CHAR(9),"+DatosTabla.CAMPO_PERIODO+" CHAR(7),"+CAMPO_CONTRA_JEFE+" VARCHAR(10) NOT NULL,"+" PRIMARY KEY (isss, periodo),"+"CONSTRAINT fk_jefe_unidad FOREIGN KEY (isss) REFERENCES jefe_departamento(isss), "+ "CONSTRAINT fk_jefe_unidad_v2 FOREIGN KEY (cod_area) REFERENCES area(cod_area))";
        private static final String CREAR_TABLA_LUGAR ="CREATE TABLE "+DatosTabla.TABLA_LUGAR+" ("+DatosTabla.CAMPO_COD_LUGAR+" VARCHAR(5) PRIMARY KEY,"+DatosTabla.CAMPO_CAPACIDAD+" INTEGER NOT NULL,"+DatosTabla.CAMPO_TIPO+" CHAR(1) NOT NULL)";
        private static final String CREAR_TABLA_MATERIA ="CREATE TABLE "+DatosTabla.TABLA_MATERIA+" ("+DatosTabla.CAMPO_COD_MATERIA+" CHAR(6) PRIMARY KEY,"+DatosTabla.CAMPO_COD_AREA_MATE+" CHAR(8) NOT NULL,"+CAMPO_NOM_MATERIA+" VARCHAR(40) NOT NULL,"+"CONSTRAINT fk_materia FOREIGN KEY (cod_area) REFERENCES area(cod_area))";
        private static final String CREAR_TABLA_OFERTA_MATE ="CREATE TABLE "+DatosTabla.TABLA_OFERTA_MATE+" ("+DatosTabla.CAMPO_COD_OFER_MATE+" INTEGER PRIMARY KEY AUTOINCREMENT,"+CAMPO_COD_MATERIA_OFERMA+" CHAR(6) NOT NULL,"+CAMPO_ISSS_OFERMA+" CHAR(9) NOT NULL,"+CAMPO_CICLO_ANIO_OFERMA+" VARCHAR(6) NOT NULL,"+"CONSTRAINT fk_Materia_v FOREIGN KEY (cod_materia) REFERENCES materia(cod_materia),"+"CONSTRAINT fk_Materia_v1 FOREIGN KEY (isss) REFERENCES docente(isss),"+"CONSTRAINT fk_Materia_v2 FOREIGN KEY (ciclo_anio) REFERENCES ciclo(ciclo_anio))";
        private static final String CREAR_TABLA_OFERTA_LAB ="CREATE TABLE "+DatosTabla.TABLA_OFERTA_LAB+" ("+DatosTabla.CAMPO_ID_OFER_LAB+" INTEGER PRIMARY KEY AUTOINCREMENT,"+DatosTabla.CAMPO_COD_LUGAR_OFERLAB+" VARCHAR(5) NOT NULL,"+DatosTabla.CAMPO_COD_OFER_MATE_OFERLAB+" INTEGER NOT NULL,"+DatosTabla.CAMPO_ISSS_OFERLAB+" CHAR(9) NOT NULL,"+DatosTabla.CAMPO_NUM_GRUPO_LAB+" CHAR(2) NOT NULL,"+" CONSTRAINT UC_ofertalab_v UNIQUE (cod_ofer_mate,num_grup_lab),"+"CONSTRAINT fk_OfertaLab_v FOREIGN KEY (cod_lugar) REFERENCES lugar(cod_lugar),"+"CONSTRAINT fk_OfertaLab_v1 FOREIGN KEY (cod_ofer_mate) REFERENCES oferta_materia(cod_ofer_mate),"+"CONSTRAINT fk_OfertaLab_v2 FOREIGN KEY (isss) REFERENCES docente(isss))";
        private static final String CREAR_TABLA_OFERTA_TEO ="CREATE TABLE "+DatosTabla.TABLA_OFERTA_TEO+" ("+DatosTabla.CAMPO_ID_OFER_TEO+" INTEGER PRIMARY KEY AUTOINCREMENT,"+DatosTabla.CAMPO_COD_LUGAR_OFERTEO+" VARCHAR(5) NOT NULL,"+DatosTabla.CAMPO_COD_OFER_MATE_OFERTEO+" INTEGER NOT NULL,"+DatosTabla.CAMPO_ISSS_OFERTEO+" CHAR(9) NOT NULL,"+DatosTabla.CAMPO_NUM_GRUPO_TEO+" CHAR(2) NOT NULL,"+" CONSTRAINT UC_ofertalab_v UNIQUE (cod_ofer_mate,num_grup_teo),"+"CONSTRAINT fk_OfertaTeo_v FOREIGN KEY (cod_lugar) REFERENCES lugar(cod_lugar),"+"CONSTRAINT fk_OfertaTeo_v1 FOREIGN KEY (cod_ofer_mate) REFERENCES oferta_materia(cod_ofer_mate),"+"CONSTRAINT fk_OfertaTeo_v2 FOREIGN KEY (isss) REFERENCES docente(isss))";
        private static final String CREAR_TABLA_ASIS_LAB ="CREATE TABLE "+DatosTabla.TABLA_ASIS_LAB+" ("+DatosTabla.CAMPO_FECHA_LAB+" DATE PRIMARY KEY NOT NULL,"+DatosTabla.CAMPO_ID_OFER_LAB_ASISLAB+" INTEGER NOT NULL,"+"CONSTRAINT fk_asislab FOREIGN KEY (id_ofer_lab) REFERENCES oferta_lab(id_ofer_lab))";
        private static final String CREAR_TABLA_CONTROL_LAB ="CREATE TABLE "+DatosTabla.TABLA_CONTROL_LAB+" ("+DatosTabla.CAMPO_FECHA_LAB_CONTROL+" DATE NOT NULL,"+DatosTabla.CAMPO_ID_INSLAB_CONTROL+" INTEGER NOT NULL,"+DatosTabla.CAMPO_ASITENCIA_LAB+" CHAR(1) NOT NULL,"+"CONSTRAINT UC_controlab_v UNIQUE (fecha_lab,id_insLab),"+"CONSTRAINT fk_contrllab_v FOREIGN KEY (fecha_lab) REFERENCES asis_lab(fecha_lab),"+"CONSTRAINT fk_controlab_v1 FOREIGN KEY (id_insLab) REFERENCES inscripcion_lab(id_insLab))";
        private static final String CREAR_TABLA_ASIS_TEO ="CREATE TABLE "+DatosTabla.TABLA_ASIS_TEO+" ("+DatosTabla.CAMPO_FECHA_TEO+" DATE PRIMARY KEY NOT NULL,"+DatosTabla.CAMPO_ID_OFER_TEO_ASISTEO+" INTEGER NOT NULL,"+"CONSTRAINT fk_asisteo FOREIGN KEY (id_ofer_teo) REFERENCES oferta_teo(id_ofer_teo))";
        private static final String CREAR_TABLA_CONTROL_TEO ="CREATE TABLE "+DatosTabla.TABLA_CONTROL_TEO+" ("+DatosTabla.CAMPO_FECHA_TEO_CONTROL+" DATE NOT NULL,"+DatosTabla.CAMPO_ID_INSTEO_CONTROL+" INTEGER NOT NULL,"+DatosTabla.CAMPO_ASITENCIA_TEO+" CHAR(1) NOT NULL,"+"CONSTRAINT UC_controlteo_v UNIQUE (fecha_teo,id_insTeo),"+"CONSTRAINT fk_contrteo_v FOREIGN KEY (fecha_teo) REFERENCES asis_teo(fecha_teo),"+"CONSTRAINT fk_controteo_v1 FOREIGN KEY (id_insTeo) REFERENCES inscripcion_teo(id_insTeo))";
        private static final String CREAR_TABLA_ASIS_EXAM ="CREATE TABLE "+DatosTabla.TABLA_ASIS_EXAM+" ("+DatosTabla.CAMPO_FECHA_EXAM+" DATE PRIMARY KEY,"+DatosTabla.CAMPO_COD_OFER_MATE_ASISEXA+" INTEGER NOT NULL,"+CAMPO_COD_EVA+" VARCHAR(6) NOT NULL,"+"CONSTRAINT fk_asisexam FOREIGN KEY (cod_ofer_mate) REFERENCES oferta_materia(cod_ofert_mate))";
        private static final String CREAR_TABLA_CONTROL_EXAM ="CREATE TABLE "+DatosTabla.TABLA_CONTROL_EXAM+" ("+DatosTabla.CAMPO_FECHA_EXAM_CONTROL+" DATE NOT NULL,"+DatosTabla.CAMPO_CARNET_CONTROL_EXAM+" CHAR(7) NOT NULL,"+DatosTabla.CAMPO_ASISTENCIA_EXAM+" CHAR(1) NOT NULL,"+"CONSTRAINT UC_controlexa_v UNIQUE (fecha_exam,carnet),"+"CONSTRAINT fk_contrexam_v FOREIGN KEY (fecha_exam) REFERENCES asis_exam(fecha_exam),"+"CONSTRAINT fk_controexam_v1 FOREIGN KEY (carnet) REFERENCES alumno(carnet))";
        private static final String CREAR_TABLA_SOLICITUD_DIFERIDO ="CREATE TABLE "+DatosTabla.TABLA_SOLICITUD_DIFERIDO+" ("+CAMPO_ID_SOLICITUD+" INTEGER PRIMARY KEY AUTOINCREMENT,"+DatosTabla.CAMPO_CARNET_SOLDI+" CHAR(7) NOT NULL,"+DatosTabla.CAMPO_ISSS_SOLDI+" CHAR(9) NOT NULL,"+DatosTabla.CAMPO_PERIODO_SOLDI+" CHAR(7) NOT NULL,"+DatosTabla.CAMPO_FECHA_EXAM_SOLDI+" DATE NOT NULL,"+DatosTabla.CAMPO_ESTADODIFE+" VARCHAR(1) NOT NULL,"+"CONSTRAINT fk_dife_v1 FOREIGN KEY (carnet) REFERENCES alumno(carnet),"+"CONSTRAINT fk_dife_v2 FOREIGN KEY (isss) REFERENCES jefe_departamento(isss),"+"CONSTRAINT fk_dife_v3 FOREIGN KEY (periodo) REFERENCES jefe_departamento(periodo))";
        private static final String CREAR_TABLA_OPCIONCRUD ="CREATE TABLE "+DatosTabla.TABLA_OPCIONCRUD+" ("+DatosTabla.CAMPO_IDOPCION+" INTEGER PRIMARY KEY AUTOINCREMENT,"+DatosTabla.CAMPO_DESOPCION+" VARCHAR(30) NOT NULL,"+DatosTabla.CAMPO_NUMCRUD+" INTEGER NOT NULL)";
        private static final String CREAR_TABLA_USUARIO ="CREATE TABLE "+DatosTabla.TABLA_USUARIO+" ("+ DatosTabla.CAMPO_IDUSUARIO+" INTEGER PRIMARY KEY AUTOINCREMENT,"+DatosTabla.CAMPO_NOMUSUARIO+ " VARCHAR(30) NOT NULL,"+DatosTabla.CAMPO_CLAVE+" CHAR(5) NOT NULL);";
        private static final String CREAR_TABLA_ACESSOUSUARIO ="CREATE TABLE "+DatosTabla.TABLA_ACESSOUSUARIO+ " ("+DatosTabla.CAMPO_IDUSUARIO_ACCESO+" CHAR(3),"+DatosTabla.CAMPO_IDOPCION_ACCESO+ " CHAR(30),"+ " primary key (idUsuario,idOpcion)," + "constraint fK_IDOPCION foreign key (idOpcion) references opcionCrud(idOpcion),"+"constraint fK_IDUSUARIO foreign key (idUsuario) references usuario(idUsuario))";






        //eliminacion
        private static final String DELETE_TABLA_ALUMNO="DROP TABLE IF EXISTS "+DatosTabla.TABLA_ALUMNO;
        private static final String DELETE_TABLA_ADMINISTRADOR="DROP TABLE IF EXISTS "+DatosTabla.TABLA_ADMINISTRADOR;
        private static final String DELETE_TABLA_AREA="DROP TABLE IF EXISTS "+DatosTabla.TABLA_AREA;
        private static final String DELETE_TABLA_CICLO="DROP TABLE IF EXISTS "+ DatosTabla.TABLA_CICLO;
        private static final String DELETE_TABLA_DOCENTE="DROP TABLE IF EXISTS "+DatosTabla.TABLA_DOCENTE;
        private static final String DELETE_TABLA_INSCRIPCION_TEO="DROP TABLE IF EXISTS "+DatosTabla.TABLA_INSCRIPCION_TEO;
        private static final String DELETE_TABLA_INSCRIPCION_LAB="DROP TABLE IF EXISTS "+DatosTabla.TABLA_INSCRIPCION_LAB;
        private static final String DELETE_TABLA_JEFE_DEPARTAMENTO ="DROP TABLE IF EXISTS "+DatosTabla.TABLA_JEFE_DEPARTAMENTO;
        private static final String DELETE_TABLA_LUGAR ="DROP TABLE IF EXISTS " +DatosTabla.TABLA_LUGAR;
        private static final String DELETE_TABLA_MATERIA ="DROP TABLE IF EXISTS "+ DatosTabla.TABLA_MATERIA;
        private static final String DELETE_TABLA_OFERTA_MATE ="DROP TABLE IF EXISTS "+ DatosTabla.TABLA_OFERTA_MATE;
        private static final String DELETE_TABLA_OFERTA_LAB =" DROP TABLE IF EXISTS " + DatosTabla.TABLA_OFERTA_LAB;
        private static final String DELETE_TABLA_OFERTA_TEO ="DROP TABLE IF EXISTS " +DatosTabla.TABLA_OFERTA_TEO;
        private static final String DELETE_TABLA_ASIS_LAB ="DROP TABLE IF EXISTS " +DatosTabla.TABLA_ASIS_LAB;
        private static final String DELETE_TABLA_CONTROL_LAB =" DROP TABLE IF EXISTS "+DatosTabla.TABLA_CONTROL_LAB;
        private static final String DELETE_TABLA_ASIS_TEO ="DROP TABLE IF EXISTS " +DatosTabla.TABLA_ASIS_TEO;
        private static final String DELETE_TABLA_CONTROL_TEO ="DROP TABLE IF EXISTS "+DatosTabla.TABLA_CONTROL_TEO;
        private static final String DELETE_TABLA_ASIS_EXAM =" DROP TABLE IF EXISTS "+DatosTabla.TABLA_ASIS_EXAM;
        private static final String DELETE_TABLA_CONTROL_EXAM ="DROP TABLE IF EXISTS "+DatosTabla.TABLA_CONTROL_EXAM;
        private static final String DELETE_TABLA_SOLICITUD_DIFERIDO ="DROP TABLE IF EXISTS "+DatosTabla.TABLA_SOLICITUD_DIFERIDO;
        private static final String DELETE_TABLA_OPCIONCRUD ="DROP TABLE IF EXISTS "+DatosTabla.TABLA_SOLICITUD_DIFERIDO;
        private static final String DELETE_TABLA_USUARIO ="DROP TABLE IF EXISTS "+DatosTabla.TABLA_USUARIO;
        private static final String DELETE_TABLA_ACESSOUSUARIO ="DROP TABLE IF EXISTS "+DatosTabla.TABLA_ACESSOUSUARIO;

    }
    private static final String DATABASE_NAME="prueba.db";
    private static final int DATABASE_VERSION=1;



    public ConexionSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatosTabla.CREAR_TABLA_ALUMNO);
        db.execSQL(DatosTabla.CREAR_TABLA_ADMINISTRADOR);
        db.execSQL(DatosTabla.CREAR_TABLA_AREA);
        db.execSQL(DatosTabla.CREAR_TABLA_CICLO);
        db.execSQL(DatosTabla.CREAR_TABLA_DOCENTE);
        db.execSQL(DatosTabla.CREAR_TABLA_INSCRIPCION_TEO);
        db.execSQL(DatosTabla.CREAR_TABLA_INSCRIPCION_LAB);
        db.execSQL(DatosTabla.CREAR_TABLA_JEFE_DEPARTAMENTO);
        db.execSQL(DatosTabla.CREAR_TABLA_LUGAR);
        db.execSQL(DatosTabla.CREAR_TABLA_MATERIA);
        db.execSQL(DatosTabla.CREAR_TABLA_OFERTA_MATE);
        db.execSQL(DatosTabla.CREAR_TABLA_OFERTA_LAB);
        db.execSQL(DatosTabla.CREAR_TABLA_OFERTA_TEO);
        db.execSQL(DatosTabla.CREAR_TABLA_ASIS_LAB);
        db.execSQL(DatosTabla.CREAR_TABLA_CONTROL_LAB);
        db.execSQL(DatosTabla.CREAR_TABLA_ASIS_TEO);
        db.execSQL(DatosTabla.CREAR_TABLA_CONTROL_TEO);
        db.execSQL(DatosTabla.CREAR_TABLA_ASIS_EXAM);
        db.execSQL(DatosTabla.CREAR_TABLA_CONTROL_EXAM);
        db.execSQL(DatosTabla.CREAR_TABLA_SOLICITUD_DIFERIDO);
        db.execSQL(DatosTabla.CREAR_TABLA_USUARIO);
        db.execSQL(DatosTabla.CREAR_TABLA_ACESSOUSUARIO);
        db.execSQL(DatosTabla.CREAR_TABLA_OPCIONCRUD);


        //DATOS INICIALES
        db.execSQL("INSERT INTO administrador values ( 'admin', 'admin')");
        db.execSQL("INSERT INTO alumno values ('MG14006', 'Lilian Patricia', 'Martinez Galdamez', 'prueba')");
        db.execSQL("INSERT INTO docente values ('123456789','Eduardo José','Recinos Merino','sobri')");
        db.execSQL("INSERT INTO docente values ('456789908','Ing.Bladimir','Día Campos','contra1')");
        db.execSQL("INSERT INTO docente values ('678234042','Ing. Elmer','Carballo','contra2')");
        db.execSQL("INSERT INTO docente values ('908756789','Lic. Guillermo','Mejía','contra3')");
        db.execSQL("INSERT INTO area values('12','Administración')");
        db.execSQL("INSERT INTO area values('23','Desarrollo de Sistemas')");
        db.execSQL("INSERT INTO area values('45','Programación y Manejo de Datos')");
        db.execSQL("INSERT INTO area values('67','Comunicaciones y CC. de la Cominicación')");
        db.execSQL("INSERT INTO lugar values('F1312',90,'S')");
        db.execSQL("INSERT INTO lugar values('LCOM4',20,'L')");
        db.execSQL("INSERT INTO materia values('PDM115','45','Progración para dispositivos móviles')");
        db.execSQL("INSERT INTO materia values('HDP115','45','Herramientas de productividad')");
        db.execSQL("INSERT INTO jefe_departamento values('23','678234042','014-018','je1')");
        db.execSQL("INSERT INTO jefe_departamento values('45','456789908','014-018','je2')");
        db.execSQL("INSERT INTO jefe_departamento values('67','908756789','014-018','je3')");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int VersionNueva) {
        db.execSQL(DatosTabla.DELETE_TABLA_ALUMNO);
        db.execSQL(DatosTabla.DELETE_TABLA_ADMINISTRADOR);
        db.execSQL(DatosTabla.DELETE_TABLA_AREA);
        db.execSQL(DatosTabla.DELETE_TABLA_CICLO);
        db.execSQL(DatosTabla.DELETE_TABLA_DOCENTE);
        db.execSQL(DatosTabla.DELETE_TABLA_INSCRIPCION_TEO);
        db.execSQL(DatosTabla.DELETE_TABLA_INSCRIPCION_LAB);
        db.execSQL(DatosTabla.DELETE_TABLA_JEFE_DEPARTAMENTO);
        db.execSQL(DatosTabla.DELETE_TABLA_LUGAR);
        db.execSQL(DatosTabla.DELETE_TABLA_MATERIA);
        db.execSQL(DatosTabla.DELETE_TABLA_OFERTA_MATE);
        db.execSQL(DatosTabla.DELETE_TABLA_OFERTA_LAB);
        db.execSQL(DatosTabla.DELETE_TABLA_OFERTA_TEO);
        db.execSQL(DatosTabla.DELETE_TABLA_ASIS_LAB);
        db.execSQL(DatosTabla.DELETE_TABLA_CONTROL_LAB);
        db.execSQL(DatosTabla.DELETE_TABLA_ASIS_TEO);
        db.execSQL(DatosTabla.DELETE_TABLA_CONTROL_TEO);
        db.execSQL(DatosTabla.DELETE_TABLA_ASIS_EXAM);
        db.execSQL(DatosTabla.DELETE_TABLA_CONTROL_EXAM);
        db.execSQL(DatosTabla.DELETE_TABLA_SOLICITUD_DIFERIDO);
        db.execSQL(DatosTabla.DELETE_TABLA_USUARIO);
        db.execSQL(DatosTabla.DELETE_TABLA_OPCIONCRUD);
        db.execSQL(DatosTabla.DELETE_TABLA_ACESSOUSUARIO);


        onCreate(db);
    }


   /* public void ingresomaterias(String cod, String nom, String area){
        String depa=nom; ////cambiar


        SQLiteDatabase db = null;
        Cursor pue =db.rawQuery ("Select cod_area from area where nom_area=="+area);

       db.execSQL("INSERT INTO"+DatosTabla.TABLA_MATERIA+"values("+cod+","+ nom+","+depa+")");


    }
    public void close(){
        this.close();
    }*/

    }



