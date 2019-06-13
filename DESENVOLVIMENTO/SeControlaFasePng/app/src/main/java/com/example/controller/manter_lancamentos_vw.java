package com.example.controller;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.entity.GrupoFamiliar;
import com.example.entity.Lancamento;
import com.example.entity.Usuario;
import com.example.model.LancamentoModel;
//import com.example.model.ListaAdapterLancamento;
import java.util.ArrayList;


public class manter_lancamentos_vw extends AppCompatActivity {

    ListView lista;
    private int tipo;
    private Usuario u;
    private GrupoFamiliar g;


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
        u = (Usuario) pegaDados.getSerializable("Usuario");
        g = (GrupoFamiliar) pegaDados.getSerializable("Grupo");
        System.out.println("TESTE: " + u.getNomeUs());

        /*
        ListaAdapterLancamento adaptador;
        ListView listView = (ListView) findViewById(R.id.listaLancamentos);
        /*
        if(tipo == 1){
            adaptador = new ListaAdapterLancamento(this, g.getLancamentosGrupo());
            listView.setAdapter(adaptador);
        } if (tipo == 2){
            adaptador = new ListaAdapterLancamento(this,novoArrayR);
            listView.setAdapter(adaptador);
        }
        */
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
        Bundle parametros = new Bundle();
        parametros.putSerializable("Usuario", u);
        parametros.putSerializable("Grupo", g);

        Intent intent = new Intent(getBaseContext(), manterPerfil_vw.class);
        intent.putExtras(parametros);
        startActivity(intent);
    }

    public void chamarTelaInicio(View view){
        Bundle parametros = new Bundle();
        parametros.putSerializable("Usuario", u);
        parametros.putSerializable("Grupo", g);

        Intent intent = new Intent(this, inicio_vw.class);
        intent.putExtras(parametros);
        startActivity(intent);

    }

    public void chamarTelaCategoriaGastos(View view){
        Bundle parametros = new Bundle();
        parametros.putSerializable("Usuario", u);
        parametros.putSerializable("Grupo", g);

        Intent intent = new Intent(this, escolherCatGastos_vw.class);
        intent.putExtras(parametros);
        startActivity(intent);

    }
    public void chamarTelaCategoriaReceitas(View view){
        Bundle parametros = new Bundle();
        parametros.putSerializable("Usuario", u);
        parametros.putSerializable("Grupo", g);

        Intent intent = new Intent(this, escolherCatReceitas_vw.class);
        intent.putExtras(parametros);
        startActivity(intent);

    }

}
