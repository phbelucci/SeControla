/*
package com.example.model;

import android.content.Context;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.controller.R;
import com.example.entity.Lancamento;

import java.util.ArrayList;
import java.util.List;

public class ListaAdapterLancamento extends ListAdapter<Lancamento> {

    private Context context;
    private List<Lancamento> lista;

    public ListaAdapterLancamento(Context context, List<Lancamento> lista) {
        super(context,0,lista);
        this.context = context;
        this.lista = lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LancamentoModel lancPosicao = this.lista.get(position);
        convertView = LayoutInflater.from(this.context).inflate(R.layout.lancamentolinha,null);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.avatar);
        imageView.setImageResource(lancPosicao.getImagem());
        TextView textView = (TextView) convertView.findViewById(R.id.categoria);
        textView.setText(lancPosicao.getCategoria());
        TextView textView1 = (TextView) convertView.findViewById(R.id.valor);
        textView1.setText(lancPosicao.getValor());
        TextView textView2 = (TextView) convertView.findViewById(R.id.formaPagto);
        textView2.setText(lancPosicao.getFormaPagto());


        return convertView;
    }


}
*/
