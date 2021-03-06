package com.example.DAO;


import com.example.entity.ContaBancaria;
import com.example.service.HTTPService;
import com.example.service.HTTPServiceFactory;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ContaBancariaDAO {

    public List<ContaBancaria> getContasBancarias(Integer codGrupo) {
        String resposta = "";

        HTTPService requisicao = HTTPServiceFactory.criaHTTPService("GET", "contabancaria/get/grupo/"+codGrupo);

        try {
            resposta = requisicao.execute().get();
        } catch (Exception e){
            e.printStackTrace();
        }

        //Converte Json em Usuario e retorna
        return new Gson().fromJson(resposta, new TypeToken<List<ContaBancaria>>(){}.getType());
    }
}
