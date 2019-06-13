package com.example.DAO;

import com.example.entity.GrupoFamiliar;
import com.example.entity.Usuario;
import com.example.service.HTTPServiceGET;
import com.google.gson.Gson;

public class GrupoFamiliarDAO {

    public GrupoFamiliar getGrupo(Integer codUS){
        String resposta = "";
        HTTPServiceGET requisicao = new HTTPServiceGET("GET", "grupofamiliar/get/usuario/"+codUS, "JSON");

        try {
            resposta = requisicao.execute().get();
            System.out.println(resposta);
        } catch (Exception e){
            e.printStackTrace();
        }

        //Converte Json em Usuario e retorna
        return new Gson().fromJson(resposta, GrupoFamiliar.class);
    }
}
