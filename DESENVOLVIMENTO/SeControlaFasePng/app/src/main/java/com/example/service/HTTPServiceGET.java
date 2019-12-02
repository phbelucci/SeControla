package com.example.service;

import android.os.AsyncTask;

import com.example.entity.Usuario;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HTTPServiceGET extends HTTPService{

    public HTTPServiceGET(String path, String returnType) {
        super(path, returnType);
    }

    protected String executaRequisacao() {
        StringBuilder resposta = new StringBuilder();
        try {
            URL url = new URL(URLBase + path);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            if(returnType.equals("TEXT"))connection.setRequestProperty("Accept", "application/text");
            else if(returnType.equals("JSON"))connection.setRequestProperty("Accept", "application/json");
            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()){
                resposta.append(scanner.next());
            }

            System.out.println(resposta);
            respCode = connection.getResponseCode();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resposta.toString();
    }

    public int getResponseCode(){
        return respCode;
    }
}
