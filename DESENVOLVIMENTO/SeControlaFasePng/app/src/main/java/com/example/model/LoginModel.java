package com.example.model;

import android.graphics.Region;

import com.example.DAO.UsuarioDAO;
import com.example.entity.Usuario;
import com.example.service.LoginHTTPService;

import java.util.Optional;

public class LoginModel {

    private String mensagem="";
    private Usuario u;
    // só decide quem vai fazer as coisas


    public Boolean logar(String nome, String senha){
        try {
            LoginHTTPService login = new LoginHTTPService(nome, senha);
            u = login.execute().get();
        }catch (Exception e){

            //fazer tratamento da mensagem
            //mensagem =
            mensagem=e.getMessage();
            return false;
        }

        if(u == null){
            mensagem = "Ops! \nVerifique seus dados e tente novamente";
            return false;
        }

        mensagem = "Login efetuado!";
        return true;
    }

    public String getMensagem(){
        return mensagem;
    }
    public Usuario getUsuario(){
        return u;
    }
}
