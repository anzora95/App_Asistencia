package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Asis_Teo implements Serializable{
    private Date fecha_teo;

    public Asis_Teo(Date fecha_teo) {
        this.fecha_teo = fecha_teo;
    }

    public Date getFecha_teo() {
        return fecha_teo;
    }

    public void setFecha_teo(Date fecha_teo) {
        this.fecha_teo = fecha_teo;
    }
}
