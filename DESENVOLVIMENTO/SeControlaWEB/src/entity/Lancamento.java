package entity;

import java.time.Instant;

public class Lancamento {
    private Integer codLanc;
    private Integer codUs;
    private Integer codMoeda;
    private Integer codConta;
    private Integer codGrupo;

    private String dataString;
    //private Image comprovante;
    private Double valor;

    private Integer cat;
    private Integer subCat;
    private String tipoLancamentoEnum;
    private Integer formaPagamento;

    public Lancamento() {
        this.dataString = Instant.now().toString();
    }
    /*
    //com comprovante
    public Lancamento(Integer codLanc, Integer codUs, Integer codGrupo, Integer codMoeda, Integer codConta, Date data, Double valor, Categoria cat, SubCategoria subCat, TipoLancamentoEnum tipoLancamentoEnum, FormaPagamentoEnum formaPagamento) {
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

    public void setCodLanc(Integer codLanc) {
        this.codLanc = codLanc;
    }


    public void setCodUs(Integer codUs) {
        this.codUs = codUs;
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

    public void setCat(Integer cat) {
        this.cat = cat;
    }

    public void setSubCat(Integer subCat) {
        this.subCat = subCat;
    }

    public void setTipoLancamentoEnum(String tipoLancamentoEnum) {
        this.tipoLancamentoEnum = tipoLancamentoEnum;
    }

    public void setFormaPagamento(Integer formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}