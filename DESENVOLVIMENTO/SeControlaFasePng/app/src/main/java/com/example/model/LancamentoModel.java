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

    public Boolean salvar(Integer codUs,                // CODIGO
                          Integer cat,                  // CATEGORIA
                          Integer subCat,               // SUBCATEGORIA
                          Double valor,                 // VALOR
                          Integer codConta,             // CONTA
                          Integer formaPagamento,       // FORMA DE PAGAMENTO
                          Integer codGrupo,             // GRUPO
                          String tipoLanc,              // TIPO DE LANCAMENTO
                          List<Lancamento> lista){      // LISTA DE LANCAMENTOS

        //Gera a data do lancamento
        SimpleDateFormat formataData = new SimpleDateFormat("yyyy-MM-dd");
        Date data = new Date();
        String dataString = formataData.format(data);


        //Manda pro DAO e Objeto ou null
        LancamentoDAO dao = new LancamentoDAO();
        Lancamento lanc =  dao.salvar(  codUs,              // CODIGO
                                        dataString,         // DATA
                                        cat,                // CATEGORIA
                                        subCat,             // SUBCATEGORIA
                                        valor,              // VALOR
                                        codConta,           // CONTA
                                        formaPagamento,     // FORMA DE PAGAMENTO
                                        codGrupo,           // GRUPO
                                        tipoLanc);          // TIPO DE LANCAMENTO

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
