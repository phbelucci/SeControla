package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.BulletSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class novoLancamento_vw extends AppCompatActivity {


    Integer botaoclicado = null;
    Integer contQtdCliquesTeclado;
    TextView mostraValorFinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_lancamento_vw);

        /*
        this.mostraValorFinal = (TextView) findViewById(R.id.mostraValorFinalVwNovoLancamento);
        Bundle pegaDados  = getIntent().getExtras();
        novoLancamento_vw novo = new novoLancamento_vw();
        mostraValorFinal.setText(pegaDados.getCharSequence("categoriaEscolhida"));
        */

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

    public void tratarTeclado1 (View v){
        Button pegaContent = findViewById(R.id.num1);
        CharSequence num;
        num = pegaContent.getText();
        System.out.println(num);
        TextView setTotal = findViewById(R.id.mostraValorFinalVwNovoLancamento);
        setTotal.setText(num);
    }

    public void tratarTeclado2(View v){
        Button pegaContent = findViewById(R.id.num1);
        CharSequence num;
        num = pegaContent.getText();
        System.out.println(num);
        TextView setTotal = findViewById(R.id.mostraValorFinalVwNovoLancamento);
        setTotal.setText(num);
    }



}
