package com.example.DAO;

import com.example.entity.ContaBancaria;
import com.example.entity.Lancamento;
import com.example.service.HTTPServiceGET;
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
}
