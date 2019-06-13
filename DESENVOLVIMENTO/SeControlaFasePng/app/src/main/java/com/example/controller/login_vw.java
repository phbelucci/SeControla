package com.example.controller;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.DAO.GrupoFamiliarDAO;
import com.example.entity.GrupoFamiliar;
import com.example.entity.Usuario;
import com.example.model.LoginModel;

import org.w3c.dom.Text;

import java.io.CharArrayWriter;
import java.io.Serializable;
import java.nio.charset.Charset;

public class login_vw extends AppCompatActivity {

    private String nomeUser;
    private String senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_vw);

    }

    public void chamarTelaInicio(View view){


        EditText pegaNome = findViewById(R.id.inputNomeVwLogin);
        nomeUser = pegaNome.getText().toString();
        EditText pegaSenha = findViewById(R.id.inputSenhaVwLogin);
        senha = pegaSenha.getText().toString();

        TextView mensagemErro = findViewById(R.id.mensagemUsVwLogin);

        if(nomeUser.isEmpty()|| senha.isEmpty()){
            mensagemErro.setText(R.string.erroCamposVazios);
            pegaNome.setBackgroundResource(R.drawable.bordaserro);
            pegaSenha.setBackgroundResource(R.drawable.bordaserro);
            return;
        }
        /*
        else if(senha.isEmpty()){
            mensagemErro.setText(R.string.erroCamposVazios);
            pegaSenha.setBackgroundResource(R.drawable.bordaserro);
            return;
        } else if(nomeUser.isEmpty()){
            mensagemErro.setText(R.string.erroCamposVazios);
            pegaNome.setBackgroundResource(R.drawable.bordaserro);

        }
        */
        LoginModel login = new LoginModel();
        if(!login.logar(nomeUser, senha)) {
            mensagemErro.setText(login.getMensagem());
            return;
        }

        Usuario u = login.getUsuario();
        GrupoFamiliar g = new GrupoFamiliar(1,u);

        Bundle parametros = new Bundle();
        parametros.putSerializable("Usuario", u);
        parametros.putSerializable("Grupo", (Serializable)g);

        Intent intent = new Intent(this, inicio_vw.class);
        intent.putExtras(parametros);
        startActivity(intent);
    }
    public void chamarTelaCadastro(View view){
        Usuario u = null;
        GrupoFamiliar g = null;
        Bundle parametros = new Bundle();
        parametros.putSerializable("Usuario", u);
        parametros.putSerializable("Grupo", g);

        Intent intent = new Intent(this, cadastro_vw.class);
        intent.putExtras(parametros);
        startActivity(new Intent(intent));
    }


}
