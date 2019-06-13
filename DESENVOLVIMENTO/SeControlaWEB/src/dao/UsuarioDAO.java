package dao;

import com.mysql.cj.jdbc.CallableStatement;
import connection.BDFabricaConexao;
import entity.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    Connection con;
    Statement stm;
    CallableStatement stmt;

    int rset;
    ResultSet rsetAux;

    String sqlAllUsuario = "SELECT * FROM USUARIO;";

    private Object conectaBD(String sql, String tipo, boolean connection) {
        try {
            if (connection) {
                this.con = (Connection) BDFabricaConexao.getConnection();
            }

            switch (tipo) {
                case "UP":
                    this.stm = (Statement) con.createStatement();
                    this.rset = stm.executeUpdate(sql);
                    return rset;
                case "SE":
                    this.stm = (Statement) con.createStatement();
                    this.rsetAux = stm.executeQuery(sql);
                    return rsetAux;
                case "FU":
                    stmt = (CallableStatement) con.prepareCall(sql);
                    this.rsetAux = stmt.executeQuery(sql);
                    return rsetAux;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Usuario buscarUsuario(String nome, String senha) {

        Usuario u;

        try {

            /*
            this.con = (Connection) BDFabricaConexao.getConnection();

            this.stm = (Statement) con.createStatement();
            ResultSet rset = stm.executeQuery(sql);*/

            ResultSet query = (ResultSet) conectaBD(sqlAllUsuario, "SE", true);

            while (query.next()) {
                if (query.getString("NOME_US").equals(nome) ||
                        query.getString("NOME_US").toLowerCase().equals(nome)) {

                    u = new Usuario();
                    u.setCodUs(query.getInt("COD_US"));
                    u.setNomeUs(query.getString("NOME_US"));
                    u.setSenhaUs(query.getString("SENHA_US"));
                    u.setCodNivelAcesso(query.getInt("COD_NIVEL_ACESSO"));
                    u.setCodGrupo(query.getInt("COD_GRUPO"));

                    if (u.verificaSenha(senha)) {
                        return u;
                    }
                }
            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
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

        Usuario u;

        try {

            /*
            this.con = (Connection) BDFabricaConexao.getConnection();

            this.stm = (Statement) con.createStatement();
            ResultSet rset = stm.executeQuery(sql);*/

            ResultSet query = (ResultSet) conectaBD(sqlAllUsuario, "SE", true);

            while (query.next()) {
                u = new Usuario();
                u.setCodUs(query.getInt("COD_US"));
                u.setNomeUs(query.getString("NOME_US"));
                u.setSenhaUs(query.getString("SENHA_US"));
                u.setCodNivelAcesso(query.getInt("COD_NIVEL_ACESSO"));
                u.setCodGrupo(query.getInt("COD_GRUPO"));

                listAll.add(u);
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                con.close();
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listAll;
    }

    public Usuario inserirUsuarioNovo(String nome, String senha) {

        String sqlFunction = String.format("{CALL Add_Novo_Usuario('%s','%s', @codigo, @nome, @senha, @niveAcesso, @grupo)};", nome, senha);


        ResultSet query = (ResultSet) conectaBD(sqlFunction, "FU", true);

        if (query != null)
            return buscarUsuario(nome, senha);

        return null;
    }

    public boolean deletaUsuario(Integer codUs) {
        String sqlDelete = "DELETE FROM USUARIO WHERE COD_US=" + codUs + ";";

        try {
            conectaBD(sqlDelete, "UP", true);//false para não realizar a conexão novamente
            return true;
        } finally {
            try {
                con.close();
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Usuario atualizarUsuario(Integer codUs, String nomeUs, String senhaUs, Integer codNivelAcesso, Integer codGrupo) {

        String sqlUpadate = String.format("CALL Update_Usuario(%d,'%s','%s',%d,%d)", codUs, nomeUs, senhaUs, codNivelAcesso, codGrupo);

        ResultSet query = (ResultSet) conectaBD(sqlUpadate, "FU", true);


        Usuario u = buscarUsuario(nomeUs, senhaUs);

        if (query != null)
            return u;

        return null;
    }

    public List<Usuario> buscarUsuariosGrupo(String codGrupo) {

        List<Usuario> listUsuario = buscarTodosUsuarios();

        List<Usuario> listUsuarioGrupo = new ArrayList<Usuario>();

        for (Usuario u: listUsuario) {
            if(u.getCodGrupo().equals(codGrupo)){
                listUsuarioGrupo.add(u);
            }
        }
        if(!listUsuarioGrupo.isEmpty()){
            return listUsuarioGrupo;
        }

        return null;
    }
}
