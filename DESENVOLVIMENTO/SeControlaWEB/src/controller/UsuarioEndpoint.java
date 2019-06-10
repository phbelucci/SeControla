package controller;


import com.google.gson.Gson;
import connection.BDFabricaConexao;
import dao.UsuarioDAO;
import entity.Usuario;
import javax.ws.rs.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Path("usuario/")
public class UsuarioEndpoint {


    @GET
    @Path("get/all")
    @Produces("applicattion/json")
    //public String getUsuario(@PathParam("nome") String nome, @PathParam("senha") String senha) {
    public String getAllUsuario() {
        String sql = "SELECT * FROM USUARIO";
        List<Usuario> retorno = new ArrayList<>();

        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            //String sql = "select * from USUARIO WHERE NOME_US="
                    //+nome+";";

            Statement stm = (Statement) con.createStatement();
            ResultSet rset = stm.executeQuery(sql);

            while (rset.next()){
                Usuario u = new Usuario();

                u.setCodUs(rset.getInt("COD_US"));
                u.setNomeUs(rset.getString("NOME_US"));
                u.setSenhaUs(rset.getString("SENHA_US"));
                u.setCodNivelAcesso(rset.getInt("COD_NIVEL_ACESSO"));
                u.setCodGrupo(rset.getInt("COD_GRUPO"));

                retorno.add(u);
            }
        }catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        Gson g = new Gson();

        String r = g.toJson(retorno);

        return r;
    }

    @GET
    @Path("get/{nome}/{senha}")
    @Produces("applicattion/json")
    public String getUsuario(@PathParam("nome") String nome, @PathParam("senha") String senha) {
    //public String getUsuario() {
        String sql = "SELECT * FROM USUARIO";

        Usuario u = new Usuario();

        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();

            Statement stm = (Statement) con.createStatement();
            ResultSet rset = stm.executeQuery(sql);

            while (rset.next()) {
                if (rset.getString("NOME_US").equals(nome)||
                                rset.getString("NOME_US").toLowerCase().equals(nome)) {

                    u.setCodUs(rset.getInt("COD_US"));
                    u.setNomeUs(rset.getString("NOME_US"));
                    u.setSenhaUs(rset.getString("SENHA_US"));
                    u.setCodNivelAcesso(rset.getInt("COD_NIVEL_ACESSO"));
                    u.setCodGrupo(rset.getInt("COD_GRUPO"));
                }
            }

        }catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        Gson g = new Gson();

        if(u.verificaSenha(senha)){

            return g.toJson(u);
        }

        return g.toJson("null");

    }

    @PUT
    @Path("put/{nome}/{senha}")
    @Consumes("application/text")
    public boolean puUsuario(@PathParam("nome") String nome, @PathParam("senha") String senha) {

        Usuario u = new Usuario(nome, senha);
        Boolean retorno = false;

        try{
        Connection con = (Connection) BDFabricaConexao.getConnection();
        String sql = "INSERT INTO USUARIO(NOME_US, SENHA_US, COD_NIVEL_ACESSO, COD_GRUPO) VALUES ("
                +u.getNomeUs()+", "
                +u.getSenhaUs()+", "
                +u.getCodNivelAcesso()+", "
                +u.getCodGrupo()+";";

        Statement stm = (Statement) con.createStatement();
        ResultSet rset = stm.executeQuery(sql);


        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

}
