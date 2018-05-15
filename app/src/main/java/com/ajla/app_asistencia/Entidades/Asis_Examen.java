package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Asis_Examen implements Serializable{

    private Date fecha_exam;
    private Integer cod_ofer_mate;
    private String cod_materia;

    public Asis_Examen(Date fecha_exam, Integer cod_ofer_mate, String cod_materia) {
        this.fecha_exam = fecha_exam;
        this.cod_ofer_mate = cod_ofer_mate;
        this.cod_materia = cod_materia;
    }

    public Date getFecha_exam() {
        return fecha_exam;
    }

    public void setFecha_exam(Date fecha_exam) {
        this.fecha_exam = fecha_exam;
    }

    public Integer getCod_ofer_mate() {
        return cod_ofer_mate;
    }

    public void setCod_ofer_mate(Integer cod_ofer_mate) {
        this.cod_ofer_mate = cod_ofer_mate;
    }

    public String getCod_materia() {
        return cod_materia;
    }

    public void setCod_materia(String cod_materia) {
        this.cod_materia = cod_materia;
    }
}
