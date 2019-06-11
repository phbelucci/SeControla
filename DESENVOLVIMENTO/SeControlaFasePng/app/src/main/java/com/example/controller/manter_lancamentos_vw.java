package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearSmoothScroller;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.model.Lancamento;
import com.example.model.ListaAdapterLancamento;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class manter_lancamentos_vw extends AppCompatActivity {

    ListView lista;
    private String categoriaSelecionada;
    private String valor;
    private String formapagto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manter_lancamentos_vw);

        Bundle pegaLancamento = getIntent().getExtras();

        categoriaSelecionada = pegaLancamento.getString("categoria");
        valor = pegaLancamento.getString("valorfinal");
        formapagto = pegaLancamento.getString("formapagto");
        System.out.println(categoriaSelecionada+valor+formapagto);

        ArrayList<Lancamento> lista = new ArrayList<Lancamento>();

        Lancamento a = new Lancamento(categoriaSelecionada,valor,formapagto);


        lista.add(a);


        ListaAdapterLancamento adaptador = new ListaAdapterLancamento(this,lista);
        ListView listView = (ListView) findViewById(R.id.listaLancamentos);

        listView.setAdapter(adaptador);
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
