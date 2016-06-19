package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    Connection conn = null;
    PreparedStatement ps = null;

    public boolean select(String login, String senha) {
        
        conn = Conexao.getConnection();

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
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
        
        return false;
    }
}
