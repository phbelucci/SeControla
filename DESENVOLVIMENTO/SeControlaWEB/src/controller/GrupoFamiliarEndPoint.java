package controller;

import com.google.gson.Gson;
import dao.GrupoFamiliarDAO;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/grupofamiliar")
public class GrupoFamiliarEndPoint {

    @GET
    @Path("/get/all")
    @Produces("applicattion/json")
    public String getTodosGrupos() {
        //public String getUsuario() {

        GrupoFamiliarDAO dao = new GrupoFamiliarDAO();

        Gson g = new Gson();

        return g.toJson(dao.getTodosGrupos());

    }

    @GET
    @Path("/get/{codGrupo}") //retorna grupo dado um determinado codigo grupo
    @Produces("applicattion/json")
    public String getGrupo(@PathParam("codGrupo") Integer codGrupo) {
        //public String getUsuario() {

        GrupoFamiliarDAO dao = new GrupoFamiliarDAO();

        Gson g = new Gson();

        return g.toJson(dao.getGrupo(codGrupo));

    }

    @GET
    @Path("/get/usuario/{codUs}") //retorna grupo dado um determinado usuario
    @Produces("applicattion/json")
    public String getGrupoUsuario(@PathParam("codUs") Integer codUs) {
        //public String getUsuario() {

        GrupoFamiliarDAO dao = new GrupoFamiliarDAO();

        Gson g = new Gson();

        return g.toJson(dao.getGrupoUsuario(codUs));
    }

    @PUT
    @Path("/put/{codUs}")
    @Produces("applicattion/json")
    public String inserirNovoGrupo(@PathParam("codUs") Integer codUs) {
        //public String getUsuario() {

        GrupoFamiliarDAO dao = new GrupoFamiliarDAO();

        Gson g = new Gson();

        return g.toJson(dao.inserirNovoGrupo(codUs));

    }

    @DELETE
    @Path("/delete/{codGrupo}")
    @Produces("applicattion/json")
    public String deletaUsuario(@PathParam("codGrupo") Integer codGrupo) {
        GrupoFamiliarDAO dao = new GrupoFamiliarDAO();
        Gson g = new Gson();

        if (dao.deletaGrupo(codGrupo)) {
            return g.toJson("ok");
        }

        return g.toJson("null");
    }

    @POST
    @Path("/update/{codGrupo}/{codUs}")
    @Produces("applicattion/json") //(COD_GRUPO; COD_ADM_GRUPO)
    public String atualizaContaBancaria(@PathParam("codGrupo") Integer codGrupo,
                                        @PathParam("codUs") Integer codUs) {

        // USUARIO(NOME_US, SENHA_US, COD_NIVEL_ACESSO, COD_GRUPO)
        GrupoFamiliarDAO dao = new GrupoFamiliarDAO();

        Gson g = new Gson();

        return g.toJson(dao.atualizarGrupo(codGrupo, codUs));
    }
}
