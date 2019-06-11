package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Lancamento implements Serializable {

    private String categoria;
    private String valor;
    private String formaPagto;
    private int imagem;
    private int tipo;
    //1 - GASTO OU 2 - RECEITA

    public Lancamento(int imagem,String categoria,String valor,String formaPagto,int tipo){
        this.tipo = tipo;
        this.imagem = imagem;
        this.categoria = categoria;
        this.valor = valor;
        this.formaPagto = formaPagto;
    }
    public Lancamento(){

    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getFormaPagto() {
        return formaPagto;
    }

    public void setFormaPagto(String formaPagto) {
        this.formaPagto = formaPagto;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
