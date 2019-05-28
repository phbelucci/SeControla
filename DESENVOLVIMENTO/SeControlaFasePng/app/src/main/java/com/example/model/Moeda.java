package com.example.model;

public class Moeda{

    private final Integer codMoeda;
    private final String descMoeda;
    private Double cotacao;

    public Moeda(Integer codMoeda, String descMoeda, Double cotacao) {
        this.codMoeda = codMoeda;
        this.descMoeda = descMoeda;
        this.cotacao = cotacao;
    }

    public Integer getCodMoeda() {
        return codMoeda;
    }

    public String getDescMoeda() {
        return descMoeda;
    }

    public Double getCotacao() {
        return cotacao;
    }

    public void setCotacao(Double cotacao) {
        this.cotacao = cotacao;
    }

}