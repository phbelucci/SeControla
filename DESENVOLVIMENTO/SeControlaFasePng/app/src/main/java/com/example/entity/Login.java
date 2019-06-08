package com.example.entity;

public class Login{
    
    private Integer codUs;
    private String usuario;
    private String senha;

    public Login(Integer codUs, String usuario, String senha) {
        this.codUs = codUs;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Login(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }
}
