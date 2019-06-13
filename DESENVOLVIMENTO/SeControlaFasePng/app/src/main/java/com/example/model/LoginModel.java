package com.example.model;

import com.example.DAO.GrupoFamiliarDAO;
import com.example.entity.GrupoFamiliar;
import com.example.entity.Usuario;
import com.example.DAO.LoginDAO;

public class LoginModel {

    private String mensagem="";
    private Usuario usuario;
    private GrupoFamiliar grupo;
    // só decide quem vai fazer as coisas


    public Boolean logar(String nome, String senha){
        try {
            LoginDAO dao = new LoginDAO(nome, senha);
            usuario = dao.logar();
        }catch (Exception e){

            //fazer tratamento da mensagem
            //mensagem =
            mensagem=e.getMessage();
            return false;
        }

        if(usuario == null){
            mensagem = "Ops! \nVerifique seus dados e tente novamente";
            return false;
        }
        GrupoFamiliarDAO dao = new GrupoFamiliarDAO();
        grupo = dao.getGrupo(usuario.getCodUs());

        if(grupo == null){
            mensagem = "Erro ao criar grupo, tente novamente.";
            //Pendente: deletar usuario do banco
            return false;
        }

        mensagem = "Login efetuado!";
        return true;
    }

    public String getMensagem(){
        return mensagem;
    }
    public Usuario getUsuario(){
        return usuario;
    }
}
