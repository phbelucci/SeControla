package com.example.conection;

import java.sql.Connection;

/**
 *
 * @author Lucas Tardioli
 */
public class BDFabricaConexao {

    public  static  Connection getConnection(){

        return new BDConexaoMySQL().getConnection();

    }

}