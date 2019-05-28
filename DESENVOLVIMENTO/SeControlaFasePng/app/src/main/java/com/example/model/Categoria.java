package com.example.model;


public final class Categoria{
    private Integer codCat;
    private TipoLancamento tipoLancamento;
    private String Descricao;

    public Categoria(Integer codCat, TipoLancamento tipoLancamento, String descricao) {
        this.codCat = codCat;
        this.tipoLancamento = tipoLancamento;
        Descricao = descricao;
    }

    public Integer getCodCat() {
        return codCat;
    }

    public String getDescricao() {
        return Descricao;
    }

    public TipoLancamento getTipoLancamento() {
        return tipoLancamento;
    }
}