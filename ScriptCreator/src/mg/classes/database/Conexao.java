package mg.classes.database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexao {

    public static Connection conectar(String url, String user, String pass) {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erro: " + e.toString());
            return null;
        }
    }
}