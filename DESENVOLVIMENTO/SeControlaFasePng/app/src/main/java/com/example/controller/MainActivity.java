package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_vw);


    }

    public void chamarTelaManterPerfil(View view){

        Intent intent = new Intent(this, manterPerfil_vw.class);
        startActivity(intent);
    }

    public void chamarTelaManterDependente(View view){

        Intent intent = new Intent(this, manterDependente_vw.class);
        startActivity(intent);
    }

    public void chamarTelaCategoriaGastos(View view){
        Intent intent = new Intent(this, escolherCatGastos_vw.class);
        startActivity(intent);
    }

    public void chamarTelaCategoriaReceitas(View view){

        Intent intent = new Intent(this, escolherCatReceitas_vw.class);
        startActivity(intent);
    }

    public void chamarTelaCadastro(View view){

        Intent intent = new Intent( this, cadastro_vw.class);
        startActivity(intent);
        finish();
    }

    public void chamarTelaInicio(View view){

        Intent intent = new Intent(this, inicio_vw.class);
        startActivity(intent);
        finish();
    }
}

