package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class manterPerfil_vw extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manter_perfil_vw);
    }

    public void chamarTelaManterPerfil(View view){

        Intent intent = new Intent(getBaseContext(), manterPerfil_vw.class);
        startActivity(intent);

    }
    public void chamarTelaInicio(View view){

        Intent intent = new Intent(this, inicio_vw.class);
        startActivity(intent);
    }

    public void acessoCamera(View v){
        //implementar metodo de acesso a camera ou chamar model para o acesso

    }

    public void chamarTelaCadastro(View view){

        Intent intent = new Intent( this, cadastro_vw.class);
        startActivity(intent);

    }



}
