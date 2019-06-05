package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.model.CadastroModel;

public class cadastro_vw extends AppCompatActivity {


    private String nomeUser;
    private String senha;
    private String senhaRepete;
    private EditText apagarTexto;
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


    //Função será responsável por cadastrar um novo usuário no banco
    public void cadastrarNovoUsuario(View v){

        EditText pegaNome = findViewById(R.id.inputNomeVwCadastro);
        nomeUser = pegaNome.getText().toString();
        System.out.println(nomeUser);
        EditText pegaSenha = findViewById(R.id.inputSenhaVwCadastro);
        senha = pegaSenha.getText().toString();
        System.out.println(senha);
        EditText repeteSenha = findViewById(R.id.inputSenhaRepeteVwCadastro);
        senhaRepete = repeteSenha.getText().toString();
        System.out.println(senhaRepete);

        if(cadastro.cadastrar(nomeUser, senha, senhaRepete)){
            //fazer ação da tela depois
            //abrir login
        }else {
            //permanece na cadastro
            //mostrar na tela cadastro.getMensagem();

        }
    }

}
