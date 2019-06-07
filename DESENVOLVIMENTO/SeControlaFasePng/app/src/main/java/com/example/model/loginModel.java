package com.example.model;

import android.graphics.Region;

import com.example.DAO.UsuarioDAO;
import com.example.entity.Usuario;

import java.util.Optional;

public class loginModel {


    String mensagem="";
    // só decide quem vai fazer as coisas


    public Optional<Usuario> logar(String nome, String senha){

        try {

            Usuario usuario = new Usuario(nome, senha);
            UsuarioDAO dao = new UsuarioDAO();
            dao.buscar(usuario);

            return usuario;

        }catch (Exception e){

            //fazer tratamento da mensagem
            //mensagem =
            mensagem=e.getMessage();
        }
    }

    public String getMensagem(){
        return mensagem;
    }
}
