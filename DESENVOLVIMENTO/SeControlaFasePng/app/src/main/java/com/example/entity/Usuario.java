package com.example.entity;

import android.media.Image;

import java.io.Serializable;

/*
 *      Classe atualizada de acordo com o Servidor
 *  */
public class Usuario implements Serializable {

    private Integer codUs;
    private String nomeUs;
    private String senhaUs;
    //private Image avatarUs;
    private Integer codNivelAcesso;
    private Integer codGrupo;
    //private Login login;

    /*com avatar
    public Usuario(Integer codUs, String nomeUs, Integer codGrupo, String usuario, Image avatarUs,String senha) {
        //login = new Login(codUs, usuario, senha);

        this.codUs = codUs;
        this.nomeUs = nomeUs;
        this.avatarUs = avatarUs;
        this.codGrupo = codGrupo;
    }
    */

    public Usuario(String nomeUs, String senha) {
        this.codUs = 1;
        this.nomeUs = nomeUs;
        this.senhaUs=senha;
        this.codGrupo = 1;
        this.codNivelAcesso = 2;
    }

    //sem avatar
    public Usuario(Integer codUs, String nomeUs, Integer codGrupo, String usuario, String senha) {
        //login = new Login(codUs, usuario, senha);

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
    /*
    public Image getAvatarUs() {
        return avatarUs;
    }
    */
    /*public String getUsuario(){
        return login.getUsuario();
    }*/

    public Integer getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(Integer codGrupo) {
        this.codGrupo = codGrupo;
    }

    /*public void setUsuario(String usuario){
        login.setUsuario(usuario);
    }*/

    /*public void setSenha(String senha){
        login.setSenha(senha);
    }*/

    public void setNomeUs(String nomeUs) {
        this.nomeUs = nomeUs;
    }
    /*
    public void setAvatarUs(Image avatarUs) {
        this.avatarUs = avatarUs;
    }
    */
    public boolean verificaSenha(String senha){
        if (this.senhaUs.equals(senha)){
            return true;
        }
        return false;
    }

}