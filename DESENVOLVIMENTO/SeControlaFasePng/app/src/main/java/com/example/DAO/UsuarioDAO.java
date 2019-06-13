package com.example.DAO;

import com.example.entity.Usuario;
import com.example.service.HTTPServiceGET;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class UsuarioDAO {

    public List<Usuario> getUsuariosGrupo(Integer codGrupo) {
        String resposta = "";

        HTTPServiceGET requisicao = new HTTPServiceGET("GET", "usuario/get/us/"+codGrupo, "JSON");

        try {
            resposta = requisicao.execute().get();
        } catch (Exception e){
            e.printStackTrace();
        }

        //Converte Json em Usuario e retorna
        return new Gson().fromJson(resposta, new TypeToken<List<Usuario>>(){}.getType());
    }

}
