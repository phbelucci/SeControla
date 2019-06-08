package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.model.CadastroModel;

import org.w3c.dom.Text;

public class cadastro_vw extends AppCompatActivity {


    private String nomeUser;
    private String senha;
    private String senhaRepete;
    CadastroModel cadastro = new CadastroModel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_vw);

    }

    public void chamarTelaLogin(View view){

        Intent intent = new Intent(this,login_vw.class);
        startActivity(intent);
    }

    public void chamarTelaInicio(View view){

        Intent intent = new Intent(this, inicio_vw.class);
        startActivity(intent);

    }

    //Função será responsável por cadastrar um novo usuário no banco
    public void cadastrarNovoUsuario(View v){

        EditText pegaNome = findViewById(R.id.inputNomeVwCadastro);
        nomeUser = pegaNome.getText().toString();
        EditText pegaSenha = findViewById(R.id.inputSenhaVwCadastro);
        senha = pegaSenha.getText().toString();
        EditText pegaRepeteSenha = findViewById(R.id.inputSenhaRepeteVwCadastro);
        senhaRepete = pegaRepeteSenha.getText().toString();
        while(!senha.equals(senhaRepete)){
            TextView mensagemErro = findViewById(R.id.mensagemErroVwCadastro);
            mensagemErro.setText("Senha não confere! Favor digitar novamente!");
            pegaSenha.setText("");
            pegaRepeteSenha.setText("");
            return;
        }
        if(senha.equals(senhaRepete)){
            if(cadastro.cadastrar(nomeUser, senhaRepete)){
                //fazer ação da tela depois

                //abrir login
                chamarTelaInicio(v);
            }else {
                //permanece na cadastro
                //mostrar na tela cadastro.getMensagem();
                TextView mensagemErro = findViewById(R.id.mensagemErroVwCadastro);
                mensagemErro.setText(cadastro.getMensagem());

            }
        }



    }

}
