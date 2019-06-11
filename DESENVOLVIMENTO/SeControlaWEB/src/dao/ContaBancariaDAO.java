package dao;

import connection.BDFabricaConexao;
import entity.ContaBancaria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ContaBancariaDAO {
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


    public List<ContaBancaria> buscarTodasContasBancarias(Integer codGrupo) {
        return null;
    }

    public List<ContaBancaria> buscarTodasContasBancariasUsuario(Integer codUs) {
        return null;
    }

    public ContaBancaria inserirContaBancaria(Integer codUs) {

        return null;
    }

    public boolean deletaContaBancaria(Integer codContaBancaria) {

        return true;
    }
}
