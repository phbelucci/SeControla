package com.example.model;

public class Lancamento {

    private String categoria;
    private String valor;
    private String formaPagto;
    //private int imagem;

    public Lancamento(/*int imagem,*/String categoria,String valor,String formaPagto){
        //this.imagem = imagem;
        this.categoria = categoria;
        this.valor = valor;
        this.formaPagto = formaPagto;

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

    /*public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }*/
}
