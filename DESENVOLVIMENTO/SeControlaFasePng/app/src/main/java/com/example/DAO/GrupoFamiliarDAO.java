package com.example.DAO;

import com.example.entity.GrupoFamiliar;
import com.example.entity.Usuario;
import com.example.service.HTTPService;
import com.example.service.HTTPServiceFactory;
import com.google.gson.Gson;

public class GrupoFamiliarDAO {

    public GrupoFamiliar getGrupo(Integer codUS){
        String resposta = "";
        HTTPService requisicao = HTTPServiceFactory.criaHTTPService("GET", "grupofamiliar/get/usuario/"+codUS);

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
