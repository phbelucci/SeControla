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

    private void conectaBD(String sql, String tipo){
        try {
            this.con = (Connection) BDFabricaConexao.getConnection();
            this.stm = (Statement) con.createStatement();
            if (tipo.equals("UP")){
                this.rset = stm.executeUpdate(sql);

            }else if(tipo.equals("IN")){
                this.rsetGet = stm.executeQuery(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
