package com.secontrola.model;

import android.media.Image;

public class Usuario{

    private final Integer codUs;
    private String nomeUs;
    private Image avatarUs;
    private Login login;
    private Integer codGrupo;

    //com avatar
    public Usuario(Integer codUs, String nomeUs, Integer codGrupo, String usuario, Image avatarUs,String senha) {
        login = new Login(codUs, usuario, senha);

        this.codUs = codUs;
        this.nomeUs = nomeUs;
        this.avatarUs = avatarUs;
        this.codGrupo = codGrupo;
    }

    //sem avatar
    public Usuario(Integer codUs, String nomeUs, Integer codGrupo, String usuario, String senha) {
        login = new Login(codUs, usuario, senha);

        this.codUs = codUs;
        this.nomeUs = nomeUs;
        this.codGrupo = codGrupo;
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

    public String getUsuario(){
        return login.getUsuario();
    }

    public Integer getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(Integer codGrupo) {
        this.codGrupo = codGrupo;
    }

    public void setUsuario(String usuario){
        login.setUsuario(usuario);
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

}