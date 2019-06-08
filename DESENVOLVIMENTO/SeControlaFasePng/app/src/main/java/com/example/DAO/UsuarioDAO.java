package com.example.DAO;

import com.example.entity.Usuario;

public class UsuarioDAO {

    String consultaCodUs = ("SELECT COD_US FROM usuario WHERE nome_us=");
    String consultaNomeUs = ("SELECT NOME_US FROM usuario WHERE nome_us=");
    String consultaSenhaUs = ("SELECT SENHA_US FROM usuario WHERE nome_us=");
    String consultaAvatar = ("SELECT AVATAR_US FROM usuario WHERE nome_us=");
    String consultaCodNivelAcesso = ("SELECT COD_NIVEL_ACESSO FROM usuario WHERE nome_us=");
    String consultaCodGrupo = ("SELECT COD_GRUPO FROM usuario WHERE nome_us=");


    public void salvar(Usuario usuario){
        //INSERT NO BANCO

        //CONCATENA STRING DO

        //tratar erro e dar re


    }

    public Usuario buscarPorNome(String nome){

        //BUSCAR BANCO

        Usuario usuario = new Usuario(consultaCodUs + nome + ";", consultaCodNivelAcesso);
        return usuario;
    }

    public Usuario buscarPorId(Integer codUs){

        //BUSCAR BANCO
        //Usar + codUs.toString() + ";"
        Usuario usuario = new Usuario(consultaCodUs, consultaCodNivelAcesso);

        return usuario;
    }


}
