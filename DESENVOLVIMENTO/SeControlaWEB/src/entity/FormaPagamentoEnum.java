package entity;

public enum FormaPagamentoEnum{
    DINHEIRO(1),
    DEBITO (2),
    CREDITO(3),
    TRANSFERENCIA(4),
    CHEQUE(5);

    public int opcao;

    FormaPagamentoEnum(int opcao) {
        this.opcao = opcao;
    }
}