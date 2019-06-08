package com.example.model;

import com.example.DAO.UsuarioDAO;
import com.example.entity.Usuario;

public class CadastroModel {

    String mensagem="";
    // só decide quem vai fazer as coisas
    private String nome;
    private String senha;

    public boolean cadastrar(String nome, String senha){


        try {
            Usuario usuario = new Usuario(nome, senha);
            UsuarioDAO dao = new UsuarioDAO();
            dao.salvar(usuario);
            dao.buscar(usuario);
            mensagem= "Usuário Cdastrado.";
            System.out.println(usuario);
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
