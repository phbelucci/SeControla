package com.example.model;

//import com.example.DAO.LoginDAO;
import com.example.DAO.CadastroDAO;
import com.example.DAO.ContaBancariaDAO;
import com.example.DAO.GrupoFamiliarDAO;
import com.example.DAO.LancamentoDAO;
import com.example.DAO.UsuarioDAO;
import com.example.entity.ContaBancaria;
import com.example.entity.GrupoFamiliar;
import com.example.entity.Usuario;

import java.util.List;

public class CadastroModel {

    String mensagem="";
    // só decide quem vai fazer as coisas
    private String nome;
    private String senha;
    private Usuario usuario;
    private GrupoFamiliar grupo;

    public Boolean cadastrar(String nome, String senha){
        try{
            CadastroDAO dao = new CadastroDAO(nome, senha);
            usuario = dao.cadastrar();
        }catch (Exception e){
            mensagem = e.getMessage();
            return false;
        }
        if (usuario == null) {
            mensagem = "Ocorreu algum erro no cadastro...\ncontate o administrador.";
            return false;
        }



        GrupoFamiliarDAO dao = new GrupoFamiliarDAO();
        grupo = dao.getGrupo(usuario.getCodUs());

        if(grupo == null){
            mensagem = "Erro ao criar grupo, tente novamente.";
            //Pendente: deletar usuario do banco
            return false;
        }

        mensagem = "Cadastro realizado!";
        return true;

        /*
        HTTPServiceGET service = new HTTPServiceGET(nome+"/"+senha);


        try {
            retorno = service.execute().get();
            System.out.println(retorno);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


            usuario = new Usuario(nome,senha);
            UsuarioDAO dao = new UsuarioDAO();
            dao.salvar(usuario);
            dao.buscarPorNome(nome);

            mensagem= "Usuário Cadastrado.";
            System.out.println(usuario);
            return true;
        //}catch (Exception e){
            //fazer tratamento da mensagem
            //mensagem =
            //mensagem=e.getMessage();
            return false;
        }*/
    }


    public String getMensagem(){
        return mensagem;
    }
    public Usuario getUsuario(){ return usuario; }
    public GrupoFamiliar getGrupo() { return grupo; }

}
