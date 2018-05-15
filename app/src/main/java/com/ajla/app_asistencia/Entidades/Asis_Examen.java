package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Asis_Examen implements Serializable{

    private Date fecha_exam;

    public Asis_Examen(Date fecha_exam) {
        this.fecha_exam = fecha_exam;
    }

    public Date getFecha_exam() {
        return fecha_exam;
    }

    public void setFecha_exam(Date fecha_exam) {
        this.fecha_exam = fecha_exam;
    }
}
