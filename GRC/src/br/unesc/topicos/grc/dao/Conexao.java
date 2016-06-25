package br.unesc.topicos.grc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.unesc.topicos.grc.util.LogEvents;

public class Conexao {

    private static LogEvents logEvents = new LogEvents();

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/grc", "sa", "");
        } catch (ClassNotFoundException ex) {
            System.out.println("O driver não foi configurado corretametne");
            
            JOptionPane.showMessageDialog(null, "O driver não foi configurado corretamete",
                    "", JOptionPane.ERROR_MESSAGE);
            
            logEvents.gravarLog(
                    "O driver não foi configurado corretamente\n" + ex.getMessage());

        } catch (SQLException ex) {
            System.out.println("Problemas ao conectar no banco de dados");

            logEvents.gravarLog(
                    "Problemas ao conectar no banco de dados\n" + ex.getMessage());

            JOptionPane.showMessageDialog(null, "Problemas de conexão com o Banco",
                    "", JOptionPane.ERROR_MESSAGE);
        }

        return conn;
    }
}
