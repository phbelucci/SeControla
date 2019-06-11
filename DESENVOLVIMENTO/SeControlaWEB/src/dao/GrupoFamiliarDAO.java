package dao;

import connection.BDFabricaConexao;
import entity.GrupoFamiliar;
import entity.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrupoFamiliarDAO {

    Connection con;
    Statement stm;


    public GrupoFamiliar inserirNovoGrupo(Integer codUs){

        GrupoFamiliar g = new GrupoFamiliar();

        String sqlInsert = "INSERT INTO GRUPO_FAMILIAR(COD_ADM_GRUPO)" +
                "VALUES ("+codUs.toString()+");";

        try {
            this.con = (Connection) BDFabricaConexao.getConnection();
            this.stm = (Statement) con.createStatement();
            int rset = stm.executeUpdate(sqlInsert);

            String sqlGet = "SELECT * FROM GRUPO_FAMILIAR WHERE COD_ADM_GRUPO =" +codUs.toString()+";";

            this.stm = (Statement) con.createStatement();
            ResultSet rsetGet = stm.executeQuery(sqlGet);


            if(rsetGet.next()) {
                g.setCodGrupo(rsetGet.getInt("COD_GRUPO"));
                g.setCodAdmGrupo(rsetGet.getInt("COD_ADM_GRUPO"));
            }

            return g;

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
}
