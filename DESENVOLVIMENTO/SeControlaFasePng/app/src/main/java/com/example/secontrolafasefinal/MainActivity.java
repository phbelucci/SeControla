package com.example.secontrolafasefinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_vw);



    }
    public void incluirNovoGasto(View view){
        Intent intent = new Intent(this, escolherCatGastos_vw.class);
        startActivity(intent);
    }

    public void incluirNovaReceita(View view){

        Intent intent = new Intent(this, escolherCatReceitas_vw.class);
        startActivity(intent);
    }
}

