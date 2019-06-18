package dao;

import com.mysql.cj.jdbc.CallableStatement;
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
    CallableStatement stmt;

    int rset;
    ResultSet rsetAux;


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
                    return stmt.executeQuery(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<ContaBancaria> buscarTodasContasBancarias(Integer codGrupo) {
        List<ContaBancaria> listAll = new ArrayList<ContaBancaria>();

        String sql = "SELECT * FROM CONTA_BANCO WHERE COD_GRUPO="+codGrupo.toString()+";";

        ContaBancaria u;

        try {

            ResultSet query = (ResultSet) conectaBD(sql, "SE", true);

            while (query.next()) {
                    u = new ContaBancaria();
                    u.setCodConta(query.getInt("COD_CONTA"));
                    u.setNumConta(query.getInt("NUM_CONTA"));
                    u.setNumAgencia(query.getInt("NUM_AGENCIA"));
                    u.setSaldo(query.getDouble("SALDO"));
                    u.setCodGrupo(query.getInt("COD_GRUPO"));

                    listAll.add(u);
            }

            if(!listAll.isEmpty()){
                return listAll;
            }else return null;
        } catch (SQLException e) {
            Logger.getLogger(ContaBancariaDAO.class.getName()).log(Level.SEVERE, null, e);
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

//    public List<ContaBancaria> buscarTodasContasBancariasUsuario(Integer codUs) {
//        List<ContaBancaria> listAll = new ArrayList<ContaBancaria>();
//
//        String sql = "SELECT * FROM CONTA_BANCO WHERE COD_GRUPO="+codUs.toString()+";";
//
//        ContaBancaria u;
//
//        try {
//            ResultSet query = (ResultSet) conectaBD(sql, "SE", true);
//
//            while (query.next()) {
//                u = new ContaBancaria();
//                u.setCodConta(query.getInt("COD_CONTA"));
//                u.setNumConta(query.getInt("NUM_CONTA"));
//                u.setNumAgencia(query.getInt("NUM_AGENCIA"));
//                u.setSaldo(query.getDouble("VALOR"));
//                u.setCodGrupo(query.getInt("COD_GRUPO"));
//
//                listAll.add(u);
//            }
//
//            if(!listAll.isEmpty()){
//                return listAll;
//            }else return null;
//        } catch (SQLException e) {
//            Logger.getLogger(ContaBancariaDAO.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            try {
//                con.close();
//                stm.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return null;
//    }

    public ContaBancaria inserirContaBancaria(Integer codGrupo, Integer numConta, Integer numAgencia, Double saldo) {
        String sqlInsert = "INSERT INTO CONTA_BANCO(COD_GRUPO, NUM_CONTA, NUM_AGENCIA, SALDO) VALUES ("
                + codGrupo + ","
                + numConta + ","
                + numAgencia + ","
                + saldo + ");";


        Integer connection = (Integer) conectaBD(sqlInsert, "UP", true);

        if(connection>=1){
            List<ContaBancaria> c = buscarTodasContasBancarias(codGrupo);

            for (ContaBancaria conta : c) {
                if (conta.getNumConta().equals(numConta)) {
                    ContaBancaria contaCriada = conta;
                    try {
                        con.close();
                        stm.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return contaCriada;
                }
            }
        }

        try {
            con.close();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean deletaContaBancaria(Integer codContaBancaria) {

        String sqlDelete = "DELETE FROM CONTA_BANCO WHERE COD_CONTA=" + codContaBancaria + ";";

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

}
