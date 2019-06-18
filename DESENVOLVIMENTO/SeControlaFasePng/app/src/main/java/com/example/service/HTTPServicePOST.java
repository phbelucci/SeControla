package com.example.service;

import android.os.AsyncTask;

import com.example.entity.Usuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HTTPServicePOST extends AsyncTask<Void, Void, String>{

    private String method;
    private String path;
    private String returnType;
    private final String USER_AGENT = "Mozilla/5.0";

    public HTTPServicePOST(String method, String path, String returnType) {
        this.path = path;
        this.method = method;
        this.returnType = returnType;
    }

    @Override
    protected String doInBackground(Void ... voids){

        StringBuilder resposta = new StringBuilder();

        try {
            //URL url = new URL("http://scbhostname.ddns.net:8080/se_controla/" + path);
            URL url = new URL("http://192.168.66.242:8080/se_controla/" + path);
            System.out.println("TESTE URL: " + url.toString());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(method);
            if(returnType.equals("TEXT"))connection.setRequestProperty("Content-Type", "application/text");
            else if(returnType.equals("JSON"))connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("User-Agent", USER_AGENT);
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
            // Send post request
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            int responseCode = connection.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;


            while ((inputLine = in.readLine()) != null) {
                resposta.append(inputLine);
            }
            in.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resposta.toString();

    }
}
