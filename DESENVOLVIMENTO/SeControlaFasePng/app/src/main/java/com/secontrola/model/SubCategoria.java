package com.secontrola.model;


public class SubCategoria{
    private final Integer codSubCat;
    private Integer codCat;
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

    public void setCodCat(Integer codCat) {
        this.codCat = codCat;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}