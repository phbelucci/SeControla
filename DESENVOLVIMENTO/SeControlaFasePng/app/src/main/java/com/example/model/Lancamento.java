package com.example.model;


import android.media.Image;

import java.util.Date;

public class Lancamento{
    private final Integer codLanc;
    private Integer codUs;
    private Integer codMoeda;
    private Integer codConta;

    private final Date data;
    private Image comprovante;
    private Double valor;

    private Categoria cat;
    private SubCategoria subCat;
    private TipoLancamento tipoLancamento;
    private FormaPagamento formaPagamento;

    //com comprovante
    public Lancamento(Integer codLanc, Integer codUs, Integer codMoeda, Integer codConta, Date data, Image comprovante, Double valor, Categoria cat, SubCategoria subCat, TipoLancamento tipoLancamento, FormaPagamento formaPagamento) {
        this.codLanc = codLanc;
        this.codUs = codUs;
        this.codMoeda = codMoeda;
        this.codConta = codConta;
        this.data = data;
        this.comprovante = comprovante;
        this.valor = valor;
        this.cat = cat;
        this.subCat = subCat;
        this.tipoLancamento = tipoLancamento;
        this.formaPagamento = formaPagamento;
    }

    //sem comprovante
    public Lancamento(Integer codLanc, Integer codUs, Integer codMoeda, Integer codConta, Date data, Double valor, Categoria cat, SubCategoria subCat, TipoLancamento tipoLancamento, FormaPagamento formaPagamento) {
        this.codLanc = codLanc;
        this.codUs = codUs;
        this.codMoeda = codMoeda;
        this.codConta = codConta;
        this.data = data;
        this.valor = valor;
        this.cat = cat;
        this.subCat = subCat;
        this.tipoLancamento = tipoLancamento;
        this.formaPagamento = formaPagamento;
    }

    public Integer getCodLanc() {
        return codLanc;
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

    public TipoLancamento getTipoLancamento() {
        return tipoLancamento;
    }

    public FormaPagamento getFormaPagamento() {
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

    public void setTipoLancamento(TipoLancamento tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}