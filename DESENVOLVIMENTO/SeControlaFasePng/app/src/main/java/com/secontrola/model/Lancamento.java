package com.secontrola.model;


import android.media.Image;

import java.util.Date;

public class Lancamento{
    private final Integer codLanc;
    private Integer codUs;
    private Integer codMoeda;
    private Integer codConta;
    private Integer codGrupo;

    private final Date data;
    private Image comprovante;
    private Double valor;

    private Categoria cat;
    private SubCategoria subCat;
    private TipoLancamentoEnum tipoLancamentoEnum;
    private FormaPagamentoEnum formaPagamento;

    //com comprovante
    public Lancamento(Integer codLanc, Integer codUs, Integer codGrupo, Integer codMoeda, Integer codConta, Date data, Image comprovante, Double valor, Categoria cat, SubCategoria subCat, TipoLancamentoEnum tipoLancamentoEnum, FormaPagamentoEnum formaPagamento) {
        this.codLanc = codLanc;
        this.codUs = codUs;
        this.codGrupo = codGrupo;
        this.codMoeda = codMoeda;
        this.codConta = codConta;
        this.data = data;
        this.comprovante = comprovante;
        this.valor = valor;
        this.cat = cat;
        this.subCat = subCat;
        this.tipoLancamentoEnum = tipoLancamentoEnum;
        this.formaPagamento = formaPagamento;
    }

    public Integer getCodLanc() {
        return codLanc;
    }

    public Integer getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(Integer codGrupo) {
        this.codGrupo = codGrupo;
    }

    public Integer getCodUs() {
        return codUs;
    }

    public Integer getCodMoeda() {
        return codMoeda;
    }

    public Integer getCodConta() {
        return codConta;
    }

    public void setCodUs(Integer codUs) {
        this.codUs = codUs;
    }

    public Date getData() {
        return data;
    }

    public Image getComprovante() {
        return comprovante;
    }

    public Double getValor() {
        return valor;
    }

    public Categoria getCat() {
        return cat;
    }

    public SubCategoria getSubCat() {
        return subCat;
    }

    public TipoLancamentoEnum getTipoLancamentoEnum() {
        return tipoLancamentoEnum;
    }

    public FormaPagamentoEnum getFormaPagamento() {
        return formaPagamento;
    }

    public void setCodMoeda(Integer codMoeda) {
        this.codMoeda = codMoeda;
    }

    public void setCodConta(Integer codConta) {
        this.codConta = codConta;
    }

    public void setComprovante(Image comprovante) {
        this.comprovante = comprovante;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }

    public void setSubCat(SubCategoria subCat) {
        this.subCat = subCat;
    }

    public void setTipoLancamentoEnum(TipoLancamentoEnum tipoLancamentoEnum) {
        this.tipoLancamentoEnum = tipoLancamentoEnum;
    }

    public void setFormaPagamento(FormaPagamentoEnum formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}