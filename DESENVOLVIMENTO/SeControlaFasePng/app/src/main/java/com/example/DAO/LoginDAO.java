package com.example.DAO;
//Tarefa em segundo plano para conexão
import android.os.AsyncTask;
//Trabalhar com Json
import com.example.entity.Usuario;
import com.example.service.HTTPService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
//Requisição HTTP
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//Utilidades
import java.io.IOException;
import java.util.Scanner;

public class LoginDAO{

    private String nome;
    private String senha;

    public LoginDAO(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario logar() {
        String resposta = "";
        HTTPService requisicao = new HTTPService("GET", "usuario/get/"+nome+"/"+senha, "JSON");

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
