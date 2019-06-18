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

    public Integer getNumConta() {
        return numConta;
    }

    public void setNumConta(Integer numConta) {
        this.numConta = numConta;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
