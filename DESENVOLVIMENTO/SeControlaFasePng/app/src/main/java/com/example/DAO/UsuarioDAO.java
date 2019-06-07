package com.example.DAO;

import com.example.entity.Usuario;

public class UsuarioDAO {

    //  COD_US int primary key,
    //	AVATAR_US longblob,
    //	COD_NIVEL_ACESSO int not null,
    //	COD_GRUPO int default null,
    //
    //	constraint foreign key FK_US_LOGIN(COD_US)
    //	references LOGIN(COD_US) on delete cascade,

    //	constraint foreign key FK_GRUPO(COD_GRUPO)
    //	references GRUPO_FAMILIAR(COD_GRUPO) on delete cascade

    public void salvar(Usuario usuario){
        //INSERT NO BANCO

        //CONCATENA STRING DO

        //tratar erro e dar re


    }

    public Usuario buscar(Usuario usuario){
        String nome =  usuario.getNomeUs();
        // SELECT * FROM

        return usuario;
    }


}
