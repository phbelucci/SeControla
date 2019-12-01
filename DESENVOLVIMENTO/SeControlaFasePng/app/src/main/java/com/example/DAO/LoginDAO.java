package com.example.DAO;
//Tarefa em segundo plano para conexão
//Trabalhar com Json
import com.example.entity.Usuario;
import com.example.service.HTTPService;
import com.example.service.HTTPServiceFactory;
import com.google.gson.Gson;
//Requisição HTTP
//Utilidades


public class LoginDAO{

    private String nome;
    private String senha;

    public LoginDAO(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario logar() {
        String resposta = "";
        HTTPService requisicao = HTTPServiceFactory.criaHTTPService("GET",
                "usuario/get/"+nome+"/"+senha);

        try {
            resposta = requisicao.execute().get();
            System.out.println(resposta);
        } catch (Exception e){
            e.printStackTrace();
        }

        //Converte Json em Usuario e retorna
        return new Gson().fromJson(resposta, Usuario.class);
    }
}
