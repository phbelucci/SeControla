package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class manter_lancamentos_vw extends AppCompatActivity {

    public boolean ehGasto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manter_lancamentos_vw);
        Button btnGastoReceita = findViewById(R.id.btnGastoReceitaVwManterLancmentos);
        if(!ehGasto){
            btnGastoReceita.setText("+ GASTO");
        } else {
            btnGastoReceita.setText("+ RECEITA");
        }

    }

    public void chamarTelaManterPerfil(View view){

        Intent intent = new Intent(getBaseContext(), manterPerfil_vw.class);
        startActivity(intent);

    }
    public void chamarTelaInicio(View view){

        Intent intent = new Intent(this, inicio_vw.class);
        startActivity(intent);

    }

}
