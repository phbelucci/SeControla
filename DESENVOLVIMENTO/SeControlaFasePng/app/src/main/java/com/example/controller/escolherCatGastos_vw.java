package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import static com.example.controller.R.drawable.carrodestaque;

public class escolherCatGastos_vw extends AppCompatActivity {



    private boolean estaAtivo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_cat_gastos_vw);
    }






    public void chamarTelaInicio(View view){
        Intent intent = new Intent(this, inicio_vw.class);
        startActivity(intent);

    }
    public void chamarVwNovoLancamento(View view){

        Bundle mandarCategoria = new Bundle();

        ImageView activitySelecionada = findViewById(R.id.btnCatCarro);
        mandarCategoria.putCharSequence("categoriaEscolhida",activitySelecionada.getContentDescription());

        Intent intent = new Intent(this, novoLancamento_vw.class);
        intent.putExtras(mandarCategoria);
        startActivity(intent);
        //Seta Variavel ehGasto para exibir o texto na tela de manterLancamentos

    }

    public void chamarTelaManterPerfil(View view){
        Intent intent = new Intent(getBaseContext(), manterPerfil_vw.class);
        startActivity(intent);

    }



    //Metodos para destaque dos botões VW escolher_cat_gastos
    public void destacarActivity(View v){
        if(!estaAtivo){
            ImageView activitySelecionada  = findViewById(R.id.btnCatCarro);
            activitySelecionada.setImageResource(carrodestaque);
            estaAtivo = true;
        }
    }
    public void destacarActivityCasa(View v){
        ImageView activitySelecionada = findViewById(R.id.btnCatCasa);
        activitySelecionada.setImageResource(R.drawable.casadestaque);

    }
    public void destacarActivitySaude(View v){
        ImageView activitySelecionada = findViewById(R.id.btnCatSaude);
        activitySelecionada.setImageResource(R.drawable.saudedestaque);

    }
    public void destacarActivityHigiene(View v){
        ImageView activitySelecionada = findViewById(R.id.btnCatHigi);
        activitySelecionada.setImageResource(R.drawable.higienedestaque);
    }
    public void destacarActivityOutros(View v){
        ImageView activitySelecionada = findViewById(R.id.btnCatOutros);
        activitySelecionada.setImageResource(R.drawable.outrosdestaque);

    }
    public void destacarActivityComida(View v){
        ImageView activitySelecionada = findViewById(R.id.btnCatComida);
        activitySelecionada.setImageResource(R.drawable.comidadestaque);

    }
    public void destacarActivityLivros(View v){
        ImageView activitySelecionada = findViewById(R.id.btnCatLivros);
        activitySelecionada.setImageResource(R.drawable.livrosdestaque);
    }
    public void destacarActivityDiversao(View v){
        ImageView activitySelecionada = findViewById(R.id.btnCatDiversao);
        activitySelecionada.setImageResource(R.drawable.casadestaque);
    }
    public void destacarActivityTaxas(View v){
        ImageView activitySelecionada = findViewById(R.id.btnCatTaxas);
        activitySelecionada.setImageResource(R.drawable.taxasdestaque);
    }




}
