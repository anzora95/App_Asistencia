package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Control_Exam implements Serializable{

    private Date fecha_examen;
    private String carnet;
    private String asistencia;

    public Control_Exam() {
    }

    public Control_Exam(Date fecha_examen, String carnet, String asistencia) {
        this.fecha_examen = fecha_examen;
        this.carnet = carnet;
        this.asistencia = asistencia;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public Date getFecha_examen() {
        return fecha_examen;
    }

    public void setFecha_examen(Date fecha_examen) {
        this.fecha_examen = fecha_examen;
    }
}
