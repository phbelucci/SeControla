package com.example.controller;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.example.model.Lancamento;
import com.example.model.ListaAdapterLancamento;
import java.util.ArrayList;


public class manter_lancamentos_vw extends AppCompatActivity {

    ListView lista;
    ArrayList<Lancamento> a = new ArrayList<Lancamento>();
    private int tipo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manter_lancamentos_vw);
        novoLancamento_vw n = new novoLancamento_vw();
        //Cria o Bundle para pegar os dados da tela anterior
        //getIntent pega a Intent criada na outra tela
        //getExtras pega o Bundle carreagado
        Bundle pegaDados = getIntent().getExtras();
        tipo = pegaDados.getInt("tipo");

        //getSerializable pega o valor do parametro, atraves da chave informada na outra tela
        //neste caso getSerializable, mas poderia ser getInt, getString, etc.
        //Lancamento novo = (Lancamento) pegaLancamento.getSerializable("novoGasto");

        ArrayList<Lancamento> novoArrayG = (ArrayList<Lancamento>) pegaDados.getSerializable("ArrayG");
        ArrayList<Lancamento> novoArrayR = (ArrayList<Lancamento>) pegaDados.getSerializable("ArrayR");

        ListaAdapterLancamento adaptador;
        ListView listView = (ListView) findViewById(R.id.listaLancamentos);
        if(tipo == 1){
            adaptador = new ListaAdapterLancamento(this,novoArrayG);
            listView.setAdapter(adaptador);
        } if (tipo == 2){
            adaptador = new ListaAdapterLancamento(this,novoArrayR);
            listView.setAdapter(adaptador);
        }

        if(tipo ==1){
            Button Gasto = findViewById(R.id.btnListarDespesas);
            Gasto.setBackgroundColor(Color.parseColor("#FA001A"));
            Button Receita = findViewById(R.id.btnListarReceitas);
            Receita.setBackgroundColor(Color.parseColor("#432CF800"));

        } else if( tipo == 2){
            Button Gasto = findViewById(R.id.btnListarDespesas);
            Gasto.setBackgroundColor(Color.parseColor("#43F9001A"));
            Button Receita = findViewById(R.id.btnListarReceitas);
            Receita.setBackgroundColor(Color.parseColor("#2DFF00"));
        }

    }

    public void chamarTelaManterPerfil(View view){

        Intent intent = new Intent(getBaseContext(), manterPerfil_vw.class);
        startActivity(intent);

    }
    public void chamarTelaInicio(View view){

        Intent intent = new Intent(this, inicio_vw.class);
        startActivity(intent);

    }

    public void chamarTelaCategoriaGastos(View view){
        Intent intent = new Intent(this, escolherCatGastos_vw.class);
        startActivity(intent);

    }
    public void chamarTelaCategoriaReceitas(View view){
        startActivity(new Intent(this, escolherCatReceitas_vw.class));

    }

}
