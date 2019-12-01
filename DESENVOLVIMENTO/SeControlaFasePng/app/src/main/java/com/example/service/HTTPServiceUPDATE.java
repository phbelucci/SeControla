package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

        try {
            URL url = new URL(URLBase+path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");
            OutputStreamWriter out = new OutputStreamWriter(
                    connection.getOutputStream());
            out.write("");
            out.flush();
            out.close();
            connection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                resposta.append(line);
            }
            br.close();
            connection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(resposta);

        return resposta.toString();

    }
}
