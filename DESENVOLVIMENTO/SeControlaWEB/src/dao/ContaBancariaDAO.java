package dao;

import connection.BDFabricaConexao;
import entity.ContaBancaria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContaBancariaDAO {
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

    public List<ContaBancaria> buscarTodasContasBancarias(Integer codGrupo) {
        List<ContaBancaria> listAll = new ArrayList<ContaBancaria>();

        String sql = "SELECT * FROM CONTA_BANCO";

        ContaBancaria u;

        try {

            /*
            this.con = (Connection) BDFabricaConexao.getConnection();

            this.stm = (Statement) con.createStatement();
            ResultSet rset = stm.executeQuery(sql);*/

            ResultSet query = (ResultSet) conectaBD(sql,"SE", true);

            while (query.next()) {
                u = new ContaBancaria();
                u.setCodConta(query.getInt("COD_CONTA"));
                u.setNumConta(query.getInt("NUM_CONTA"));
                u.setNumAgencia(query.getInt("NUM_AGENCIA"));
                u.setCodGrupo(query.getInt("COD_GRUPO"));

                listAll.add(u);
            }
        }catch (SQLException e) {
            Logger.getLogger(ContaBancariaDAO.class.getName()).log(Level.SEVERE, null, e);
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

    public ContaBancaria inserirContaBancaria(Integer codGrupo, Integer numConta, Integer numAgencia, Double saldo) {
        String sqlInsert = "INSERT INTO CONTA_BANCO(COD_GRUPO, NUM_CONTA, NUM_AGENCIA, SALDO) VALUES ("
                +codGrupo+","
                +numConta+","
                +numAgencia+","
                +saldo+");";
        String sqlSelect = "SELECT * FROM CONTA_BANCO;";

        ContaBancaria u;

        try {
            Integer connection = (Integer) conectaBD(sqlInsert,"UP", true);
            ResultSet query = (ResultSet) conectaBD(sqlSelect,"SE", false);//false para não realizar a conexão novamente

            u = new ContaBancaria();

            while (query.next()) {
                if (query.getInt("NUM_CONTA")==numConta && query.getInt("NUM_AGENCIA") == numAgencia ) {
                    u.setCodConta(query.getInt("COD_CONTA"));
                    u.setNumConta(query.getInt("NUM_CONTA"));
                    u.setNumAgencia(query.getInt("NUM_AGENCIA"));
                    u.setCodGrupo(query.getInt("COD_GRUPO"));
                }
            }

            return u;

        } catch (SQLException e) {
            e.printStackTrace();
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

    public boolean deletaContaBancaria(Integer codContaBancaria) {

        String sqlDelete = "DELETE INTO CONTA_BANCO WHERE COD_CONTA="+codContaBancaria+";";

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
}
