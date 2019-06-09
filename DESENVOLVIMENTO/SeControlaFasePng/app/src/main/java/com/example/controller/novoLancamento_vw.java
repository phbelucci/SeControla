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


    private String botaoclicado = null;
    private int contQtdCliquesTeclado = 0;
    private TextView mostraValorFinal;
    private String somaCampo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_lancamento_vw);

    }

    public void chamarTelaManterPerfil(View view){
        startActivity(new Intent(getBaseContext(), manterPerfil_vw.class));

    }
    public void chamarTelaInicio(View view){
        startActivity(new Intent(this, inicio_vw.class));

    }

    public void chamarTelaManterLancamentos(View view){
        startActivity(new Intent(this, manter_lancamentos_vw.class));

    }

    public void mostrarNumTela(String n){
        TextView campoEscolhido = findViewById(R.id.mostraValorFinalVwNovoLancamento);
        botaoclicado = n;
        switch (contQtdCliquesTeclado){

            case 1:
                somaCampo = botaoclicado;
                campoEscolhido.setText(somaCampo+",00");
                break;
            case 2:
                somaCampo = somaCampo + botaoclicado;
                campoEscolhido.setText(somaCampo);
                break;
            case 3:
                somaCampo = somaCampo + botaoclicado;
                campoEscolhido.setText(somaCampo);
                break;
            case 4:
                somaCampo = somaCampo + botaoclicado;
                campoEscolhido.setText(somaCampo);
                break;
            case 5:
                somaCampo = somaCampo + botaoclicado;
                campoEscolhido.setText(somaCampo);
                break;
            case 6:
                somaCampo = somaCampo + botaoclicado;
                campoEscolhido.setText(somaCampo);
                break;
            case 7:
                somaCampo = somaCampo + botaoclicado;
                campoEscolhido.setText(somaCampo);
                break;

        }
    }

    public void tratarTeclado0(View v){
        botaoclicado = "0";
        contQtdCliquesTeclado++;
        mostrarNumTela(botaoclicado);

    }
    public void tratarTeclado1(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "1";
        mostrarNumTela(botaoclicado);

    }

    public void tratarTeclado2(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "2";
        mostrarNumTela(botaoclicado);

    }
    public void tratarTeclado3(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "3";
        mostrarNumTela(botaoclicado);

    }
    public void tratarTeclado4(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "4";
        mostrarNumTela(botaoclicado);


    }
    public void tratarTeclado5(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "5";
        mostrarNumTela(botaoclicado);
    }
    public void tratarTeclado6(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "6";
        mostrarNumTela(botaoclicado);
    }
    public void tratarTeclado7(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "7";
        mostrarNumTela(botaoclicado);

    }
    public void tratarTeclado8(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "8";
        mostrarNumTela(botaoclicado);

    }
    public void tratarTeclado9(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "9";
        mostrarNumTela(botaoclicado);
    }
    public void tratarTecladoC(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "C";
        mostrarNumTela(botaoclicado);
    }
    public void tratarTecladoApagar(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "A";
        mostrarNumTela(botaoclicado);
    }








}
