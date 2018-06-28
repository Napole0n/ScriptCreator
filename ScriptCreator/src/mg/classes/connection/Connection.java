/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.classes.connection;

import java.sql.DriverManager;

/**
 *
 * @author Murilo
 */
public class Connection {

    final static String NOME_DO_BANCO = "mvcsimplesjdbc";

    public static java.sql.Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/" + NOME_DO_BANCO;
            return DriverManager.getConnection(url, "root", "");
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }

}
