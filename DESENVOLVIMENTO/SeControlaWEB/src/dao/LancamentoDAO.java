package dao;

import com.mysql.cj.jdbc.CallableStatement;
import connection.BDFabricaConexao;
import entity.Lancamento;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LancamentoDAO {
    Connection con;
    Statement stm;
    CallableStatement stmt;

    int rset;
    ResultSet rsetAux;

    String sql = "SELECT * FROM LANCAMENTO;";

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


    public List<Lancamento> buscarTodosLancamentos(Integer codGrupo) {

        List<Lancamento> allLancamentos;
        Lancamento l;

        try {
            allLancamentos = new ArrayList<Lancamento>();

            ResultSet query = (ResultSet) conectaBD(sql, "SE", true);

            while (query.next()) {
                if (query.getInt("COD_GRUPO") == codGrupo) {
                    l = new Lancamento();
                    l.setCodLanc(query.getInt("COD_LANC"));
                    l.setCodGrupo(query.getInt("COD_GRUPO"));
                    l.setCodUs(query.getInt("COD_US"));
                    l.setCat(query.getInt("COD_CAT"));
                    l.setDataString(query.getString("DATA_LANC"));
                    l.setSubCat(query.getInt("COD_SUBCAT"));
                    l.setValor(query.getDouble("VALOR"));
                    l.setCodConta(query.getInt("COD_CONTA"));
                    l.setFormaPagamento(query.getInt("COD_FORMA_PGTO"));
                    l.setCodGrupo(query.getInt("COD_GRUPO"));
                    l.setTipoLancamentoEnum(query.getString("TIPO_LANC_ENUM"));

                    allLancamentos.add(l);
                }
            }
            if (!allLancamentos.isEmpty()) {
                return allLancamentos;
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

    public List<Lancamento> buscarTodosLancamentosUsuario(Integer codUs) {
        String sql = "SELECT * FROM LANCAMENTO";

        List<Lancamento> allLancamentos;
        Lancamento l;

        try {

            allLancamentos = new ArrayList<Lancamento>();

            ResultSet query = (ResultSet) conectaBD(sql, "SE", true);

            while (query.next()) {
                if (query.getInt("COD_US") == codUs) {
                    l = new Lancamento();
                    l.setCodLanc(query.getInt("COD_LANC"));
                    l.setCodGrupo(query.getInt("COD_GRUPO"));
                    l.setCodUs(query.getInt("COD_US"));
                    l.setCat(query.getInt("COD_CAT"));
                    l.setDataString(query.getString("DATA_LANC"));
                    l.setSubCat(query.getInt("COD_SUBCAT"));
                    l.setValor(query.getDouble("VALOR"));
                    l.setCodConta(query.getInt("COD_CONTA"));
                    l.setFormaPagamento(query.getInt("COD_FORMA_PGTO"));
                    l.setCodGrupo(query.getInt("COD_GRUPO"));
                    l.setTipoLancamentoEnum(query.getString("TIPO_LANC_ENUM"));

                    allLancamentos.add(l);
                }
            }
            if (!allLancamentos.isEmpty()) {
                return allLancamentos;
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

    public boolean deletaLancamento(Integer codLancamento) {

        String sqlDelete = "DELETE FROM LANCAMENTO WHERE COD_LANC = " + codLancamento + ";";

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

    public Lancamento inserirLancamento(Integer codUs,
                                        String data,
                                        Integer codCat,
                                        Integer codSubCat,
                                        Double valor,
                                        Integer codConta,
                                        Integer codPagamento,
                                        Integer codGrupo,
                                        String tipoLanc) {

        String sqlInsert;

        if (codSubCat != null) {
            sqlInsert = "INSERT INTO LANCAMENTO(COD_US, DATA_LANC, COD_CAT, COD_SUBCAT, VALOR,COD_CONTA, COD_FORMA_PGTO,COD_GRUPO,TIPO_LANC_ENUM) "
                    + "VALUES (" + codUs.toString() + ", '" + data + "' ," + codCat.toString() + ", " + codSubCat.toString() + ", " + valor.toString() + ", " + codConta.toString()
                    + ", " + codPagamento.toString() + ", " + codGrupo.toString() + ", '" + tipoLanc + "');";
        } else {
            sqlInsert = "INSERT INTO LANCAMENTO(COD_US, DATA_LANC, COD_CAT, VALOR,COD_CONTA, COD_FORMA_PGTO,COD_GRUPO,TIPO_LANC_ENUM) "
                    + "VALUES (" + codUs.toString() + ", '" + data + "' ," + codCat.toString() + ", " + valor.toString() + ", " + codConta.toString()
                    + ", " + codPagamento.toString() + ", " + codGrupo.toString() + ", '" + tipoLanc + "');";
        }

        conectaBD(sqlInsert, "UP", true);//false para não realizar a conexão novamente
        try {
            con.close();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        List<Lancamento> lancUsuario = buscarTodosLancamentosUsuario(codUs);

        for (Lancamento c : lancUsuario) {
            if (c.getDataString().equals(data) && c.getValor().equals(valor)) {
                return c;
            }
        }

        return null;

    }
}
