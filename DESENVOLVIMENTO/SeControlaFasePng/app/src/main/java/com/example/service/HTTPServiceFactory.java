package com.example.service;

public class HTTPServiceFactory {
    public static HTTPService criaHTTPService(String tipo, String path){
        HTTPService novoServico = null;

        switch (tipo){
            case "GET":
                novoServico = new HTTPServiceGET(path, "JSON");
                break;
            case "POST":
                novoServico = new HTTPServicePOST(path, "JSON");
                break;
            case "UPDATE":
                novoServico = new HTTPServiceUPDATE(path, "JSON");
                break;
            case "DELETE":
                novoServico = new HTTPServiceDELETE(path, "TEXT");
                break;
        }
        return novoServico;
    }
}
