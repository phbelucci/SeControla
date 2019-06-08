package com.example.service;

import android.os.AsyncTask;

import com.example.entity.Usuario;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HTTPService extends AsyncTask<Void, Void, Usuario> {

    private String nome;

    public HTTPService(String nome) {
        this.nome = nome;
    }

    @Override
    protected Usuario doInBackground(Void ... voids){

        StringBuilder retorno = new StringBuilder();

        try {
            //inserir a URL abaixo:
            URL url = new URL("http://192.168.1.16:8080/SeControla_WS_REST/webresources/secontrola");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/text");
            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()){
                retorno.append(scanner.next());
            }

            System.out.println(retorno);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Gson().fromJson(retorno.toString(), Usuario.class);
    }
}
