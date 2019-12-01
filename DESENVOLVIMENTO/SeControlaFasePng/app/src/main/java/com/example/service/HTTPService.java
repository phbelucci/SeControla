package com.example.service;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

public abstract class HTTPService extends AsyncTask<Void, Void, String> {
    protected String path;
    protected String returnType;
    protected final String USER_AGENT = "Mozilla/5.0";
    //protected String URLBase = "http://localhost:8080/";
    //protected String URLBase = "http://scbhostname.ddns.net:8080/se_controla/";
    protected String URLBase = "http://192.168.0.34:8080/";

    HTTPService(String path, String returnType) {
        this.path = path;
        this.returnType = returnType;
    }

    @Override
    protected String doInBackground(Void ... voids){
        return executaRequisacao();
    }

    protected abstract String executaRequisacao();

}
