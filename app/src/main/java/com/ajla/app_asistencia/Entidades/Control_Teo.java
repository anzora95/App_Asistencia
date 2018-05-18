package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Control_Teo implements Serializable{

    private String asistencia;
    private Integer id_insTeo;
    private Date fecha_teo;

    public Control_Teo() {
    }

    public Control_Teo(String asistencia, Integer id_insTeo, Date fecha_teo) {
        this.asistencia = asistencia;
        this.id_insTeo = id_insTeo;
        this.fecha_teo = fecha_teo;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public Integer getId_insTeo() {
        return id_insTeo;
    }

    public void setId_insTeo(Integer id_insTeo) {
        this.id_insTeo = id_insTeo;
    }

    public Date getFecha_teo() {
        return fecha_teo;
    }

    public void setFecha_teo(Date fecha_teo) {
        this.fecha_teo = fecha_teo;
    }
}
