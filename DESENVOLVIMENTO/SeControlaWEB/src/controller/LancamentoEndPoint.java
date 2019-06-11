package controller;

import com.google.gson.Gson;
import dao.LancamentoDAO;
import dao.UsuarioDAO;
import entity.Lancamento;

import javax.ws.rs.*;
import java.util.List;

@Path("lacamento/")
public class LancamentoEndPoint {


    @GET
    @Path("get/all/{codGrupo}")
    @Produces("applicattion/json")
    public String getTodosLacamentos(@PathParam("codGrupo") Integer codGrupo) {
        LancamentoDAO dao = new LancamentoDAO();
        Gson g = new Gson();
        return g.toJson(dao.buscarTodosLancamentos(codGrupo));
    }

    @GET
    @Path("get/us/{codUs}")
    @Produces("applicattion/json")
    public String getTodosLancamentosUsuario(@PathParam("codUs") Integer codUs) {
        LancamentoDAO dao = new LancamentoDAO();
        Gson g = new Gson();
        return g.toJson(dao.buscarTodosLancamentosUsuario(codUs));
    }

    @PUT
    @Path("put/{INSERIR_TODOS_DADOS}")
    @Produces("applicattion/json")
    public String insereLancamento(@PathParam("INSERIR_TODOS_DADOS") Integer codUs) {//precisa arrumar para conter todos os dados do lancamento
        LancamentoDAO dao = new LancamentoDAO();
        Gson g = new Gson();
        return g.toJson(dao.inserirLancamento(codUs)); //precisa arrumar para conter todos os dados do lancamento
    }

    @DELETE
    @Path("delete/{codLancamento}")
    @Produces("applicattion/json")
    public String deletaLancamento(@PathParam("codLancamento") Integer codLancamento) {
        LancamentoDAO dao = new LancamentoDAO();
        Gson g = new Gson();

        if(dao.deletaLancamento(codLancamento)){
            return g.toJson("ok");
        }

        return g.toJson("null");
    }


    /*
    @POST
    @Path("update/{INSERIR_TODOS_DADOS}")
    @Produces("applicattion/json")
    public Lancamento atualizaLancamento(@PathParam("INSERIR_TODOS_DADOS") Integer codUs) {

        //implementação futura
        //return "ok";
        return null;
    }*/

}
