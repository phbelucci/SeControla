package com.example.DAO;

import com.example.entity.GrupoFamiliar;
import com.example.entity.Usuario;
import com.example.service.HTTPServiceGET;
import com.example.service.HTTPServicePOST;
import com.google.gson.Gson;

public class CadastroDAO {
    private String nome;
    private String senha;
    private Usuario usuario;
    private GrupoFamiliar grupo;
    private String mensagem="";

    public CadastroDAO(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario cadastrar() {
        //POST
        String resposta = "";
        HTTPServicePOST requisicao = new HTTPServicePOST("POST", "usuario/post/"+nome+"/"+senha, "JSON");

        try {
            resposta = requisicao.execute().get();
            System.out.println("RESP HTTP: " + resposta);
        } catch (Exception e){
            e.printStackTrace();
        }

        //Converte Json em Usuario e retorna
        return new Gson().fromJson(resposta, Usuario.class);
    }

    public String getMensagem() { return mensagem; }
    public GrupoFamiliar getGrupo(){ return grupo; }
}
