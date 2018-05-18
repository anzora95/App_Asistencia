package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Oferta_Lab implements Serializable {
    private Integer id_ofer_lab;
    private String cod_lugar;
    private Integer cod_ofert_mate;
    private String isss;
    private String num_grup_lab;

    public Oferta_Lab() {
    }

    public Oferta_Lab(Integer id_ofer_lab, String cod_lugar, Integer cod_ofert_mate, String isss, String num_grup_lab) {
        this.id_ofer_lab = id_ofer_lab;
        this.cod_lugar = cod_lugar;
        this.cod_ofert_mate = cod_ofert_mate;
        this.isss = isss;
        this.num_grup_lab = num_grup_lab;
    }

    public Integer getId_ofer_lab() {
        return id_ofer_lab;
    }

    public void setId_ofer_lab(Integer id_ofer_lab) {
        this.id_ofer_lab = id_ofer_lab;
    }

    public String getCod_lugar() {
        return cod_lugar;
    }

    public void setCod_lugar(String cod_lugar) {
        this.cod_lugar = cod_lugar;
    }

    public Integer getCod_ofert_mate() {
        return cod_ofert_mate;
    }

    public void setCod_ofert_mate(Integer cod_ofert_mate) {
        this.cod_ofert_mate = cod_ofert_mate;
    }

    public String getIsss() {
        return isss;
    }

    public void setIsss(String isss) {
        this.isss = isss;
    }

    public String getNum_grup_lab() {
        return num_grup_lab;
    }

    public void setNum_grup_lab(String num_grup_lab) {
        this.num_grup_lab = num_grup_lab;
    }
}
