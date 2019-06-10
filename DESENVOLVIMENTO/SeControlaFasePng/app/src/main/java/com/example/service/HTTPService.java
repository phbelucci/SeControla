package com.example.service;

import android.os.AsyncTask;

import com.example.entity.Usuario;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HTTPService extends AsyncTask<Void, Void, String> {

    private String nome;

    public HTTPService(String nome) {
        this.nome = nome;
    }

    @Override
    protected String doInBackground(Void ... voids){

        StringBuilder resposta = new StringBuilder();

        try {
            //URL url = new URL("http://scbhostname.ddns.net:8080/se_controla/usuario/get/adila/123");
            URL url = new URL("http://192.168.0.101:8080/se_controla/helloworld");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/text");
            connection.setConnectTimeout(5000);

            connection.connect();

            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()){
                resposta.append(scanner.next());
            }

            System.out.println(resposta);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //return new Gson().fromJson(resposta.toString(), Usuario.class);


        return resposta.toString();

    }
}
