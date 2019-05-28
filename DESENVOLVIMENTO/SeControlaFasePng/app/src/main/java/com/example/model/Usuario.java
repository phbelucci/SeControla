package com.example.model;

import android.media.Image;

public class Usuario{

    private final Integer codUs;
    private String nomeUs;
    private Image avatarUs;
    private Integer codMoeda;
    private Login login;

    //com avatar
    public Usuario(Integer codUs, String nomeUs, Image avatarUs, Integer codMoeda,String senha) {
        login = new Login(codUs, email, senha);

        this.codUs = codUs;
        this.nomeUs = nomeUs;
        this.avatarUs = avatarUs;
        this.codMoeda = codMoeda;
    }

    //sem avatar
    public Usuario(Integer codUs, String nomeUs, Integer codMoeda, String email, String senha) {
        login = new Login(codUs, email, senha);

        this.codUs = codUs;
        this.nomeUs = nomeUs;
        this.codMoeda = codMoeda;
    }

    public Integer getCodUs() {
        return codUs;
    }

    public String getNomeUs() {
        return nomeUs;
    }

    public Image getAvatarUs() {
        return avatarUs;
    }

    public Integer getCodMoeda() {
        return codMoeda;
    }

    public String getEmail(){
        return login.getEmail();
    }

    public void setEmail(String email){
        login.setEmail(email);
    }

    public void setSenha(String senha){
        login.setSenha(senha);
    }

    public void setNomeUs(String nomeUs) {
        this.nomeUs = nomeUs;
    }

    public void setAvatarUs(Image avatarUs) {
        this.avatarUs = avatarUs;
    }

    public void setCodMoeda(Integer codMoeda) {
        this.codMoeda = codMoeda;
    }

}