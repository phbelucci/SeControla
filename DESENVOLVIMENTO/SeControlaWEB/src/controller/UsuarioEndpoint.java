package controller;


import com.google.gson.Gson;
import connection.BDFabricaConexao;
import dao.ContaBancariaDAO;
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
        UsuarioDAO dao = new UsuarioDAO();

        Gson g = new Gson();

        return g.toJson(dao.buscarUsuario(nome, senha));

    }

    @PUT
    @Path("put/{nome}/{senha}")
    @Consumes("application/text")
    public String putUsuario(@PathParam("nome") String nome, @PathParam("senha") String senha) {
        UsuarioDAO dao = new UsuarioDAO();

        Gson g = new Gson();

        return g.toJson(dao.inserirUsuarioNovo(nome, senha));
    }

    @DELETE
    @Path("delete/{codUs}")
    @Produces("applicattion/json")
    public String deletaUsuario(@PathParam("codUs") Integer codUs) {
        UsuarioDAO dao = new UsuarioDAO();
        Gson g = new Gson();

        if(dao.deletaUsuario(codUs)){
            return g.toJson("ok");
        }

        return g.toJson("null");
    }



    @POST
    @Path("update/{codUs}/{nomeUs}/{senhaUs}/{codNivelAcesso}/{codGrupo}/")
    @Produces("applicattion/json")
    public String atualizaContaBancaria(@PathParam("codUs") Integer codUs,
                                        @PathParam("nomeUs") Integer nomeUs,
                                        @PathParam("senhaUs") Integer senhaUs,
                                        @PathParam("codNivelAcesso") Integer codNivelAcesso,
                                        @PathParam("codGrupo") Integer codGrupo) {

        // USUARIO(NOME_US, SENHA_US, COD_NIVEL_ACESSO, COD_GRUPO)
        UsuarioDAO dao = new UsuarioDAO();

        Gson g = new Gson();

        return g.toJson(dao.atualizarUsuario(codUs,nomeUs,senhaUs, codNivelAcesso, codGrupo));
    }

}
