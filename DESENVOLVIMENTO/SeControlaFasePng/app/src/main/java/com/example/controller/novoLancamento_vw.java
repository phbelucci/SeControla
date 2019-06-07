package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class novoLancamento_vw extends AppCompatActivity {

    String btn1;
    String btn2;
    String btn3;
    String btn4;
    String btn5;
    String btn6;
    String btn7;
    String btn8;
    String btn9;
    String btn0;
    Integer soma;
    Integer contQtdCliquesTeclado;
    TextView digito1;
    TextView digito2;
    TextView digito3;
    TextView digito4;
    TextView digito5;
    TextView digito6;
    TextView digito7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_lancamento_vw);
    }
    public void chamarTelaManterPerfil(View view){

        Intent intent = new Intent(getBaseContext(), manterPerfil_vw.class);
        startActivity(intent);

    }
    public void chamarTelaInicio(View view){

        Intent intent = new Intent(this, inicio_vw.class);
        startActivity(intent);

    }

    public void chamarTelaManterLancamentos(View view){

        Intent intent = new Intent(this, manter_lancamentos_vw.class);
        startActivity(intent);

    }

    public void tratarTeclado (View v){
        Button pegaContent = findViewById(R.id.num1);
        CharSequence num;
        num = pegaContent.getText();
        System.out.println(num);
        TextView setTotal = findViewById(R.id.mostraValorFinalVwNovoLancamento);
        setTotal.setText(num);
    }


}
