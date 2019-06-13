package com.example.DAO;
//Tarefa em segundo plano para conexão
//Trabalhar com Json
import com.example.entity.Usuario;
import com.example.service.HTTPServiceGET;
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
        HTTPServiceGET requisicao = new HTTPServiceGET("GET", "usuario/get/"+nome+"/"+senha, "JSON");

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
