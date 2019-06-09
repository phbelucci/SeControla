package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import static com.example.controller.R.drawable.carrodestaque;

public class escolherCatGastos_vw extends AppCompatActivity {


    private int idCat;
    private String nomeCat;
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

        //Inicia a criação do pacote
        Bundle mandarCategoria = new Bundle();

        //indica qual o tipo de objeto
        ImageView activitySelecionada = findViewById(R.id.btnAplica);
        //indica a chave para o que deseja empacotar e o atributo do objeto que deseja empacotar (bundle)
        //1º atributo dos parenteses chave
        //2º atributo dos parenteses atributo empacotado
        mandarCategoria.putCharSequence("categoriaEscolhida",activitySelecionada.getContentDescription());
        //cria uma Intent para chamar a nova Activity(tela)
        Intent intent = new Intent(this, novoLancamento_vw.class);
        //carrega o bunble na Intent
        intent.putExtras(mandarCategoria);
        //Starta a nova tela
        startActivity(intent);
        //Seta Variavel ehGasto para exibir o texto na tela de manterLancamentos
    }

    public void chamarTelaManterPerfil(View view){
        Intent intent = new Intent(getBaseContext(), manterPerfil_vw.class);
        startActivity(intent);

    }
    /*Metodos para destaque dos botões VW escolher_cat_gastos
    taxas   - 1
    casa    - 2
    comida  - 3
    carro   - 4
    livros  - 5
    saude -  6
    diversao - 7
    higiene - 8
    outros - 9
   */
    public void aplicarDestaque(int i, String n){
        idCat = i;
        nomeCat = n;
        ImageView activitySelecionada;
        ImageView taxas = findViewById(R.id.btnSalario);
        taxas.setImageResource(R.drawable.taxas);
        ImageView casa = findViewById(R.id.btnCatCasa);
        casa.setImageResource(R.drawable.casa);
        ImageView comida = findViewById(R.id.btnExtra);
        comida.setImageResource(R.drawable.comida);
        ImageView carro = findViewById(R.id.btnAplica);
        carro.setImageResource(R.drawable.carro);
        ImageView livros = findViewById(R.id.btnCatLivros);
        livros.setImageResource(R.drawable.livros);
        ImageView saude = findViewById(R.id.btnCatSaude);
        saude.setImageResource(R.drawable.saude);
        ImageView diversao = findViewById(R.id.btnBeneficio);
        diversao.setImageResource(R.drawable.diversao);
        ImageView higiene = findViewById(R.id.btnCatHigi);
        higiene.setImageResource(R.drawable.higiene);
        ImageView outros = findViewById(R.id.btnCatOutros);
        outros.setImageResource(R.drawable.outros);

        switch (idCat){
            case 1:
                activitySelecionada = findViewById(R.id.btnSalario);
                activitySelecionada.setImageResource(R.drawable.taxasdestaque);
                
                break;
            case 2:
                activitySelecionada = findViewById(R.id.btnCatCasa);
                activitySelecionada.setImageResource(R.drawable.casadestaque);
                
                break;
            case 3:
                activitySelecionada = findViewById(R.id.btnExtra);
                activitySelecionada.setImageResource(R.drawable.comidadestaque);
                
                break;
            case 4:
                activitySelecionada = findViewById(R.id.btnAplica);
                activitySelecionada.setImageResource(carrodestaque);
                
                break;
            case 5:
                activitySelecionada = findViewById(R.id.btnCatLivros);
                activitySelecionada.setImageResource(R.drawable.livrosdestaque);
                
                break;
            case 6:
                activitySelecionada = findViewById(R.id.btnCatSaude);
                activitySelecionada.setImageResource(R.drawable.saudedestaque);
                
                break;
            case 7:
                activitySelecionada = findViewById(R.id.btnBeneficio);
                activitySelecionada.setImageResource(R.drawable.diversaodestaque);
                
                break;
            case 8:
                activitySelecionada = findViewById(R.id.btnCatHigi);
                activitySelecionada.setImageResource(R.drawable.higienedestaque);
                
                break;
            case 9:
                activitySelecionada = findViewById(R.id.btnCatOutros);
                activitySelecionada.setImageResource(R.drawable.outrosdestaque);
                
                break;

        }
        idCat = 0;

    }

    public void destacarActivityTaxas(View v){
        idCat = 1;
        nomeCat = "Taxas";
        aplicarDestaque(idCat,nomeCat);
    }
    public void destacarActivityCasa(View v){
        idCat = 2;
        nomeCat = "Casa";
        aplicarDestaque(idCat,nomeCat);
    }
    public void destacarActivityComida(View v){
        idCat = 3;
        nomeCat = "Comida";
        aplicarDestaque(idCat,nomeCat);
    }
    public void destacarActivityCarro(View v){
        idCat = 4;
        nomeCat = "Carro";
        aplicarDestaque(idCat,nomeCat);

    }
    public void destacarActivityLivros(View v){
        idCat = 5;
        nomeCat = "Livros";
        aplicarDestaque(idCat,nomeCat);
    }
    public void destacarActivitySaude(View v){
        idCat = 6;
        nomeCat = "Saúde";
        aplicarDestaque(idCat,nomeCat);

    }
    public void destacarActivityDiversao(View v){
        idCat = 7;
        nomeCat = "Diversão";
        aplicarDestaque(idCat,nomeCat);
    }
    public void destacarActivityHigiene(View v){
        idCat = 8;
        nomeCat = "Higiene";
        aplicarDestaque(idCat,nomeCat);
    }
    public void destacarActivityOutros(View v){
        idCat = 9;
        nomeCat = "Outros";
        aplicarDestaque(idCat,nomeCat);

    }


}
