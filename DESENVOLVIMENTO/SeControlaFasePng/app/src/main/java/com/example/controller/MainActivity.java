package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.conexao.BDConexaoMySQL;
import com.mysql.jdbc.Connection;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* Conexao com banco:
         * 1. Instancia a classe banco
         * 2. Chama metodo execute passando parametros Comando e string SQL
         */
        BDConexaoMySQL bd = new BDConexaoMySQL();
        System.out.println(bd.execute("SELECT", "select * from table"));

        setContentView(R.layout.activity_main);


    }

    public void chamarTelaLogin(View view){
        Intent intent = new Intent(getBaseContext(),login_vw.class);
        startActivity(intent);
        finish();

    }

    public void chamarTelaManterPerfil(View view){

        Intent intent = new Intent(getBaseContext(), manterPerfil_vw.class);
        startActivity(intent);
        finish();
    }

    public void chamarTelaManterDependente(View view){

        Intent intent = new Intent(this, manterDependente_vw.class);
        startActivity(intent);

    }






}

