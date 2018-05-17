package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Solicitud_Diferido implements Serializable{

 private Integer id_solicitud;
 private Character carnet;
 private Character isss;
 private Character periodo;
 private Date fecha_examen;
 private String  estado;

    public Solicitud_Diferido(Integer id_solicitud, Character carnet, Character isss, Character periodo, Date fecha_examen, String estado) {
        this.id_solicitud = id_solicitud;
        this.carnet = carnet;
        this.isss = isss;
        this.periodo = periodo;
        this.fecha_examen = fecha_examen;
        this.estado = estado;
    }

    public Integer getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(Integer id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public Character getCarnet() {
        return carnet;
    }

    public void setCarnet(Character carnet) {
        this.carnet = carnet;
    }

    public Character getIsss() {
        return isss;
    }

    public void setIsss(Character isss) {
        this.isss = isss;
    }

    public Character getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Character periodo) {
        this.periodo = periodo;
    }

    public Date getFecha_examen() {
        return fecha_examen;
    }

    public void setFecha_examen(Date fecha_examen) {
        this.fecha_examen = fecha_examen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
