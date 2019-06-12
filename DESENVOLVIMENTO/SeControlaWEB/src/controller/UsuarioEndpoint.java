package controller;


import com.google.gson.Gson;
import dao.UsuarioDAO;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("usuario/")
public class UsuarioEndpoint {


    @GET
    @Path("get/all")
    @Produces("application/json")
    //public String getUsuario(@PathParam("nome") String nome, @PathParam("senha") String senha) {
    public String getAllUsuario() {
        UsuarioDAO dao = new UsuarioDAO();

        Gson g = new Gson();

        return g.toJson(dao.buscarTodosUsuarios());
    }

    @GET
    @Path("get/{nome}/{senha}")
    @Produces("application/json")
    public String getUsuario(@PathParam("nome") String nome, @PathParam("senha") String senha) {

        return "entrou GET usuario";

        /*UsuarioDAO dao = new UsuarioDAO();

        Gson g = new Gson();

        return g.toJson(dao.buscarUsuario(nome, senha));*/

    }

    @POST
    @Path("post/{nome}/{senha}")
    @Produces("application/json")
    public String putUsuario(@PathParam("nome") String nome, @PathParam("senha") String senha) {

        UsuarioDAO dao = new UsuarioDAO();

        Gson g = new Gson();

        return g.toJson(dao.inserirUsuarioNovo(nome, senha));
    }

    @DELETE
    @Path("delete/{codUs}")
    @Produces("application/json")
    public String deletaUsuario(@PathParam("codUs") Integer codUs) {
        UsuarioDAO dao = new UsuarioDAO();
        Gson g = new Gson();

        if(dao.deletaUsuario(codUs)){
            return g.toJson("ok");
        }

        return g.toJson("null");
    }



    @PUT
    @Path("update/{codUs}/{nomeUs}/{senhaUs}/{codNivelAcesso}/{codGrupo}")
    @Produces("application/json")
    public String atualizaContaBancaria(@PathParam("codUs") Integer codUs,
                                        @PathParam("nomeUs") String nomeUs,
                                        @PathParam("senhaUs") String senhaUs,
                                        @PathParam("codNivelAcesso") Integer codNivelAcesso,
                                        @PathParam("codGrupo") Integer codGrupo) {

        UsuarioDAO dao = new UsuarioDAO();

        Gson g = new Gson();

        return g.toJson(dao.atualizarUsuario(codUs,nomeUs,senhaUs, codNivelAcesso, codGrupo));
    }

}
