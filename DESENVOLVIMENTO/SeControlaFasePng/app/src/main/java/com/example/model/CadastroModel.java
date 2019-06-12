package com.example.model;

//import com.example.DAO.LoginDAO;
import com.example.DAO.UsuarioDAO;
import com.example.entity.Login;
import com.example.entity.Usuario;
import com.example.service.HTTPService;

import java.util.concurrent.ExecutionException;

public class CadastroModel {

    String mensagem="";
    // só decide quem vai fazer as coisas
    private String nome;
    private String senha;
    private Usuario usuario;

    public String cadastrar(String nome, String senha){


        String retorno="";
        /*
        HTTPService service = new HTTPService(nome+"/"+senha);


        try {
            retorno = service.execute().get();
            System.out.println(retorno);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


            usuario = new Usuario(nome,senha);
            UsuarioDAO dao = new UsuarioDAO();
            dao.salvar(usuario);
            dao.buscarPorNome(nome);

            mensagem= "Usuário Cadastrado.";
            System.out.println(usuario);
            return true;
        //}catch (Exception e){
            //fazer tratamento da mensagem
            //mensagem =
            //mensagem=e.getMessage();
            return false;
        }*/
        return retorno;
    }


    public String getMensagem(){
        return mensagem;
    }

}
