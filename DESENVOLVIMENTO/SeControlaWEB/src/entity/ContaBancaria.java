package entity;

public class ContaBancaria {

    private final Integer codConta;
    private Integer codUs;
    private Integer numConta;
    private Integer codMoeda; //////////////
    private Double saldo;

    public ContaBancaria(Integer codConta, Integer codUs, Integer numConta, Double saldo) {
        this.codConta = codConta;
        this.codUs = codUs;
        this.numConta = numConta;
        this.saldo = saldo;
    }

    public Integer getCodConta() {

        return codConta;
    }

    public Integer getCodUs() {
        return codUs;
    }

    public void setCodUs(Integer codUs) {
        this.codUs = codUs;
    }

    public Integer getNumConta() {
        return numConta;
    }

    public void setNumConta(Integer numConta) {
        this.numConta = numConta;
    }

    public Integer getCodMoeda() {
        return codMoeda;
    }

    public void setCodMoeda(Integer codMoeda) {
        this.codMoeda = codMoeda;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
