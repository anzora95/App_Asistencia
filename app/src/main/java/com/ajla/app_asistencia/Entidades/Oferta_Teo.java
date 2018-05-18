package com.ajla.app_asistencia.Entidades;

import java.io.Serializable;

/**
 * Created by Gloria Maria on 14/5/2018.
 */

public class Oferta_Teo implements Serializable{

    private Integer id_ofer_teo;
    private String cod_lugar;
    private Integer cod_ofert_mate;
    private String isss;
    private String num_grup_teo;

    public Oferta_Teo() {
    }

    public Oferta_Teo(Integer id_ofer_teo, String cod_lugar, Integer cod_ofert_mate, String isss, String num_grup_teo) {
        this.id_ofer_teo = id_ofer_teo;
        this.cod_lugar = cod_lugar;
        this.cod_ofert_mate = cod_ofert_mate;
        this.isss = isss;
        this.num_grup_teo = num_grup_teo;
    }

    public Integer getId_ofer_teo() {
        return id_ofer_teo;
    }

    public void setId_ofer_teo(Integer id_ofer_teo) {
        this.id_ofer_teo = id_ofer_teo;
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

    public String getNum_grup_teo() {
        return num_grup_teo;
    }

    public void setNum_grup_teo(String num_grup_teo) {
        this.num_grup_teo = num_grup_teo;
    }
}
