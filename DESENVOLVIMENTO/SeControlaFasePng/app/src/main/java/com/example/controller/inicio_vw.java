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
        Intent intent = new Intent(this, escolherCatGastos_vw.class);
        startActivity(intent);

    }

    public void chamarTelaCategoriaReceitas(View view){

        Intent intent = new Intent(this, escolherCatReceitas_vw.class);
        startActivity(intent);

    }




}
