package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.BDFabricaConexao;
import entity.Usuario;

public class UsuarioDAO {

    Connection con;
    Statement stm;

    public Usuario buscarUsuario(String nome, String senha){


        String sql = "SELECT * FROM USUARIO";

        Usuario u;

        try {
            this.con = (Connection) BDFabricaConexao.getConnection();

            this.stm = (Statement) con.createStatement();
            ResultSet rset = stm.executeQuery(sql);

            while (rset.next()) {
                if (rset.getString("NOME_US").equals(nome)||
                        rset.getString("NOME_US").toLowerCase().equals(nome)) {

                    u = new Usuario();
                    u.setCodUs(rset.getInt("COD_US"));
                    u.setNomeUs(rset.getString("NOME_US"));
                    u.setSenhaUs(rset.getString("SENHA_US"));
                    u.setCodNivelAcesso(rset.getInt("COD_NIVEL_ACESSO"));
                    u.setCodGrupo(rset.getInt("COD_GRUPO"));

                    if(u.verificaSenha(senha)){
                        con.close();
                        return u;
                    }
                }
            }

        }catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                con.close();
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



        return null;
    }

    public List<Usuario> buscarTodosUsuarios() {

        List<Usuario> listAll = new ArrayList<Usuario>();

        String sql = "SELECT * FROM USUARIO";

        Usuario u;

        try {
            this.con = (Connection) BDFabricaConexao.getConnection();

            this.stm = (Statement) con.createStatement();
            ResultSet rset = stm.executeQuery(sql);

            while (rset.next()) {
                    u = new Usuario();
                    u.setCodUs(rset.getInt("COD_US"));
                    u.setNomeUs(rset.getString("NOME_US"));
                    u.setSenhaUs(rset.getString("SENHA_US"));
                    u.setCodNivelAcesso(rset.getInt("COD_NIVEL_ACESSO"));
                    u.setCodGrupo(rset.getInt("COD_GRUPO"));

                    listAll.add(u);
                }
        }catch (SQLException e) {
        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                con.close();
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listAll;
    }

/*
    public boolean inserirUsuarioNovo(String nome, String senha){

        //INSERIR USUARIO INCOMPLETO -- RETORNAR USUARIO INCOMPLETO PARA PEGAR O ID
        //CRIA GRUPO COM O ID CRIADO -- RETORNAR ID GRUPO
        //


        String sql = "INSERT INTO USUARIO(NOME_US, SENHA_US, COD_NIVEL_ACESSO, COD_GRUPO) \n" +
                "VALUES ("

        try {
            this.con = (Connection) BDFabricaConexao.getConnection();

            this.stm = (Statement) con.createStatement();
            ResultSet rset = stm.executeQuery(sql);

            while (rset.next()) {
                if (rset.getString("NOME_US").equals(nome)||
                        rset.getString("NOME_US").toLowerCase().equals(nome)) {

                    u = new Usuario();
                    u.setCodUs(rset.setInt("COD_US"));
                    u.setNomeUs(rset.getString("NOME_US"));
                    u.setSenhaUs(rset.getString("SENHA_US"));
                    u.setCodNivelAcesso(rset.getInt("COD_NIVEL_ACESSO"));
                    u.setCodGrupo(rset.getInt("COD_GRUPO"));

                    if(u.verificaSenha(senha)){
                        con.close();
                        return u;
                    }
                }
            }

        }catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                con.close();
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }*/

}
