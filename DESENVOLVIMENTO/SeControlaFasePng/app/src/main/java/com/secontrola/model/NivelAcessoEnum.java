package com.secontrola.model;

public enum NivelAcessoEnum{
    ADMIN_SIS(1),
    ADMIN_GRUPO(2),
    USUARIO_GRUPO(3);

    public int opcao;

    NivelAcessoEnum(int opcao) {
        this.opcao = opcao;
    }
}