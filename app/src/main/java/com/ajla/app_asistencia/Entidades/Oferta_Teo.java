package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Oferta_Teo implements Serializable{

    private Integer id_ofer_teo;
    private String cod_lugar;
    private Integer cod_ofer_mate;
    private Character isss;
    private Character num_grup_teo;

    public Oferta_Teo(Integer id_ofer_teo, String cod_lugar, Integer cod_ofer_mate, Character isss, Character num_grup_teo) {
        this.id_ofer_teo = id_ofer_teo;
        this.cod_lugar = cod_lugar;
        this.cod_ofer_mate = cod_ofer_mate;
        this.isss = isss;
        this.num_grup_teo = num_grup_teo;
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

    public Integer getId_ofer_teo() {
        return id_ofer_teo;
    }

    public void setId_ofer_teo(Integer id_ofer_teo) {
        this.id_ofer_teo = id_ofer_teo;
    }

    public Character getNum_grup_teo() {
        return num_grup_teo;
    }

    public void setNum_grup_teo(Character num_grup_teo) {
        this.num_grup_teo = num_grup_teo;
    }
}
