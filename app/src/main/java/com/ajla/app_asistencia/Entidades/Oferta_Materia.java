package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Oferta_Materia implements Serializable{

    private Integer cod_ofer_mate;
    private Character ciclo_anio;

    public Oferta_Materia(Integer cod_ofer_mate, Character ciclo_anio) {
        this.cod_ofer_mate = cod_ofer_mate;
        this.ciclo_anio = ciclo_anio;
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
