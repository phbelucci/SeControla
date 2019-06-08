package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class escolherCatGastos_vw extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_cat_gastos_vw);
    }

    public void chamarTelaInicio(View view){

        Intent intent = new Intent(this, inicio_vw.class);
        startActivity(intent);

    }
    public void chamarVwNovoLancamento(View view){

        Intent intent = new Intent(this, novoLancamento_vw.class);
        startActivity(intent);
        //Seta Variavel ehGasto para exibir o texto na tela de manterLancamentos

    }

    public void chamarTelaManterPerfil(View view){

        Intent intent = new Intent(getBaseContext(), manterPerfil_vw.class);
        startActivity(intent);

    }

    public void destaqueCatEscolhida(View v){
        Bundle idCategoria = new Bundle();


    }



}
