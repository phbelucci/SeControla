package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.BDFabricaConexao;
import entity.Usuario;

public class UsuarioDAO {



    public boolean inserir(String nome, String senha){


        Boolean retorno = false;

        /*String sql = "INSERT "+"INTO USUARIO(NOME_US, SENHA_US, COD_NIVEL_ACESSO, COD_GRUPO)"+"values"+"(" +
                "'"+u.getNomeUs()+"',"+
                "'"+u.getSenhaUs()+"',"+
                u.getCodNivelAcesso().toString()+","+
                u.getCodGrupo().toString()+");";*/
        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            String sql = "INSERT  NOME_US from USUARIO;";
            Statement stm = (Statement) con.createStatement();
            ResultSet rset = stm.executeQuery(sql);

            while (rset.next()) {
                System.out.print(rset.getInt("COD_US"));
                System.out.println(rset.getString("NOME_US"));
                System.out.println(rset.getString("SENHA_US"));
                System.out.print(rset.getInt("COD_NIVEL_ACESSO"));
                System.out.print(rset.getInt("COD_GRUPO"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


        return retorno;
    }

}
