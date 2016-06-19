package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexao {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/grc", "sa", "");
        } catch (ClassNotFoundException ex) {
            System.out.println("O driver não foi configurado corretametne");
        } catch (SQLException ex) {
            System.out.println("Problemas ao conectar no banco de dados");
        }

        return conn;
    }
}
