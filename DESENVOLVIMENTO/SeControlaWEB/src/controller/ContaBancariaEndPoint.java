package controller;

import com.google.gson.Gson;
import dao.ContaBancariaDAO;

import javax.ws.rs.*;

@Path("contabancaria/")
public class ContaBancariaEndPoint {
    @GET
    @Path("get/grupo/{codGrupo}")
    @Produces("applicattion/json")
    public String getTodasContasBancarias(@PathParam("codGrupo") Integer codGrupo) {
        ContaBancariaDAO dao = new ContaBancariaDAO();
        Gson g = new Gson();
        return g.toJson(dao.buscarTodasContasBancarias(codGrupo));
    }

    /* Não temos registro de codUs na conta, somente grupo
    @GET
    @Path("get/us/{codUs}")
    @Produces("applicattion/json")
    public String getTodasContasBancariasUsuario(@PathParam("codUs") Integer codUs) {
        ContaBancariaDAO dao = new ContaBancariaDAO();
        Gson g = new Gson();
        return g.toJson(dao.buscarTodasContasBancariasUsuario(codUs));
    }*/

    @PUT
    @Path("put/{INSERIR_TODOS_DADOS}")
    @Produces("applicattion/json")
    public String insereContaBancaria(@PathParam("INSERIR_TODOS_DADOS") Integer codUs) {//precisa arrumar para conter todos os dados do ContaBancaria
        ContaBancariaDAO dao = new ContaBancariaDAO();
        Gson g = new Gson();
        return g.toJson(dao.inserirContaBancaria(codUs)); //precisa arrumar para conter todos os dados do ContaBancaria
    }

    @DELETE
    @Path("delete/{codContaBancaria}")
    @Produces("applicattion/json")
    public String deletaContaBancaria(@PathParam("codContaBancaria") Integer codContaBancaria) {
        ContaBancariaDAO dao = new ContaBancariaDAO();
        Gson g = new Gson();

        if(dao.deletaContaBancaria(codContaBancaria)){
            return g.toJson("ok");
        }

        return g.toJson("null");
    }


    
    @POST
    @Path("update/{INSERIR_TODOS_DADOS}")
    @Produces("applicattion/json")
    public String atualizaContaBancaria(@PathParam("INSERIR_TODOS_DADOS") Integer codUs) {

        //implementação futura
        //return "ok";
        return null;
    }
}
