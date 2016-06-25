package br.unesc.topicos.grc.dao;

import br.unesc.topicos.grc.bean.Venda;
import br.unesc.topicos.grc.exceptions.SistemaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.unesc.topicos.grc.util.LogEvents;

public class VendaDao {

    private LogEvents logEvents = new LogEvents();

    public void insert(Venda venda) throws SistemaException {
        verificaReferencia(venda.getReferencia());
        verificaCpf(venda.getCpf());
        
        venda.setIdVenda(getId()); 
        
        Connection conn = null;
        PreparedStatement ps = null;

        conn = Conexao.getConnection();

        String sql = "insert into venda (id_venda, referencia, cpf, data) "
                + "values(?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, venda.getIdVenda());
            ps.setString(2, venda.getReferencia());
            ps.setString(3, venda.getCpf());
            ps.setString(4, venda.getDate());

            ps.execute();

            conn.commit();

//            logEvents.gravarLog("Venda realizada: "
//                    + venda.getReferencia());
            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");

        } catch (SQLException ex) {
            // logEvents.gravarLog("Erro ao realizar venda \n"
            //        + ex.getMessage());
            JOptionPane.showMessageDialog(null, "",
                    "Erro ao realizar venda", JOptionPane.ERROR_MESSAGE);

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    //  logEvents.gravarLog("Erro: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    // logEvents.gravarLog("Erro: " + ex.getMessage());
                }
            }
        }

    }

    private void verificaCpf(String cpf) throws SistemaException {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = Conexao.getConnection();

        try {
            String sql = "select * from clientes where cpf = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                throw new SistemaException("CPF inválido");
            }

        } catch (SQLException ex) {
            //logEvents.gravarLog("Erro ao validar CPF: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    //logEvents.gravarLog("Erro: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    //logEvents.gravarLog("Erro: " + ex.getMessage());
                }
            }
        }
    }

    private void verificaReferencia(String referencia) throws SistemaException {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = Conexao.getConnection();

        try {
            String sql = "select * from produto where referencia = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, referencia);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                throw new SistemaException("Referência inválida");
            }

        } catch (SQLException ex) {
            // logEvents.gravarLog("Erro ao validar produto: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    //   logEvents.gravarLog("Erro: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    //  logEvents.gravarLog("Erro: " + ex.getMessage());
                }
            }
        }
    }

    public List<Venda> getVendaInDate(String dataInicial, String dataFinal) {
        List<Venda> lista = new ArrayList<Venda>();

        Connection conn = null;
        PreparedStatement ps = null;
        conn = Conexao.getConnection();

        try {
            String sql = "select * from venda where data between ? and ?";
            ps = conn.prepareStatement(sql);

            ps.setString(1, dataInicial);
            ps.setString(2, dataFinal);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setIdVenda(rs.getInt(1));
                venda.setReferencia(rs.getString(2));
                venda.setCpf(rs.getString(3));
                venda.setDate(rs.getString(4));
                lista.add(venda);
            }

        } catch (SQLException ex) {
            // logEvents.gravarLog("Erro ao procurar data compra:\n "
            //     + ex.getMessage());
        }

        return lista;
    }

    public int getId() {
        Connection conn = null;
        PreparedStatement ps = null;
        int id = 0;

        conn = Conexao.getConnection();

        try {
            String sql = "select max(id_venda) from venda";

            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException ex) {
            //  logEvents.gravarLog("Erro: " + ex.getMessage());
        }

        return id + 1;
    }

}
