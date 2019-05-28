package com.example.model;

import android.media.Image;

public class Usuario{

    private final Integer codUs;
    private String nomeUs;
    private String senhaUs;
    private Image avatarUs;
    private Integer codMoeda;
    private Login login;


    //com avatar
    public Usuario(Integer codUs, String nomeUs, String senhaUs, Image avatarUs, Integer codMoeda) {
        this.codUs = codUs;
        this.nomeUs = nomeUs;
        this.senhaUs = senhaUs;
        this.avatarUs = avatarUs;
        this.codMoeda = codMoeda;
    }

    //sem avatar
    public Usuario(Integer codUs, String nomeUs, String senhaUs, Integer codMoeda, String email, String senha) {
        login = new Login();

        this.codUs = codUs;
        this.nomeUs = nomeUs;
        this.senhaUs = senhaUs;
        this.codMoeda = codMoeda;
        login.setEmail(email);

    }

    public Integer getCodUs() {
        return codUs;
    }


}