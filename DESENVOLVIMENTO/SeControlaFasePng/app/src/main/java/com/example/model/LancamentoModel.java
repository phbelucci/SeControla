package com.example.model;

import com.example.DAO.LancamentoDAO;
import com.example.entity.Lancamento;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LancamentoModel implements Serializable {

    private int imagem;
    private Lancamento lanc;
    private String mensagem = "";
    //1 - GASTO OU 2 - RECEITA


    public LancamentoModel(){

    }

    public Boolean salvar(Integer codUs, Integer cat,
                       Integer subCat,  Double valor, Integer codConta,
                       Integer formaPagamento, Integer codGrupo, String tipoLanc,
                       List<Lancamento> lista){

        //Gera a data do lancamento
        String dataString = "2019-06-13";
        /*
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy");
        Date data = new Date();
        String dataString = formataData.format(data);
        */

        //Manda pro DAO e Recebe json completo
        LancamentoDAO dao = new LancamentoDAO();
        Lancamento lanc =  dao.salvar(codUs,  dataString,  cat, subCat,   valor,
                codConta, formaPagamento,  codGrupo,  tipoLanc);

        if (lanc == null){
            mensagem = "Erro ao criar lancamento. Tente novamente.";
            return false;
        }
        //Salva no List<>
        lista.add(lanc);


        mensagem = "Lancamento realizado!";
        return true;
    }
/*
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
*/
    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getMensagem(){ return mensagem; }
}
