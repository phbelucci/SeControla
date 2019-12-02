package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPServiceDELETE extends HTTPService{
    public HTTPServiceDELETE(String path, String returnType) {
        super(path, returnType);
    }

    protected String executaRequisacao() {
        StringBuilder resposta = new StringBuilder();
        try {
            URL url = new URL(URLBase + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("charset", "utf-8");
            connection.setUseCaches (false);

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                resposta.append(line);
            }
            br.close();
            respCode = connection.getResponseCode();
            connection.disconnect();

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
