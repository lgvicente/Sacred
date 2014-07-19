/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sacred;

import java.sql.*;

/** Classe que realiza conexão com o banco de dados
 * Neste exemplo é mostrado para um conexão com o Banco de Dados Firebird. Pode-se passar o nome ou o IP para identificar o servidor.
 */
public class ConectionDB{

        static Connection con;
        static String url;

            public static Connection getConnection()
            {
                try{
                    String jdbc="jdbc:mysql://localhost/oneworld";
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection(jdbc,"root","1234");

                }
                catch(ClassNotFoundException e)
                {
                    System.out.println(e);
                }
                catch (SQLException ex)
                {
                   ex.printStackTrace();
                }
                return con;
        }
}