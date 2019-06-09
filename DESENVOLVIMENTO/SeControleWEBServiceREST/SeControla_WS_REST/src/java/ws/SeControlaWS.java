/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Silvio
 */
@Path("secontrola")
public class SeControlaWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SeControlaWS
     */
    public SeControlaWS() {
    }

    /**
     * Retrieves representation of an instance of ws.SeControlaWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getJson() {
        return "Teste Silvião\n\nVai dar certo Paulão!!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("Usuario/get")
    public String getUsuario() {
        return "GET Usuario Silvião TESTE!!";
    }
    
    /**
     * PUT method for updating or creating an instance of SeControlaWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
