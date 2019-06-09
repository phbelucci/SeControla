package endpoint;


import com.google.gson.Gson;
import entity.Usuario;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("usuario/")
public class UsuarioEndpoint {




    @GET
    @Path("get/{nome}/{senha}")
    @Produces("text/plain")
    public String getUsuario(@PathParam("nome") String nome, @PathParam("senha") String senha) {

        /*
        List<UsuarioTO> lista = new ArrayList<UsuarioTO>();

        UsuarioTO u = new UsuarioTO(nome, senha);

        Gson g = new Gson();
        */
        return nome + " " + senha;
    }

    @PUT
    @Path("set/novo/{nome}/{senha}")
    @Consumes("application/text")
    public void setUsuario(@PathParam("nome") String nome, @PathParam("senha") String senha) {

        Usuario u = new Usuario(nome, senha);

        System.out.println(u.getNomeUs() +" "+ u.getSenhaUs());

    }

}
