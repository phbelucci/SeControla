package com.example.secontrolafasefinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Scanner;

public class cadastro_vw extends AppCompatActivity {

    private EditText apagarTexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_vw);
        apagarTexto = (EditText) findViewById(R.id.campoEntraNomeCadastro);
    }
    public void apagaTexto(View v){

        apagarTexto.setText("");

    }

}
