package dao;

import bean.Cliente;
import bean.Produto;
import bean.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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

            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");

        } catch (SQLException ex) {
            logEvents.gravarLog("Erro ao realizar venda \n"
                    + ex.getMessage());
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

    public boolean cpfIsValido(String cpf) {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = Conexao.getConnection();

        try {
            String sql = "select * from clientes where cpf = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            logEvents.gravarLog("Erro ao validar CPF: " + ex.getMessage());
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

        return false;

    }

    public List<Venda> getVendaInDate(String dataInicial, String dataFinal) {
        List<Venda> lista = new ArrayList<Venda>();

        Connection conn = null;
        PreparedStatement ps = null;
        conn = Conexao.getConnection();

        try {
            String sql = "select * from venda where date between (?) and (?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, dataInicial);
            ps.setString(1, dataFinal);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setReferencia(rs.getString(1));
                venda.setCpf(rs.getString(2));
                venda.setDate(rs.getString(3));
               
                lista.add(venda);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
}
