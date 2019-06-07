package com.example.conexao;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Tardioli
 */
public class BDConexaoMySQL extends AsyncTask<String, Void, String> {

    protected Connection con;
    protected String servidor;
    protected String bd;
    protected String usuario;
    protected String senha;
    protected String driver;
    protected int porta;

    public BDConexaoMySQL() {
        
        this.driver = "com.mysql.jdbc.Driver";
        this.porta = 3306;
        //this.servidor = "127.0.0.1";
        this.servidor = "201.82.154.222";
        this.bd = "db_secontrola";
        this.usuario = "root";
        this.senha = "dustcloth";
    }

    @Override
    protected String doInBackground(String... params) {
        String Erro =  "NADA";

        try {
            Class.forName(driver);
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = DriverManager.getConnection(getURL(), usuario, senha);
            con.close();
            Erro = "\n\n FOI !!! \n" + params[0] + params[1] + "\n";

        } catch (SQLException ex) {
            System.out.println("TESTE BD: " + ex.getMessage());
            System.out.println("TESTE CAUSE BD: " + ex.getCause());
            //Logger.getLogger(BDConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(null, "ERRO AO CARREGAR DRIVE");
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(BDConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex){
            System.out.println("TESTE BD: " + ex.getMessage());
            System.out.println("TESTE CAUSE BD: " + ex.getCause());
        }
        return Erro;
    }

    public String getURL() {
        //return "jdbc:mysql://" + this.servidor + ":" + this.porta + "/" + this.bd
                //+ "?useTimezone=true&serverTimezone=UTC";
        return "jdbc:mysql://" + this.servidor + ":" + this.porta + "/" + this.bd;
    }

}
