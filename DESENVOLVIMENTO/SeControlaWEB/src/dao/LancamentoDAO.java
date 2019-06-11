package dao;

import connection.BDFabricaConexao;
import entity.FormaPagamentoEnum;
import entity.Lancamento;
import entity.TipoLancamentoEnum;
import entity.Usuario;

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

        String sql = "SELECT * FROM LANCAMENTO";

        List<Lancamento> allLancamentos;
        Lancamento l;

        try {//(, DATA_LANC, COD_CAT, COD_SUBCAT, VALOR,COD_CONTA, COD_FORMA_PGTO,COD_GRUPO,TIPO_LANC_ENUM)

            allLancamentos = new ArrayList<Lancamento>();

            ResultSet query = (ResultSet) conectaBD(sql,"SE", true);

            while (query.next()) {
                if (query.getInt("COD_GRUPO") == codGrupo) {
                    l = new Lancamento();
                    l.setCodGrupo(query.getInt("COD_GRUPO"));
                    l.setCodUs(query.getInt("COD_US"));
                    l.setCat(query.getInt("COD_CAT"));
                    l.setSubCat(query.getInt("COD_SUBCAT"));
                    l.setValor(query.getDouble("VALOR"));
                    l.setCodConta(query.getInt("COD_CONTA"));
                    l.setFormaPagamento(query.getInt("COD_FORMA_PGTO"));
                    l.setCodGrupo(query.getInt("COD_GRUPO"));
                    l.setTipoLancamentoEnum(query.getString("TIPO_LANC_ENUM"));

                    allLancamentos.add(l);
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

    public List<Lancamento> buscarTodosLancamentosUsuario(Integer codUs) {
        String sql = "SELECT * FROM LANCAMENTO";

        List<Lancamento> allLancamentos;
        Lancamento l;

        try {

            allLancamentos = new ArrayList<Lancamento>();

            ResultSet query = (ResultSet) conectaBD(sql,"SE", true);

            while (query.next()) {
                if (query.getInt("COD_US") == codUs) {
                    l = new Lancamento();
                    l.setCodGrupo(query.getInt("COD_GRUPO"));
                    l.setCodUs(query.getInt("COD_US"));
                    l.setCat(query.getInt("COD_CAT"));
                    l.setSubCat(query.getInt("COD_SUBCAT"));
                    l.setValor(query.getDouble("VALOR"));
                    l.setCodConta(query.getInt("COD_CONTA"));
                    l.setFormaPagamento(query.getInt("COD_FORMA_PGTO"));
                    l.setCodGrupo(query.getInt("COD_GRUPO"));
                    l.setTipoLancamentoEnum(query.getString("TIPO_LANC_ENUM"));

                    allLancamentos.add(l);
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

    public Lancamento inserirLancamento(Integer codUs) {
        return null;
    }

    public boolean deletaLancamento(Integer codLancamento) {

        String sqlDelete = "DELETE FROM LANCAMENTO WHERE COD_LANC = "+codLancamento+";";

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
