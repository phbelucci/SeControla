package com.example.controller;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class cadastro_vw extends AppCompatActivity {

    private EditText apagarTexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_vw);

    }

    public void chamarTelaLogin(View view){

        Intent intent = new Intent(this,login_vw.class);
        startActivity(intent);

    }

}
