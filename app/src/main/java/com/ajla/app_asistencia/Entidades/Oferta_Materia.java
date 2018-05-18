package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Oferta_Materia implements Serializable{

    private Integer cod_ofer_mate;
    private String ciclo_anio;
    private String cod_materia;

    public String getCod_materia() {
        return cod_materia;
    }

    public void setCod_materia(String cod_materia) {
        this.cod_materia = cod_materia;
    }

    public String getIsss() {
        return isss;
    }

    public void setIsss(String isss) {
        this.isss = isss;
    }

    private String isss;


    public Oferta_Materia() {
    }

    public Oferta_Materia(Integer cod_ofer_mate, String ciclo_anio) {
        this.cod_ofer_mate = cod_ofer_mate;
        this.ciclo_anio = ciclo_anio;
    }

    public Integer getCod_ofer_mate() {
        return cod_ofer_mate;
    }

    public void setCod_ofer_mate(Integer cod_ofer_mate) {
        this.cod_ofer_mate = cod_ofer_mate;
    }

    public String getCiclo_anio() {
        return ciclo_anio;
    }

    public void setCiclo_anio(String ciclo_anio) {
        this.ciclo_anio = ciclo_anio;
    }
}
