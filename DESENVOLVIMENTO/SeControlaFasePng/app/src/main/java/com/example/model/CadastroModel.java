package com.example.model;

import com.example.DAO.UsuarioDAO;
import com.example.entity.Usuario;

public class CadastroModel {

    String mensagem="";
    // só decide quem vai fazer as coisas


    public boolean cadastrar(String nome, String senha){


        try {
            Usuario usuario = new Usuario(nome, senha);
            UsuarioDAO dao = new UsuarioDAO();
            dao.salvar(usuario);
            mensagem= "Usuário Cdastrado.";
            return true;
        }catch (Exception e){

            //fazer tratamento da mensagem
            //mensagem =
            mensagem=e.getMessage();
            return false;
        }
    }

    public String getMensagem(){
        return mensagem;
    }

}
