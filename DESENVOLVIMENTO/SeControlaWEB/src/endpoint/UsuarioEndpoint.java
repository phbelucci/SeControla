package endpoint;


import com.google.gson.Gson;
import connection.BDFabricaConexao;
import dao.UsuarioDAO;
import entity.Usuario;
import javax.ws.rs.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


@Path("usuario/")
public class UsuarioEndpoint {


    @GET
    //@Path("get/{nome}/{senha}")
    @Path("get/")
    @Produces("applicattion/json")
    //public String getUsuario(@PathParam("nome") String nome, @PathParam("senha") String senha) {
    public String getUsuario() {
        //Usuario u = new Usuario(nome, senha);

        try {
            Connection con = (Connection) BDFabricaConexao.getConnection();
            String sql = "select * from USUARIO;";
            Statement stm = (Statement) con.createStatement();
            ResultSet rset = stm.executeQuery(sql);

            while (rset.next()) {
                System.out.print(rset.getInt("COD_US"));
                System.out.println(rset.getString("NOME_US"));
                System.out.println(rset.getString("SENHA_US"));
                System.out.print(rset.getInt("COD_NIVEL_ACESSO"));
                System.out.print(rset.getInt("COD_GRUPO"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        Gson g = new Gson();

        return "OK";
    }

    @PUT
    @Path("set/novo/{nome}/{senha}")
    @Consumes("application/text")
    public void setUsuario(@PathParam("nome") String nome, @PathParam("senha") String senha) {

        Usuario u = new Usuario(nome, senha);

        System.out.println(u.getNomeUs() +" "+ u.getSenhaUs());

    }

}
