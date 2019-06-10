package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import static com.example.controller.R.drawable.carrodestaque;

public class escolherCatReceitas_vw extends AppCompatActivity {

    private int idCat;
    private String nomeCat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_cat_receitas_vw);

    }
    public void chamarTelaInicio(View view){

        Intent intent = new Intent(this, inicio_vw.class);
        startActivity(intent);

    }

    public void chamarVwNovoLancamento(View v){
        startActivity(new Intent(this,novoLancamento_vw.class));
        //Seta Variavel ehGasto para exibir o texto na tela de manterLancamentos


    }

    public void chamarTelaManterPerfil(View view){

        Intent intent = new Intent(getBaseContext(), manterPerfil_vw.class);
        startActivity(intent);

    }


    public void aplicarDestaque(int i, String n){
        idCat = i;
        nomeCat = n;
        ImageView activitySelecionada;
        ImageView salario = findViewById(R.id.btnSalario);
        salario.setImageResource(R.drawable.salario);
        ImageView beneficio = findViewById(R.id.btnBeneficio);
        beneficio.setImageResource(R.drawable.beneficio);
        ImageView aplicacao = findViewById(R.id.btnAplica);
        aplicacao.setImageResource(R.drawable.aplicacao);
        ImageView extra = findViewById(R.id.btnExtra);
        extra.setImageResource(R.drawable.extra);

        switch (idCat){
            case 1:
                activitySelecionada = findViewById(R.id.btnSalario);
                activitySelecionada.setImageResource(R.drawable.salariodestaque);

                break;
            case 2:
                activitySelecionada = findViewById(R.id.btnBeneficio);
                activitySelecionada.setImageResource(R.drawable.beneficiodestaque);

                break;
            case 3:
                activitySelecionada = findViewById(R.id.btnAplica);
                activitySelecionada.setImageResource(R.drawable.aplicacaodestaque);

                break;
            case 4:
                activitySelecionada = findViewById(R.id.btnExtra);
                activitySelecionada.setImageResource(R.drawable.extradestaque);

                break;
            }
        idCat = 0;

    }

    public void destacarActivitySalario(View v){
        idCat = 1;
        nomeCat = "Salario";
        aplicarDestaque(idCat,nomeCat);
    }
    public void destacarActivityBeneficio(View v){
        idCat = 2;
        nomeCat = "Beneficio";
        aplicarDestaque(idCat,nomeCat);
    }

    public void destacarActivityAplicacao(View v){
        idCat = 3;
        nomeCat = "Aplicação";
        aplicarDestaque(idCat,nomeCat);
    }
    public void destacarActivityExtra(View v){
        idCat = 4;
        nomeCat = "Extra";
        aplicarDestaque(idCat,nomeCat);

    }

}
