package com.example.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HTTPServiceUPDATE extends HTTPService{
    public HTTPServiceUPDATE(String path, String returnType) {
        super(path, returnType);
    }

    protected String executaRequisacao() {
        StringBuilder resposta = new StringBuilder();
        /*
        try {

            URL url = new URL(URLBase + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");

            if(returnType.equals("TEXT"))connection.setRequestProperty("Accept", "application/text");
            else if(returnType.equals("JSON"))connection.setRequestProperty("Accept", "application/json");
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
        */
        return resposta.toString();

    }
}
