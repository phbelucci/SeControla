package com.example.model;


public final class SubCategoria{
    private Integer codSubCat;
    private Integer codCat;
    //private com.example.primeiroprojeto.model.Categoria tipoLancamento;
    private String nome;

    public SubCategoria(Integer codSubCat, Integer codCat, String nome) {
        this.codSubCat = codSubCat;
        this.codCat = codCat;
        this.nome = nome;
    }

    public Integer getCodSubCat() {
        return codSubCat;
    }

    public Integer getCodCat() {
        return codCat;
    }

    public String getNome() {
        return nome;
    }
}