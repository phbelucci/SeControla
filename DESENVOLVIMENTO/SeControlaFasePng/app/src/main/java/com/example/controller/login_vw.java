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

public class login_vw extends AppCompatActivity {

    String senha;
    String nome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_vw);

    }

    public void chamarTelaInicio(View view){
        TextInputEditText campoNome = findViewById(R.id.campoEntraNomeVwLogin);
        TextInputEditText campoSenha = findViewById(R.id.campoEntraSenhaVwLogin);
        TextView exibeMsg = findViewById(R.id.mensagemUsVwLogin);
        while(campoSenha.getText().equals("")){
            exibeMsg.setText(R.string.erroCamposVazios);
            campoNome.setBackgroundColor(R.style.AppTheme);
            campoSenha.setBackgroundColor(R.style.AppTheme);

        }
        Intent intent = new Intent(this, inicio_vw.class);
        startActivity(intent);

    }
    public void chamarTelaCadastro(View view){

        Intent intent = new Intent( this, cadastro_vw.class);
        startActivity(intent);

    }




}
