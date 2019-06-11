package controller;

import com.google.gson.Gson;
import dao.ContaBancariaDAO;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/contabancaria")
public class ContaBancariaEndPoint {
    @GET
    @Path("/get/grupo/{codGrupo}")
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
    @Path("/put/{codGrupo}/{numConta}/{numAgencia}/{saldo}") //(COD_GRUPO, NUM_CONTA, NUM_AGENCIA, SALDO)
    @Produces("applicattion/json")
    public String insereContaBancaria(@PathParam("codGrupo") Integer codGrupo,
                                      @PathParam("numConta") Integer numConta,
                                      @PathParam("numAgencia") Integer numAgencia,
                                      @PathParam("saldo") Double saldo) {//precisa arrumar para conter todos os dados do ContaBancaria
        ContaBancariaDAO dao = new ContaBancariaDAO();
        Gson g = new Gson();
        return g.toJson(dao.inserirContaBancaria(codGrupo, numConta, numAgencia, saldo)); //precisa arrumar para conter todos os dados do ContaBancaria
    }

    @DELETE
    @Path("/delete/{codContaBancaria}")
    @Produces("applicattion/json")
    public String deletaContaBancaria(@PathParam("codContaBancaria") Integer codContaBancaria) {
        ContaBancariaDAO dao = new ContaBancariaDAO();
        Gson g = new Gson();

        if (dao.deletaContaBancaria(codContaBancaria)) {
            return g.toJson("ok");
        }

        return g.toJson("null");
    }

    @POST
    @Path("/update/{codGrupo}/{numConta}/{numAgencia}/{saldo}")
    @Produces("applicattion/json")
    public String atualizaContaBancaria(@PathParam("codGrupo") Integer codGrupo,
                                        @PathParam("numConta") Integer numConta,
                                        @PathParam("numAgencia") Integer numAgencia,
                                        @PathParam("saldo") Double saldo) {//precisa arrumar para conter todos os dados do ContaBancaria

        //implementação futura
        //return "ok";
        return null;
    }
}
