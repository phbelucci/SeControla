package com.example.DAO;

import com.example.entity.ContaBancaria;
import com.example.entity.Lancamento;
import com.example.entity.Usuario;
import com.example.service.HTTPServiceGET;
import com.example.service.HTTPServicePOST;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class LancamentoDAO {

    public List<Lancamento> getLancamentosGrupo(Integer codGrupo) {
        String resposta = "";

        HTTPServiceGET requisicao = new HTTPServiceGET("GET", "lancamento/get/all/"+codGrupo, "JSON");

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
        HTTPServicePOST requisicao = new HTTPServicePOST("POST", "lancamento/post/"+codUs+"/"+dataString+
                                                                                "/"+cat+"/"+subCat+"/"+valor+"/"+codConta+
                                                                                "/"+formaPagamento+"/"+codGrupo+"/"+tipoLanc,
                                                                                "JSON");

        try {
            resposta = requisicao.execute().get();
            System.out.println("RESP HTTP: " + resposta);
        } catch (Exception e){
            e.printStackTrace();
        }

        //Converte Json em Usuario e retorna
        return new Gson().fromJson(resposta, Lancamento.class);
    }

}
