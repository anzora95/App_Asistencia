package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Asis_Lab implements Serializable{

    private Date fecha_lab;
    private Integer id_oferta_lab;

    public Asis_Lab() {
    }

    public Asis_Lab(Date fecha_lab, Integer id_oferta_lab) {
        this.fecha_lab = fecha_lab;
        this.id_oferta_lab = id_oferta_lab;
    }

    public Integer getId_oferta_lab() {
        return id_oferta_lab;
    }

    public void setId_oferta_lab(Integer id_oferta_lab) {
        this.id_oferta_lab = id_oferta_lab;
    }

    public Date getFecha_lab() {
        return fecha_lab;
    }

    public void setFecha_lab(Date fecha_lab) {
        this.fecha_lab = fecha_lab;
    }

    public Integer getId_ofer_lab() {
        return id_ofer_lab;
    }

    public void setId_ofer_lab(Integer id_ofer_lab) {
        this.id_ofer_lab = id_ofer_lab;
    }
}
