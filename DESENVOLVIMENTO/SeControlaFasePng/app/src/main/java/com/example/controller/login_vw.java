package com.example.controller;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.CharArrayWriter;
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
      
        if(nomeUser.isEmpty()&& senha.isEmpty()){
            mensagemErro.setText(R.string.erroCamposVazios);
            pegaNome.setBackgroundResource(R.drawable.bordaserro);
            pegaSenha.setBackgroundResource(R.drawable.bordaserro);
            return;
        }
        else if(senha.isEmpty()){
            mensagemErro.setText(R.string.erroCamposVazios);
            pegaSenha.setBackgroundResource(R.drawable.bordaserro);
            return;
        } else if(nomeUser.isEmpty()){
            mensagemErro.setText(R.string.erroCamposVazios);
            pegaNome.setBackgroundResource(R.drawable.bordaserro);

        }



        Intent intent = new Intent(this, inicio_vw.class);
        startActivity(intent);

    }
    public void chamarTelaCadastro(View view){

        startActivity(new Intent( this, cadastro_vw.class));

    }


}
