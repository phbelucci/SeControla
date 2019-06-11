package entity;

public class ContaBancaria {

    private Integer codConta;
    private Integer numAgencia;
    private Integer numConta;
    private Integer codMoeda; //////////////
    private Integer codGrupo;
    private Double saldo;

    public ContaBancaria() {
    }

    public ContaBancaria(Integer codConta, Integer numAgencia, Integer numConta, Integer codMoeda, Integer codGrupo, Double saldo) {
        this.codConta = codConta;
        this.numAgencia = numAgencia;
        this.numConta = numConta;
        this.codMoeda = codMoeda;
        this.codGrupo = codGrupo;
        this.saldo = saldo;
    }

    public ContaBancaria(Integer codGrupo) {
        this.codGrupo = codGrupo;
    }

    public Integer getNumAgencia() {
        return numAgencia;
    }

    public void setNumAgencia(Integer numAgencia) {
        this.numAgencia = numAgencia;
    }

    public Integer getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(Integer codGrupo) {
        this.codGrupo = codGrupo;
    }

    public Integer getCodConta() {
        return codConta;
    }

    public void setCodConta(Integer codConta) {
        this.codConta = codConta;
    }

    public Integer getnumAgencia() {
        return numAgencia;
    }

    public void setnumAgencia(Integer numAgencia) {
        this.numAgencia = numAgencia;
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
