package com.example.model;

import android.media.Image;

public class Usuario{

    private final Integer codUs;
    private String nomeUs;
    private String senhaUs;
    private Image avatarUs;
    private Integer codMoeda;

    //com avatar
    public Usuario(Integer codUs, String nomeUs, String senhaUs, Image avatarUs, Integer codMoeda) {
        this.codUs = codUs;
        this.nomeUs = nomeUs;
        this.senhaUs = senhaUs;
        this.avatarUs = avatarUs;
        this.codMoeda = codMoeda;
    }

    //sem avatar
    public Usuario(Integer codUs, String nomeUs, String senhaUs, Integer codMoeda) {
        this.codUs = codUs;
        this.nomeUs = nomeUs;
        this.senhaUs = senhaUs;
        this.codMoeda = codMoeda;
    }



    public Integer getCodUs() {
        return codUs;
    }
}