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
        UsuarioDAO dao = new UsuarioDAO();

        Gson g = new Gson();

        return g.toJson(dao.buscarTodosUsuarios());
    }

    @GET
    @Path("get/{nome}/{senha}")
    @Produces("applicattion/json")
    public String getUsuario(@PathParam("nome") String nome, @PathParam("senha") String senha) {
    //public String getUsuario() {
        UsuarioDAO dao = new UsuarioDAO();

        Gson g = new Gson();

        return g.toJson(dao.buscarUsuario(nome, senha));

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
