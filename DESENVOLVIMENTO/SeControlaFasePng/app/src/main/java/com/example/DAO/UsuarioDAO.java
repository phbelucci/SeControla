package com.example.DAO;

import com.example.entity.Usuario;
import com.example.service.HTTPService;

import java.util.concurrent.ExecutionException;

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

    public String buscarPorNome(String nome){

        HTTPService service = new HTTPService(nome);

        try {

            String usuarioRetornado = service.execute().get();
            return usuarioRetornado;

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Usuario buscarPorId(Integer codUs){

        //BUSCAR BANCO
        //Usar + codUs.toString() + ";"
        Usuario usuario = new Usuario(consultaCodUs, consultaCodNivelAcesso);

        return usuario;
    }


}
