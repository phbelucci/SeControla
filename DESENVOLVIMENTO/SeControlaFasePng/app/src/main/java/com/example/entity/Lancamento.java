package com.example.entity;


import android.media.Image;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Lancamento implements Serializable {
    private Integer codLanc;
    private Integer codUs;
    //private Integer codMoeda;
    private Integer codConta;
    private Integer codGrupo;

    private String dataString;
    //private Image comprovante;
    private Double valor;

    private Integer cat;
    private Integer subCat;
    private String tipoLancamentoEnum;
    private Integer formaPagamento;
    //"/post/{codUs}/{data}/{codCat}/{codSubCat:(/codSubCat/[^/]+?)?}/{valor}/{codConta}/{codPagamento}/{codGrupo}/{tipoLanc}"
    public Lancamento(Integer codUs, String dataString, Integer cat, Integer subCat,  Double valor,
                      Integer codConta, Integer formaPagamento, Integer codGrupo, Integer tipoLanc) {
        this.codUs = codUs;
        this.dataString = dataString;
        this.cat = cat;
        this.subCat = subCat;
        this.valor = valor;
        this.codConta = codConta;
        this.formaPagamento = formaPagamento;
        this.codGrupo = codGrupo;
        this.tipoLancamentoEnum = tipoLancamentoEnum;
    }
    /*
    //com comprovante
    public LancamentoModel(Integer codLanc, Integer codUs, Integer codGrupo, Integer codMoeda, Integer codConta, Date data, Double valor, Categoria cat, SubCategoria subCat, TipoLancamentoEnum tipoLancamentoEnum, FormaPagamentoEnum formaPagamento) {
        this.codLanc = codLanc;
        this.codUs = codUs;
        this.codGrupo = codGrupo;
        this.codMoeda = codMoeda;
        this.codConta = codConta;
        this.data = Calendar.getInstance();
        //this.comprovante = comprovante;
        this.valor = valor;
        this.cat = cat;
        this.subCat = subCat;
        this.tipoLancamentoEnum = tipoLancamentoEnum;
        this.formaPagamento = formaPagamento;
    }*/

    public Integer getCodLanc() {
        return codLanc;
    }

    public void setCodLanc(Integer codLanc) {
        this.codLanc = codLanc;
    }

    public Integer getCodUs() {
        return codUs;
    }

    public void setCodUs(Integer codUs) {
        this.codUs = codUs;
    }

    /*
    public Integer getCodMoeda() {
        return codMoeda;
    }

    public void setCodMoeda(Integer codMoeda) {
        this.codMoeda = codMoeda;
    }
    */

    public Integer getCodConta() {
        return codConta;
    }

    public void setCodConta(Integer codConta) {
        this.codConta = codConta;
    }

    public Integer getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(Integer codGrupo) {
        this.codGrupo = codGrupo;
    }

    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getCat() {
        return cat;
    }

    public void setCat(Integer cat) {
        this.cat = cat;
    }

    public Integer getSubCat() {
        return subCat;
    }

    public void setSubCat(Integer subCat) {
        this.subCat = subCat;
    }

    public String getTipoLancamentoEnum() {
        return tipoLancamentoEnum;
    }

    public void setTipoLancamentoEnum(String tipoLancamentoEnum) {
        this.tipoLancamentoEnum = tipoLancamentoEnum;
    }

    public Integer getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Integer formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}