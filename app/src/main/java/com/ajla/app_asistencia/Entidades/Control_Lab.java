package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Control_Lab implements Serializable{

    private Character asistencia;
    private Integer id_insLab;
    private Date fecha_lab;

    public Control_Lab(Character asistencia, Integer id_insLab, Date fecha_lab) {
        this.asistencia = asistencia;
        this.id_insLab = id_insLab;
        this.fecha_lab = fecha_lab;
    }

    public Character getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Character asistencia) {
        this.asistencia = asistencia;
    }

    public Integer getId_insLab() {
        return id_insLab;
    }

    public void setId_insLab(Integer id_insLab) {
        this.id_insLab = id_insLab;
    }

    public Date getFecha_lab() {
        return fecha_lab;
    }

    public void setFecha_lab(Date fecha_lab) {
        this.fecha_lab = fecha_lab;
    }
}
