package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Oferta_Lab implements Serializable {
    private Integer id_ofer_lab;
    private String cod_lugar;
    private Integer cod_ofer_mate;
    private Character isss;
    private Character num_grup_lab;

    public Oferta_Lab(Integer id_ofer_lab, String cod_lugar, Integer cod_ofer_mate, Character isss, Character num_grup_lab) {
        this.id_ofer_lab = id_ofer_lab;
        this.cod_lugar = cod_lugar;
        this.cod_ofer_mate = cod_ofer_mate;
        this.isss = isss;
        this.num_grup_lab = num_grup_lab;
    }

    public String getCod_lugar() {
        return cod_lugar;
    }

    public void setCod_lugar(String cod_lugar) {
        this.cod_lugar = cod_lugar;
    }

    public Integer getCod_ofer_mate() {
        return cod_ofer_mate;
    }

    public void setCod_ofer_mate(Integer cod_ofer_mate) {
        this.cod_ofer_mate = cod_ofer_mate;
    }

    public Character getIsss() {
        return isss;
    }

    public void setIsss(Character isss) {
        this.isss = isss;
    }

    public Integer getId_ofer_lab() {
        return id_ofer_lab;
    }

    public void setId_ofer_lab(Integer id_ofer_lab) {
        this.id_ofer_lab = id_ofer_lab;
    }

    public Character getNum_grup_lab() {
        return num_grup_lab;
    }

    public void setNum_grup_lab(Character num_grup_lab) {
        this.num_grup_lab = num_grup_lab;
    }
}
