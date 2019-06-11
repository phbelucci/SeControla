package com.example.service;
//Tarefa em segundo plano para conexão
import android.os.AsyncTask;
//Trabalhar com Json
import com.example.entity.Usuario;
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

public class LoginHTTPService extends AsyncTask<Void, Void, Usuario>{
    private String nome;
    private String senha;
    private Usuario usuario;

    public LoginHTTPService(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    @Override
    protected Usuario doInBackground(Void ... voids) {

        StringBuilder resposta = new StringBuilder();

        try {
            URL url = new URL("http://scbhostname.ddns.net:8080/se_controla/usuario/get/"+nome+"/"+senha);
            //URL url = new URL("http://192.168.0.15:8080/se_controla/usuario/get/"+nome+"/"+senha);
            //System.out.println("TESTE URL: "+"http://192.168.0.15:8080/se_controla/usuario/get/"+nome+"/"+senha);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setConnectTimeout(5000);

            connection.connect();

            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()) {
                resposta.append(scanner.next());
            }

            System.out.println(resposta);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Conerte Json em Usuario e retorna
        return new Gson().fromJson(resposta.toString(), Usuario.class);


        //return resposta.toString();
    }
}
