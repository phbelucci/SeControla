package dao;

import connection.BDFabricaConexao;
import entity.Lancamento;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class LancamentoDAO {
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

    public List<Lancamento> buscarTodosLancamentos(Integer codGrupo) {
        return null;
    }

    public List<Lancamento> buscarTodosLancamentosUsuario(Integer codUs) {
        return null;
    }

    public Lancamento inserirLancamento(Integer codUs) {
        return null;
    }

    public boolean deletaLancamento(Integer codLancamento) {
        return true;
    }



}
