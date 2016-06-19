package dao;

import bean.Produto;
import bean.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.LogEvents;

public class VendaDao {

    private LogEvents logEvents = new LogEvents();

    public void insert(Venda venda) {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = Conexao.getConnection();

        String sql = "insert into vendas (referencia, cpf, date"
                + "tamanho, cor) values(?,?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, venda.getReferencia());
            ps.setString(2, venda.getCpf());
            ps.setString(3, venda.getDate());

            ps.execute();

            conn.commit();

            logEvents.gravarLog("Venda realizada: "
                    + venda.getReferencia());

        } catch (SQLException ex) {
               logEvents.gravarLog("Erro ao realizar venda"
                    + ex.getMessage());
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

    }
}
