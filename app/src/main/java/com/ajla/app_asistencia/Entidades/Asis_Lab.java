package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Asis_Lab implements Serializable{

    private Date fecha_lab;

    public Asis_Lab(Date fecha_lab) {
        this.fecha_lab = fecha_lab;
    }

    public Date getFecha_lab() {
        return fecha_lab;
    }

    public void setFecha_lab(Date fecha_lab) {
        this.fecha_lab = fecha_lab;
    }
}
