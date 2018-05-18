package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Control_Lab implements Serializable{

    private String asistencia;
    private Integer id_inslab;
    private Date fecha_lab;

    public Control_Lab() {
    }

    public Control_Lab(String asistencia, Integer id_inslab, Date fecha_lab) {
        this.asistencia = asistencia;
        this.id_inslab = id_inslab;
        this.fecha_lab = fecha_lab;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public Integer getId_inslab() {
        return id_inslab;
    }

    public void setId_inslab(Integer id_inslab) {
        this.id_inslab = id_inslab;
    }

    public Date getFecha_lab() {
        return fecha_lab;
    }

    public void setFecha_lab(Date fecha_lab) {
        this.fecha_lab = fecha_lab;
    }
}
