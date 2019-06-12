package com.example.service;

import android.os.AsyncTask;

import com.example.entity.Usuario;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HTTPService extends AsyncTask<Void, Void, String>{

    private String method;
    private String path;
    private String returnType;

    public HTTPService(String method, String path, String returnType) {
        this.path = path;
        this.method = method;
        this.returnType = returnType;
    }

    @Override
    protected String doInBackground(Void ... voids){

        StringBuilder resposta = new StringBuilder();

        try {
            URL url = new URL("http://scbhostname.ddns.net:8080/se_controla/" + path);
            //URL url = new URL("http://192.168.0.15:8080/se_controla/" + path);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
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
        return resposta.toString();

    }
}
