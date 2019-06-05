package com.example.entity;

/*
*
* **** Teste branch Silvião
*
*/
public final class Categoria{
    private Integer codCat;
    private TipoLancamentoEnum tipoLancamentoEnum;
    private String Descricao;

    public Categoria(Integer codCat, TipoLancamentoEnum tipoLancamentoEnum, String descricao) {
        this.codCat = codCat;
        this.tipoLancamentoEnum = tipoLancamentoEnum;
        Descricao = descricao;
    }

    public Integer getCodCat() {
        return codCat;
    }

    public String getDescricao() {
        return Descricao;
    }

    public TipoLancamentoEnum getTipoLancamentoEnum() {
        return tipoLancamentoEnum;
    }
}