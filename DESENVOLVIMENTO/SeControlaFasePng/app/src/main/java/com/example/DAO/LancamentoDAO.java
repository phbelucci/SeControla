package com.example.DAO;
import android.util.Log;
import com.example.entity.Lancamento;
import com.example.service.HTTPService;
import com.example.service.HTTPServiceFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Console;
import java.util.List;

public class LancamentoDAO {

    public List<Lancamento> getLancamentosGrupo(Integer codGrupo) {
        String resposta = "";

        HTTPService requisicao = HTTPServiceFactory.criaHTTPService("GET",
                "lancamento/get/all/"+codGrupo);

        try {
            resposta = requisicao.execute().get();
        } catch (Exception e){
            e.printStackTrace();
        }

        //Converte Json em Usuario e retorna
        return new Gson().fromJson(resposta, new TypeToken<List<Lancamento>>(){}.getType());
    }

    public Lancamento salvar(Integer codUs, String dataString, Integer cat,
                             Integer subCat,  Double valor, Integer codConta,
                             Integer formaPagamento, Integer codGrupo, String tipoLanc){
        //POST
        String resposta = "";
        HTTPService requisicao = HTTPServiceFactory.criaHTTPService("POST",
                "lancamento/post/"+codUs+"/"+dataString+"/"+cat+"/"+subCat+"/"+valor+"/"+
                        codConta+"/"+formaPagamento+"/"+codGrupo+"/"+tipoLanc);

        try {
            resposta = requisicao.execute().get();
            System.out.println("RESP HTTP: " + resposta);
        } catch (Exception e){
            e.printStackTrace();
        }

        //Converte Json em Usuario e retorna
        return new Gson().fromJson(resposta, Lancamento.class);
    }

    public String deletar(int codLanc){
        String resposta = "";

        HTTPService requisicao = HTTPServiceFactory.criaHTTPService("DELETE",
                "lancamento/delete/"+codLanc);

        try {
            resposta = requisicao.execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resposta;
    }

}
