package br.unesc.topicos.grc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.unesc.topicos.grc.util.LogEvents;

public class LoginDao {

    private LogEvents logEvents = new LogEvents();
    Connection conn = null;
    PreparedStatement ps = null;

    public boolean select(String login, String senha) {

        conn = Conexao.getConnection();
        
        if (conn != null) {
            try {
                String sql = "select * from usuario"
                        + " where login = ? and senha = ?";

                ps = conn.prepareStatement(sql);
                ps.setString(1, login);
                ps.setString(2, senha);

                ps.execute();

                ResultSet rs = ps.executeQuery();

                return rs.next();

            } catch (SQLException ex) {
                logEvents.gravarLog("Erro ao validar login: " + ex.getMessage());
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        logEvents.gravarLog("Erro: " + ex.getMessage());
                    }
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        logEvents.gravarLog("Erro: " + ex.getMessage());
                    }
                }
            }
        }

        return false;
    }
}
