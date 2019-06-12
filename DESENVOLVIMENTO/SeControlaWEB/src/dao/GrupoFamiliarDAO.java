package dao;

import connection.BDFabricaConexao;
import entity.GrupoFamiliar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrupoFamiliarDAO {

    Connection con;
    Statement stm;
    int rset;
    ResultSet rsetGet;

    private Object conectaBD(String sql, String tipo, boolean connection) {
        try {
            if (connection) {
                this.con = (Connection) BDFabricaConexao.getConnection();
            }
            this.stm = (Statement) con.createStatement();
            if (tipo.equals("UP")) {
                this.rset = stm.executeUpdate(sql);
                return rset;

            } else if (tipo.equals("SE")) {
                this.rsetGet = stm.executeQuery(sql);
                return rsetGet;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<GrupoFamiliar> getTodosGrupos() {

        List<GrupoFamiliar> listAll = new ArrayList<GrupoFamiliar>();

        String sqlAll = "select * from GRUPO_FAMILIAR;";

        try {
            ResultSet query = (ResultSet) conectaBD(sqlAll, "SE", true);

            while (query.next()) {
                GrupoFamiliar g = new GrupoFamiliar();

                g.setCodGrupo(rsetGet.getInt("COD_GRUPO"));
                g.setCodAdmGrupo(rsetGet.getInt("COD_ADM_GRUPO"));

                listAll.add(g);
            }

            return listAll;
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

    public GrupoFamiliar getGrupo(Integer codGrupo) {

        GrupoFamiliar g;
        String sqlAll = "select * from GRUPO_FAMILIAR;";

        try {
            ResultSet query = (ResultSet) conectaBD(sqlAll, "SE", true);

            g = new GrupoFamiliar();

            while (query.next()) {
                if (query.getInt("COD_GRUPO") == codGrupo) {
                    g.setCodGrupo(query.getInt("COD_GRUPO"));
                    g.setCodAdmGrupo(query.getInt("COD_ADM_GRUPO"));
                }
            }
            return g;
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

    public GrupoFamiliar getGrupoUsuario(Integer codUs) {

        GrupoFamiliar g;
        String sqlAll = "select * from GRUPO_FAMILIAR;";

        try {
            ResultSet query = (ResultSet) conectaBD(sqlAll, "SE", true);

            g = new GrupoFamiliar();

            while (query.next()) {
                if (query.getInt("COD_ADM_GRUPO") == codUs) {
                    g.setCodGrupo(query.getInt("COD_GRUPO"));
                    g.setCodAdmGrupo(query.getInt("COD_ADM_GRUPO"));
                }
            }
            return g;
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

    public GrupoFamiliar inserirNovoGrupo(Integer codUs) {

        GrupoFamiliar g = new GrupoFamiliar();

        String sqlInsert = "INSERT INTO GRUPO_FAMILIAR(COD_ADM_GRUPO)" +
                "VALUES (" + codUs.toString() + ");";

        try {
            this.con = (Connection) BDFabricaConexao.getConnection();
            this.stm = (Statement) con.createStatement();
            int rset = stm.executeUpdate(sqlInsert);

            String sqlGet = "SELECT * FROM GRUPO_FAMILIAR WHERE COD_ADM_GRUPO =" + codUs.toString() + ";";

            this.stm = (Statement) con.createStatement();
            ResultSet rsetGet = stm.executeQuery(sqlGet);


            if (rsetGet.next()) {
                g.setCodGrupo(rsetGet.getInt("COD_GRUPO"));
                g.setCodAdmGrupo(rsetGet.getInt("COD_ADM_GRUPO"));
            }

            return g;

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

    public boolean deletaGrupo(Integer codGrupo) {

        String sqlDelete = "DELETE FROM GRUPO_FAMILIAR WHERE COD_GRUPO=" + codGrupo + ";";

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

    public boolean atualizarGrupo(Integer codGrupo, Integer codUs) {
        String sqlUpdate = "UPDATE GRUPO_FAMILIAR SET COD_ADM_GRUPO="
                + codUs.toString() + " WHERE COD_GRUPO ="
                + codGrupo.toString() + ";";

        Integer aux = (Integer) conectaBD(sqlUpdate, "UP", true);

        if (aux >= 1) {
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
