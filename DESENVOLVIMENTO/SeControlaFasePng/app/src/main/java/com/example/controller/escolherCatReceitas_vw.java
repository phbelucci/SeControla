package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class escolherCatReceitas_vw extends AppCompatActivity {

    manter_lancamentos_vw condicao = new manter_lancamentos_vw();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_cat_receitas_vw);

    }
    public void chamarTelaInicio(View view){

        Intent intent = new Intent(this, inicio_vw.class);
        startActivity(intent);

    }

    public void chamarVwNovoLancamento(View view){
        Intent intent = new Intent(this,novoLancamento_vw.class);
        startActivity(intent);
        //Seta Variavel ehGasto para exibir o texto na tela de manterLancamentos
        condicao.ehGasto = false;


    }

    public void chamarTelaManterPerfil(View view){

        Intent intent = new Intent(getBaseContext(), manterPerfil_vw.class);
        startActivity(intent);

    }

}
