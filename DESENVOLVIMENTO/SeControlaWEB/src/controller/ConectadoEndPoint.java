package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("")
public class ConectadoEndPoint {

    @GET
    @Produces("text/plain")
    public String getInicio() {
        return "Conectado!";
    }
}