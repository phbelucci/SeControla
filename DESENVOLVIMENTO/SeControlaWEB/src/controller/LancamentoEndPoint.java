package controller;

import entity.Lancamento;

import javax.ws.rs.*;
import java.util.List;

@Path("lacamento/")
public class LancamentoEndPoint {


    @GET
    @Path("get/all/{codGrupo}")
    @Produces("applicattion/json")
    public List<Lancamento> getTodosLacamentos(@PathParam("codGrupo") Integer codGrupo) {


        return null;
    }

    @GET
    @Path("get/us/{codUs}")
    @Produces("applicattion/json")
    public List<Lancamento> getTodosLancamentosUsuario(@PathParam("codUs") Integer codUs) {


        return null;
    }

    @PUT
    @Path("put/{INSERIR_TODOS_DADOS}")
    @Produces("applicattion/json")
    public Lancamento insereLancamento(@PathParam("INSERIR_TODOS_DADOS") Integer codUs) {


        return null;
    }

    @DELETE
    @Path("delete/{codLancamento}")
    @Produces("applicattion/json")
    public String deletaLancamento(@PathParam("codLancamento") Integer codLancamento) {

        //return "ok";
        return "null";
    }


}
