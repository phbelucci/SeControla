package com.example.model;

import com.example.DAO.UsuarioDAO;
import com.example.entity.Usuario;

public class CadastroModel {

    String mensagem="";
    // só decide quem vai fazer as coisas


    public boolean cadastrar(String nome, String senha, String senhaRepetida){

        String senhaTratada = ""; //tratar senhaaaaaaaa

        try {
            Usuario usuario = new Usuario(nome, senhaTratada);
            UsuarioDAO dao = new UsuarioDAO();
            dao.salvar(usuario);
            return true;
        }catch (Exception e){
            //fazer tratamento da mensagem
            //mensagem =
            return false;
        }
    }

    public String getMensagem(){
        return mensagem;
    }

}
