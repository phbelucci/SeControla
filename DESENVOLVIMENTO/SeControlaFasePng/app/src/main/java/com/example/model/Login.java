package com.example.model;

public class Login{
    
    Integer final codUs;
    String email;
    String senha;

    public Login(Integer codUs, String email, String senha) {
        this.codUs = codUs;
        this.email = email;
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }
}
