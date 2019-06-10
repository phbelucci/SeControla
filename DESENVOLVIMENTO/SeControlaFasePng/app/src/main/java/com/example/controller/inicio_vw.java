package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class inicio_vw extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_vw);

    }

    public void chamarTelaCategoriaGastos(View view){
        startActivity(new Intent(this, escolherCatGastos_vw.class));

    }
    public void chamarTelaLogin(View v){
        startActivity(new Intent(getBaseContext(),login_vw.class));
    }

    public void chamarTelaManterLancamentos(View view){
        startActivity(new Intent(this, manter_lancamentos_vw.class));

    }

    public void chamarTelaCategoriaReceitas(View view){
        startActivity(new Intent(this, escolherCatReceitas_vw.class));

    }

    public void chamarTelaManterPerfil(View view){

        startActivity(new Intent(getBaseContext(), manterPerfil_vw.class));

    }
    public void chamarTelaInicio(View view){
        startActivity(new Intent(this, inicio_vw.class));

    }




}
