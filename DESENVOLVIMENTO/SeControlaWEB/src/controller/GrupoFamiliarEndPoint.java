package controller;

import com.google.gson.Gson;
import dao.GrupoFamiliarDAO;
import dao.UsuarioDAO;
import entity.GrupoFamiliar;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("grupofamiliar/")
public class GrupoFamiliarEndPoint {

    @GET
    @Path("get/{cod}")
    @Produces("applicattion/json")
    public String getUsuario(@PathParam("cod") Integer codUs) {
        //public String getUsuario() {

        GrupoFamiliarDAO dao = new GrupoFamiliarDAO();

        Gson g = new Gson();

        return g.toJson(dao.inserirNovoGrupo(codUs));

    }


}
