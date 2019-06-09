package endpoint;


import com.google.gson.Gson;
import entity.Usuario;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("usuario/")
public class UsuarioEndpoint {

    @GET
    @Path("get/{nome}/{senha}")
    @Produces("application/json")
    public String getUsuario(@PathParam("nome") String nome, @PathParam("senha") String senha){

        /*
        List<UsuarioTO> lista = new ArrayList<UsuarioTO>();

        UsuarioTO u = new UsuarioTO(nome, senha);

        Gson g = new Gson();
        */
        return nome + " " + senha;
    }




}
