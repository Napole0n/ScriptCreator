/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.classes.database;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Murilo
 */
public class DataBase {
    

    private String url ="jdbc:mysql://localhost/";
    
    private String databaseName;
    private String username = "root";
    private String password = "";

    public DataBase(String databaseName, String username, String password) {
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
        url = url+databaseName;
    }

    
    public boolean executeScrip(String script){
        try {
            java.sql.Connection conn = Conexao.conectar(url,username,password);
            PreparedStatement ps = conn.prepareStatement(script);
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro: " + e.toString());
            return false;
        }
    }
    
        
        
        




    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDatabasename() {
        return databaseName;
    }

    public void setDatabasename(String databasename) {
        this.databaseName = databasename;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}
