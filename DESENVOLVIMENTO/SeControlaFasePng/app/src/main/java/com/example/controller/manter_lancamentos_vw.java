package com.example.controller;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
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
    private String tipo;
    private Usuario u;
    private GrupoFamiliar g;
    ArrayList<String> listaRec;
    ArrayList<String> listaDesp;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manter_lancamentos_vw);

        //Cria o Bundle para pegar os dados da tela anterior
        //getIntent pega a Intent criada na outra tela
        //getExtras pega o Bundle carreagado
        Bundle pegaDados = getIntent().getExtras();
        tipo = pegaDados.getString("tipoEscolhido");
        u = (Usuario) pegaDados.getSerializable("Usuario");
        g = (GrupoFamiliar) pegaDados.getSerializable("Grupo");
        System.out.println("TESTE: " + u.getNomeUs());

        listaRec = new ArrayList<>();
        listaDesp = new ArrayList<>();

        preecheArrayString(listaRec, "RECEITA");
        preecheArrayString(listaDesp, "DESPESA");

        ListView listView = (ListView) findViewById(R.id.listaLancamentos);
        if(tipo.equals("RECEITA")) adapter =  new ArrayAdapter(this, R.layout.lancamentolinha,listaRec);
        else adapter =  new ArrayAdapter(this, R.layout.lancamentolinha,listaDesp);

        listView.setAdapter(adapter);


        if(tipo.equals("DESPESA")){
            Button Gasto = findViewById(R.id.btnListarDespesas);
            Gasto.setBackgroundColor(Color.parseColor("#FA001A"));
            Button Receita = findViewById(R.id.btnListarReceitas);
            Receita.setBackgroundColor(Color.parseColor("#432CF800"));

        } else if( tipo.equals("RECEITA")){
            Button Gasto = findViewById(R.id.btnListarDespesas);
            Gasto.setBackgroundColor(Color.parseColor("#43F9001A"));
            Button Receita = findViewById(R.id.btnListarReceitas);
            Receita.setBackgroundColor(Color.parseColor("#2DFF00"));
        }

    }

    public void atualizarListViewRec(View view){
        Bundle novoLancamento = new Bundle();
        novoLancamento.putSerializable("Usuario", u);
        novoLancamento.putSerializable("Grupo", g);
        tipo = "RECEITA";
        novoLancamento.putString("tipoEscolhido",tipo);

        //Intent padrao para chamar a nova tela
        Intent intent = new Intent(this, manter_lancamentos_vw.class);
        //carregar o Bundle "novoLancamento" na Intent criada
        intent.putExtras(novoLancamento);
        //Chama nova tela
        startActivity(intent);
    }

    public void atualizarListViewDesp(View view){
        Bundle novoLancamento = new Bundle();
        novoLancamento.putSerializable("Usuario", u);
        novoLancamento.putSerializable("Grupo", g);
        tipo = "DESPESA";
        novoLancamento.putString("tipoEscolhido",tipo);

        //Intent padrao para chamar a nova tela
        Intent intent = new Intent(this, manter_lancamentos_vw.class);
        //carregar o Bundle "novoLancamento" na Intent criada
        intent.putExtras(novoLancamento);
        //Chama nova tela
        startActivity(intent);
    }

    public void chamarTelaManterPerfil(View view){
        Bundle parametros = new Bundle();
        parametros.putSerializable("Usuario", u);
        parametros.putSerializable("Grupo", g);

        Intent intent = new Intent(this, cadastro_vw.class);
        intent.putExtras(parametros);
        startActivity(new Intent(intent));
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

    public ArrayList<String> preecheArrayString(ArrayList novaLista, String tpLanc){
        Double totalDesp = 0.0;
        Double totalRec = 0.0;
        for(Iterator iterator = g.getLancamentosGrupo().iterator();iterator.hasNext();){
            Lancamento l = (Lancamento) iterator.next();
            if(l.getTipoLancamentoEnum().equals(tpLanc)){
                totalRec += l.getValor();
                int contadorCat = l.getCat();
                String categoria;
                switch (contadorCat){
                    case 1:
                        if(l.getTipoLancamentoEnum().equals("RECEITA"))categoria = "Salário";
                        else categoria = "Taxas";
                        novaLista.add(String.format(categoria + "\t" + l.getDataString() + " \t R$ " +l.getValor().toString()));
                        break;
                    case 2:
                        if(l.getTipoLancamentoEnum().equals("RECEITA"))categoria = "Benefício";
                        else categoria = "Casa";
                        novaLista.add(String.format(categoria + "\t" + l.getDataString() + " \t R$ " +l.getValor().toString()));
                        break;
                    case 3:
                        if(l.getTipoLancamentoEnum().equals("RECEITA"))categoria = "Aplicação";
                        else categoria = "Comida";
                        novaLista.add(String.format(categoria + "\t" + l.getDataString() + " \t R$ " +l.getValor().toString()));
                        break;
                    case 4:
                        if(l.getTipoLancamentoEnum().equals("RECEITA"))categoria = "Extra";
                        else categoria = "Carro";
                        novaLista.add(String.format(categoria + "\t" + l.getDataString() + " \t R$ " +l.getValor().toString()));
                        break;
                    case 5:
                        categoria = "Livros";
                        novaLista.add(String.format(categoria + "\t" + l.getDataString() + " \t R$ " +l.getValor().toString()));
                        break;
                    case 6:
                        categoria = "Saude";
                        novaLista.add(String.format(categoria + "\t" + l.getDataString() + " \t R$ " +l.getValor().toString()));
                        break;
                    case 7:
                        categoria = "Diversao";
                        novaLista.add(String.format(categoria + "\t" + l.getDataString() + " \t R$ " +l.getValor().toString()));
                        break;
                    case 8:
                        categoria = "Higiene";
                        novaLista.add(String.format(categoria + "\t" + l.getDataString() + " \t R$ " +l.getValor().toString()));
                        break;
                    case 9:
                        categoria = "Outros";
                        novaLista.add(String.format(categoria + "\t" + l.getDataString() + " \t R$ " +l.getValor().toString()));
                        break;
                }
            }
        }

        return novaLista;
    }

}
