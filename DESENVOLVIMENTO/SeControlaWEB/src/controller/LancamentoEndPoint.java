package controller;

import com.google.gson.Gson;
import dao.LancamentoDAO;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/lacamento")
public class LancamentoEndPoint {


    @GET
    @Path("/get/all/{codGrupo}")
    @Produces("applicattion/json")
    public String getTodosLacamentos(@PathParam("codGrupo") Integer codGrupo) {
        LancamentoDAO dao = new LancamentoDAO();
        Gson g = new Gson();
        return g.toJson(dao.buscarTodosLancamentos(codGrupo));
    }

    @GET
    @Path("/get/us/{codUs}")
    @Produces("applicattion/json")
    public String getTodosLancamentosUsuario(@PathParam("codUs") Integer codUs) {
        LancamentoDAO dao = new LancamentoDAO();
        Gson g = new Gson();
        return g.toJson(dao.buscarTodosLancamentosUsuario(codUs));
    }

    @PUT //(COD_US, DATA_LANC, COD_CAT, COD_SUBCAT, VALOR,COD_CONTA, COD_FORMA_PGTO,COD_GRUPO,TIPO_LANC_ENUM)
    @Path("/put/{codUs}/{data}/{codCat}/{codSubCat}/{valor}/{codConta}/{codPagamento}/{codGrupo}/{tipoLanc}")
    @Produces("applicattion/json")
    public String insereLancamento(@PathParam("codUs") Integer codUs,
                                   @PathParam("data") String data,
                                   @PathParam("codCat") Integer codCat,
                                   @PathParam("codSubCat") Integer codSubCat,
                                   @PathParam("valor") Double valor,
                                   @PathParam("codConta") Integer codConta,
                                   @PathParam("codPagamento") Integer codPagamento,
                                   @PathParam("codGrupo") Integer codGrupo,
                                   @PathParam("tipoLanc") String tipoLanc) {//precisa arrumar para conter todos os dados do lancamento
        LancamentoDAO dao = new LancamentoDAO();
        Gson g = new Gson();
        return g.toJson(dao.inserirLancamento(codUs, data, codCat, codSubCat, valor, codConta, codPagamento, codGrupo, tipoLanc)); //precisa arrumar para conter todos os dados do lancamento
    }

    @DELETE
    @Path("/delete/{codLancamento}")
    @Produces("applicattion/json")
    public String deletaLancamento(@PathParam("codLancamento") Integer codLancamento) {
        LancamentoDAO dao = new LancamentoDAO();
        Gson g = new Gson();

        if (dao.deletaLancamento(codLancamento)) {
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
