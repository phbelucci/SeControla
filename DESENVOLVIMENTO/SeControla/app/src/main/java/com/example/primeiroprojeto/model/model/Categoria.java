package com.example.primeiroprojeto.model;


public class Categoria{
    private Integer codCat;
    //private com.example.primeiroprojeto.model.Categoria tipoLancamento;
    private String Descricao;

    public Categoria(Integer codCat, String descricao) {
        this.codCat = codCat;
        Descricao = descricao;
    }

    public Integer getCodCat() {
        return codCat;
    }

    public String getDescricao() {
        return Descricao;
    }
}