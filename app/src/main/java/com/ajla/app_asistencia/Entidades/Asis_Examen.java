package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Asis_Examen implements Serializable{

    private Date fecha_exam;
    private String cod_materia;
    private String cod_eva;

    public Asis_Examen() {
    }

    public Asis_Examen(Date fecha_exam, String cod_materia, String cod_eva) {
        this.fecha_exam = fecha_exam;
        this.cod_materia = cod_materia;
        this.cod_eva = cod_eva;
    }

    public Date getFecha_exam() {
        return fecha_exam;
    }

    public void setFecha_exam(Date fecha_exam) {
        this.fecha_exam = fecha_exam;
    }

    public String getCod_materia() {
        return cod_materia;
    }

    public void setCod_materia(String cod_materia) {
        this.cod_materia = cod_materia;
    }

    public String getCod_eva() {
        return cod_eva;
    }

    public void setCod_eva(String cod_eva) {
        this.cod_eva = cod_eva;
    }
}
