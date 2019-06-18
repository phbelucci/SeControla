package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.entity.GrupoFamiliar;
import com.example.entity.Usuario;

public class escolherCatReceitas_vw extends AppCompatActivity {

    private int idCat;
    private String nomeCat;
    private String categoriaFinalVw;
    private Integer categoriaFinalInt;
    private String tipo;
    private Usuario u;
    private GrupoFamiliar g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle parametros = getIntent().getExtras();
        u = (Usuario) parametros.getSerializable("Usuario");
        g = (GrupoFamiliar) parametros.getSerializable("Grupo");
        System.out.println("TESTE: " + u.getNomeUs());
        tipo = "RECEITA";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_cat_receitas_vw);

    }
    public void chamarTelaInicio(View view){
        Bundle parametros = new Bundle();
        parametros.putSerializable("Usuario", u);
        parametros.putSerializable("Grupo", g);

        Intent intent = new Intent(this, inicio_vw.class);
        intent.putExtras(parametros);
        startActivity(intent);
    }

    public void chamarVwNovoLancamento(View v){

        //Inicia a criação do pacote
        Bundle mandarDados = new Bundle();
        //indica a chave para o que deseja empacotar e o atributo do objeto que deseja empacotar (bundle)
        //1º atributo dos parenteses chave
        //2º atributo dos parenteses atributo empacotado
        mandarDados.putString("categoriaEscolhida",categoriaFinalVw);
        mandarDados.putInt("categoriaEscolhidaInt", categoriaFinalInt);
        mandarDados.putString("tipoEscolhido",tipo);
        mandarDados.putSerializable("Usuario", u);
        mandarDados.putSerializable("Grupo", g);
        //cria uma Intent para chamar a nova Activity(tela)
        Intent intent = new Intent(this, novoLancamento_vw.class);
        //carrega o bunble na Intent
        intent.putExtras(mandarDados);
        //Starta a nova tela
        startActivity(intent);
    }

    public void chamarTelaManterPerfil(View view){
        Bundle parametros = new Bundle();
        parametros.putSerializable("Usuario", u);
        parametros.putSerializable("Grupo", g);

        Intent intent = new Intent(getBaseContext(), manterPerfil_vw.class);
        intent.putExtras(parametros);
        startActivity(intent);
    }

    public void aplicarDestaque(int i, String n){
        idCat = i;
        nomeCat = n;
        ImageView activitySelecionada;
        ImageView salario = findViewById(R.id.btnCatTaxas);
        salario.setImageResource(R.drawable.salario);
        ImageView beneficio = findViewById(R.id.btnCatDiversao);
        beneficio.setImageResource(R.drawable.beneficio);
        ImageView aplicacao = findViewById(R.id.btnCatCarro);
        aplicacao.setImageResource(R.drawable.aplicacao);
        ImageView extra = findViewById(R.id.btnCatComida);
        extra.setImageResource(R.drawable.extra);

        switch (idCat){
            case 1:
                activitySelecionada = findViewById(R.id.btnCatTaxas);
                activitySelecionada.setImageResource(R.drawable.salariodestaque);
                categoriaFinalVw = n;
                categoriaFinalInt = idCat;

                break;
            case 2:
                activitySelecionada = findViewById(R.id.btnCatDiversao);
                activitySelecionada.setImageResource(R.drawable.beneficiodestaque);
                categoriaFinalVw = n;
                categoriaFinalInt = idCat;

                break;
            case 3:
                activitySelecionada = findViewById(R.id.btnCatCarro);
                activitySelecionada.setImageResource(R.drawable.aplicacaodestaque);
                categoriaFinalVw = n;
                categoriaFinalInt = idCat;

                break;
            case 4:
                activitySelecionada = findViewById(R.id.btnCatComida);
                activitySelecionada.setImageResource(R.drawable.extradestaque);
                categoriaFinalVw = n;
                categoriaFinalInt = idCat;

                break;
            }
        idCat = 0;

    }

    public void destacarActivitySalario(View v){
        idCat = 1;
        nomeCat = "Salário";
        aplicarDestaque(idCat,nomeCat);
    }
    public void destacarActivityBeneficio(View v){
        idCat = 2;
        nomeCat = "Benefício";
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
