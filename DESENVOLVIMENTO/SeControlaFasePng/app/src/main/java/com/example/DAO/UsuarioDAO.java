package com.example.DAO;

import com.example.entity.Usuario;
import com.example.service.HTTPService;
import com.example.service.HTTPServiceFactory;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class UsuarioDAO {

    public List<Usuario> getUsuariosGrupo(Integer codGrupo) {
        String resposta = "";

        HTTPService requisicao = HTTPServiceFactory.criaHTTPService("GET",
                "usuario/get/us/"+codGrupo);

        try {
            resposta = requisicao.execute().get();
        } catch (Exception e){
            e.printStackTrace();
        }

        //Converte Json em Usuario e retorna
        return new Gson().fromJson(resposta, new TypeToken<List<Usuario>>(){}.getType());
    }

    public String atualizar(int codUs, String nomeUs, String senhaUs, int codNivelAcesso, int codGrupo){
        String resposta = "";

        HTTPService requisicao = HTTPServiceFactory.criaHTTPService("UPDATE",
                "usuario/update/"+codUs+"/"+nomeUs+"/"+senhaUs+"/"+codNivelAcesso+"/"+codGrupo);

        try {
            resposta = requisicao.execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resposta;
    }

    public String deletar(int codUs){
        String resposta = "";

        HTTPService requisicao = HTTPServiceFactory.criaHTTPService("DELETE",
                "usuario/delete/"+codUs);

        try {
            resposta = requisicao.execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resposta;
    }

}
