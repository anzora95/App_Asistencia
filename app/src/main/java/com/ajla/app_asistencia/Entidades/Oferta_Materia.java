package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Oferta_Materia implements Serializable{

    private Integer cod_ofer_mate;
    private Character cod_materia;
    private Character isss;
    private Character ciclo_anio;

    public Oferta_Materia(Integer cod_ofer_mate, Character cod_materia, Character isss, Character ciclo_anio) {
        this.cod_ofer_mate = cod_ofer_mate;
        this.cod_materia = cod_materia;
        this.isss = isss;
        this.ciclo_anio = ciclo_anio;
    }

    public Character getCod_materia() {
        return cod_materia;
    }

    public void setCod_materia(Character cod_materia) {
        this.cod_materia = cod_materia;
    }

    public Character getIsss() {
        return isss;
    }

    public void setIsss(Character isss) {
        this.isss = isss;
    }

    public Integer getCod_ofer_mate() {
        return cod_ofer_mate;
    }

    public void setCod_ofer_mate(Integer cod_ofer_mate) {
        this.cod_ofer_mate = cod_ofer_mate;
    }

    public Character getCiclo_anio() {
        return ciclo_anio;
    }

    public void setCiclo_anio(Character ciclo_anio) {
        this.ciclo_anio = ciclo_anio;
    }
}
