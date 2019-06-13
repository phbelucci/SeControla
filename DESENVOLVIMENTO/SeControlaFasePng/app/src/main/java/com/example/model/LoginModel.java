package com.example.model;

import com.example.DAO.ContaBancariaDAO;
import com.example.DAO.GrupoFamiliarDAO;
import com.example.DAO.LancamentoDAO;
import com.example.DAO.UsuarioDAO;
import com.example.entity.ContaBancaria;
import com.example.entity.GrupoFamiliar;
import com.example.entity.Lancamento;
import com.example.entity.Usuario;
import com.example.DAO.LoginDAO;

import java.util.List;

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

        //Carrega lista de contas a partir do banco de dados
        ContaBancariaDAO CBdao = new ContaBancariaDAO();
        grupo.setContasGrupo(CBdao.getContasBancarias(grupo.getCodGrupo()));

        //Carrega lista de Lancamentos a partir do banco de dados
        LancamentoDAO Ldao = new LancamentoDAO();
        grupo.setLancamentosGrupo(Ldao.getLancamentosGrupo(grupo.getCodGrupo()));

        //Carrega lista de Usuarios a partir do banco de dados
        UsuarioDAO USdao = new UsuarioDAO();
        grupo.setUsuariosGrupo(USdao.getUsuariosGrupo(grupo.getCodGrupo()));


        mensagem = "Login efetuado!";
        return true;
    }

    public String getMensagem(){
        return mensagem;
    }
    public Usuario getUsuario(){
        return usuario;
    }
    public GrupoFamiliar getGrupo(){
        return grupo;
    }
}
