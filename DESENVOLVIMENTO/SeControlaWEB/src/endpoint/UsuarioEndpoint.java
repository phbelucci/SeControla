package endpoint;


import com.google.gson.Gson;
import dao.UsuarioDAO;
import entity.Usuario;
import javax.ws.rs.*;


@Path("usuario/")
public class UsuarioEndpoint {


    @GET
    @Path("get/{nome}/{senha}")
    @Produces("applicattion/json")
    public String getUsuario(@PathParam("nome") String nome, @PathParam("senha") String senha) {

        Usuario u = new Usuario(nome, senha);

        UsuarioDAO dao = new UsuarioDAO();
        dao.inserir(u);

        //Gson g = new Gson();

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
