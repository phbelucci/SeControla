package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class listarLancamentos_vw extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_lancamento_vw);
    }

    public void chamarTelaManterPerfil(View view){

        Intent intent = new Intent(getBaseContext(), cadastro_vw.class);
        startActivity(intent);

    }
    public void chamarTelaInicio(View view){

        Intent intent = new Intent(this, inicio_vw.class);
        startActivity(intent);

    }
}
