package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Solicitud_Diferido implements Serializable{

 private Integer id_solicitud;
 private String estado;
 private String carnet;
 private String isss;
 private String periodo;
 private Date fecha;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Solicitud_Diferido() {
    }

    public Solicitud_Diferido(Integer id_solicitud, String estado, String carnet, String isss, String periodo) {
        this.id_solicitud = id_solicitud;
        this.estado = estado;
        this.carnet = carnet;
        this.isss = isss;
        this.periodo = periodo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getIsss() {
        return isss;
    }

    public void setIsss(String isss) {
        this.isss = isss;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Integer getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(Integer id_solicitud) {
        this.id_solicitud = id_solicitud;
    }


}
