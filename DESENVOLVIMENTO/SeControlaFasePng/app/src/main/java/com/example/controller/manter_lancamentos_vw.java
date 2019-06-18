package com.example.controller;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.entity.GrupoFamiliar;
import com.example.entity.Lancamento;
import com.example.entity.Usuario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import com.example.model.ListaAdapterLancamento;


public class manter_lancamentos_vw extends AppCompatActivity {

    ListView lista;
    private int tipo;
    private Usuario u;
    private GrupoFamiliar g;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manter_lancamentos_vw);

        //Cria o Bundle para pegar os dados da tela anterior
        //getIntent pega a Intent criada na outra tela
        //getExtras pega o Bundle carreagado
        Bundle pegaDados = getIntent().getExtras();
        tipo = pegaDados.getInt("tipo");
        u = (Usuario) pegaDados.getSerializable("Usuario");
        g = (GrupoFamiliar) pegaDados.getSerializable("Grupo");
        System.out.println("TESTE: " + u.getNomeUs());

        ArrayList<String> novaLista = new ArrayList<>();

        preecheArrayString(novaLista);
        ListView listView = (ListView) findViewById(R.id.listaLancamentos);
        ArrayAdapter adapter =  new ArrayAdapter(this, R.layout.lancamentolinha,novaLista);
        listView.setAdapter(adapter);


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

    public ArrayList<String> preecheArrayString(ArrayList novaLista){
        Double totalDesp = 0.0;
        Double totalRec = 0.0;
        for(Iterator iterator = g.getLancamentosGrupo().iterator();iterator.hasNext();){
            Lancamento l = (Lancamento) iterator.next();
            if(l.getTipoLancamentoEnum().equals("RECEITA"))totalRec += l.getValor();
            if(l.getTipoLancamentoEnum().equals("DESPESA"))totalDesp += l.getValor();
            int contadorCat = l.getCat();
            String categoria;
            switch (contadorCat){
                case 1:
                    categoria = "Taxas";
                    novaLista.add(String.format(categoria + "\t" + l.getDataString() + " \t R$ " +l.getValor().toString()));
                    break;
                case 2:
                    categoria = "Casa";
                    novaLista.add(String.format(categoria + "\t" + l.getDataString() + " \t R$ " +l.getValor().toString()));
                    break;
                case 3:
                    categoria = "comida";
                    novaLista.add(String.format(categoria + "\t" + l.getDataString() + " \t R$ " +l.getValor().toString()));
                    break;
                case 4:
                    categoria = "carro";
                    novaLista.add(String.format(categoria + "\t" + l.getDataString() + " \t R$ " +l.getValor().toString()));
                    break;
                case 5:
                    categoria = "livros";
                    novaLista.add(String.format(categoria + "\t" + l.getDataString() + " \t R$ " +l.getValor().toString()));
                    break;
                case 6:
                    categoria = "saude";
                    novaLista.add(String.format(categoria + "\t" + l.getDataString() + " \t R$ " +l.getValor().toString()));
                    break;
                case 7:
                    categoria = "diversao";
                    novaLista.add(String.format(categoria + "\t" + l.getDataString() + " \t R$ " +l.getValor().toString()));
                    break;
                case 8:
                    categoria = "higiene";
                    novaLista.add(String.format(categoria + "\t" + l.getDataString() + " \t R$ " +l.getValor().toString()));
                    break;
                case 9:
                    categoria = "outros";
                    novaLista.add(String.format(categoria + "\t" + l.getDataString() + " \t R$ " +l.getValor().toString()));
                    break;
            }

        }

        return novaLista;
    }

}
