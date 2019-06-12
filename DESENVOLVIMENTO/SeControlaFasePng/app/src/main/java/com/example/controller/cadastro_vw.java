package com.example.controller;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.entity.GrupoFamiliar;
import com.example.entity.Usuario;
import com.example.model.CadastroModel;

import org.w3c.dom.Text;

import java.io.Serializable;

public class cadastro_vw extends AppCompatActivity {

    private String nomeUser;
    private String senha;
    private String senhaRepete;
    private Usuario u;
    private GrupoFamiliar g;

    CadastroModel cadastro = new CadastroModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle parametros = getIntent().getExtras();
        u = (Usuario) parametros.getSerializable("Usuario");
        g = (GrupoFamiliar) parametros.getSerializable("Grupo");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_vw);

    }

    public void chamarTelaLogin(View view){

        Intent intent = new Intent(this,login_vw.class);
        startActivity(intent);
    }

    public void chamarTelaInicio(View view){
        Bundle parametros = new Bundle();
        parametros.putSerializable("Usuario", u);
        parametros.putSerializable("Grupo", g);

        Intent intent = new Intent(this, inicio_vw.class);
        intent.putExtras(parametros);
        startActivity(intent);

    }

    //Função será responsável por cadastrar um novo usuário no banco
    //Levar em consideração que pode ser primeiro cadastro (Usuario sem grupo)
    // ou usuario dependente (Grupo já existe)
    public void cadastrarNovoUsuario(View v){

        EditText pegaNome = findViewById(R.id.inputNomeVwCadastro);
        nomeUser = pegaNome.getText().toString();
        EditText pegaSenha = findViewById(R.id.inputSenhaVwCadastro);
        senha = pegaSenha.getText().toString();
        EditText pegaRepeteSenha = findViewById(R.id.inputSenhaRepeteVwCadastro);
        senhaRepete = pegaRepeteSenha.getText().toString();
        while(!senha.equals(senhaRepete)){
            TextView mensagemErro = findViewById(R.id.mensagemErroVwCadastro);
            mensagemErro.setText(R.string.erroSenhaDifSenhaRepete);
            pegaSenha.setText("");
            pegaRepeteSenha.setText("");
            return;
        }

        while (nomeUser.isEmpty()||senha.isEmpty()){
            TextView mensagemErro = findViewById(R.id.mensagemErroVwCadastro);
            mensagemErro.setText(R.string.erroCamposVazios);
            pegaNome.setBackgroundResource(R.drawable.bordaserro);
            pegaSenha.setBackgroundResource(R.drawable.bordaserro);
            pegaRepeteSenha.setBackgroundResource(R.drawable.bordaserro);
            return;
        }

        if(senha.equals(senhaRepete)){
            TextView mensagemErro = findViewById(R.id.mensagemErroVwCadastro);
            mensagemErro.setText(cadastro.cadastrar(nomeUser, senhaRepete));
            chamarTelaInicio(v);
            /*
            if(cadastro.cadastrar(nomeUser, senhaRepete)){
                //fazer ação da tela depois

                //abrir inicio

            }else {
                //permanece na cadastro
                //mostrar na tela cadastro.getMensagem();
                TextView mensagemErro = findViewById(R.id.mensagemErroVwCadastro);
                mensagemErro.setText(cadastro.getMensagem());

            }*/
        }



    }

}
