package com.example.model;

import android.graphics.Region;

import com.example.DAO.UsuarioDAO;
import com.example.entity.Usuario;

import java.util.Optional;

public class loginModel {


    String mensagem="";
    // só decide quem vai fazer as coisas


    public Usuario logar(String nome, String senha){

        Usuario usuario = new Usuario(nome, senha);

        try {
            UsuarioDAO dao = new UsuarioDAO();
            usuario = dao.buscarPorNome(nome);

            if(usuario.verificaSenha(senha)) {

            }else{
                mensagem="Senha incorreta";
            }
        }catch (Exception e){

            //fazer tratamento da mensagem
            //mensagem =
            mensagem=e.getMessage();
        }

        return usuario;
    }

    public String getMensagem(){
        return mensagem;
    }
}
