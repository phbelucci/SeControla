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
import entity.ContaBancaria;
import entity.NivelAcessoEnum;
import entity.Usuario;

public class UsuarioDAO {

    Connection con;
    Statement stm;
    int rset;
    ResultSet rsetGet;

    private Object conectaBD(String sql, String tipo, boolean connection){
        try {
            if(connection) {
                this.con = (Connection) BDFabricaConexao.getConnection();
            }
            this.stm = (Statement) con.createStatement();
            if (tipo.equals("UP")){
                this.rset = stm.executeUpdate(sql);
                return rset;

            }else if(tipo.equals("SE")){
                this.rsetGet = stm.executeQuery(sql);
                return rsetGet;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Usuario buscarUsuario(String nome, String senha){


        String sql = "SELECT * FROM USUARIO";

        Usuario u;

        try {

            /*
            this.con = (Connection) BDFabricaConexao.getConnection();

            this.stm = (Statement) con.createStatement();
            ResultSet rset = stm.executeQuery(sql);*/

            ResultSet query = (ResultSet) conectaBD(sql,"SE", true);

            while (query.next()) {
                if (query.getString("NOME_US").equals(nome)||
                        query.getString("NOME_US").toLowerCase().equals(nome)) {

                    u = new Usuario();
                    u.setCodUs(query.getInt("COD_US"));
                    u.setNomeUs(query.getString("NOME_US"));
                    u.setSenhaUs(query.getString("SENHA_US"));
                    u.setCodNivelAcesso(query.getInt("COD_NIVEL_ACESSO"));
                    u.setCodGrupo(query.getInt("COD_GRUPO"));

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

            /*
            this.con = (Connection) BDFabricaConexao.getConnection();

            this.stm = (Statement) con.createStatement();
            ResultSet rset = stm.executeQuery(sql);*/

            ResultSet query = (ResultSet) conectaBD(sql,"SE", true);

            while (query.next()) {
                u = new Usuario();
                u.setCodUs(query.getInt("COD_US"));
                u.setNomeUs(query.getString("NOME_US"));
                u.setSenhaUs(query.getString("SENHA_US"));
                u.setCodNivelAcesso(query.getInt("COD_NIVEL_ACESSO"));
                u.setCodGrupo(query.getInt("COD_GRUPO"));

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


    public Usuario inserirUsuarioNovo(String nome, String senha){

        Usuario u;

        String sqlInsertUsuarioVazio = String.format("INSERT INTO USUARIO(NOME_US, SENHA_US, COD_NIVEL_ACESSO, COD_GRUPO) " +
                "VALUES (%s, %s, 2, null;", nome, senha);
        String sqlUsuario = "SELECT * FROM USUARIO;";


        String sqlSelectGrupo = "SELECT * FROM GRUPO_FAMILIAR;";

        String sqlInsertGrupo = "INSERT INTO GRUPO_FAMILIAR(COD_US) VALUES(";

        try{
            conectaBD(sqlInsertUsuarioVazio,"UP", true);
            ResultSet query = (ResultSet) conectaBD(sqlUsuario,"SE", false);

            u=new Usuario();

            while(query.next()){
                if(query.getString("NOME_US").equals(nome))
                {
                    u.setCodUs(query.getInt("COD_US"));
                }
            }

            conectaBD(sqlInsertGrupo + u.getCodGrupo().toString()+");","UP", false);
            ResultSet queryGrupo = (ResultSet) conectaBD(sqlSelectGrupo,"SE", false);

            while (queryGrupo.next()){
                if(query.getString("NOME_US").equals(nome)){
                    u.setCodGrupo(queryGrupo.getInt("COD_GRUPO"));
                }
            }

            return u;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public boolean deletaUsuario(Integer codUs) {
        String sqlDelete = "DELETE INTO USUARIO WHERE COD_US="+codUs+";";

            try {
            conectaBD(sqlDelete,"SE", true);//false para não realizar a conexão novamente
            return true;
        }finally {
            try {
                con.close();
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean atualizarUsuario(Integer codUs, Integer nomeUs, Integer senhaUs, Integer codNivelAcesso, Integer codGrupo) {

        String sqlUpdate= "UPDATE USUARIO SET" +
                        " NOME_US="+nomeUs+
                        " AND SENHA_US=" + senhaUs +
                        " AND COD_NIVEL_ACESSO=" + codNivelAcesso.toString() +
                        " AND COD_GRUPO = " + codGrupo.toString() +
                        " WHERE COD_US =" + codUs.toString()+";";

        Integer aux = (Integer) conectaBD(sqlUpdate,"UP", true);
            
        if(aux>0){
            try {
                con.close();
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }

        return false;
    }
}
