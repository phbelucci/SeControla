package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

