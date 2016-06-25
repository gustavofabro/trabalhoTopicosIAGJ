package br.unesc.topicos.grc.dao;

import br.unesc.topicos.grc.bean.GrupoProduto;
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

public class GrupoProdutoDao {

    private LogEvents logEvents = new LogEvents();

    public void insert(GrupoProduto grupo) throws SistemaException {
        verificaGrupo(grupo.getNome());
        Connection conn = null;
        PreparedStatement ps = null;

        grupo.setIdGrupoProduto(getId());

        conn = Conexao.getConnection();

        String sql = "insert into grupo (id_grupo_produto, nome) values(?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, grupo.getIdGrupoProduto());
            ps.setString(2, grupo.getNome());

            ps.execute();

            conn.commit();

            // logEvents.gravarLog("Grupo de Produto salvo: "
            //         + grupo.getNome());
            JOptionPane.showMessageDialog(null, "Grupo de Produto cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());

            //   logEvents.gravarLog("Erro ao salvar Grupo de Produto: "
            //          + grupo.getNome() + "\nErro: "
            //             + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    //   logEvents.gravarLog("Erro: " + ex.getMessage());
                }
            }

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

    public List<String> getAll() {
        List<String> lista = new ArrayList<String>();
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexao.getConnection();
            String sql = "select * from grupo";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString(2));
            }
        } catch (SQLException e) {
            //   logEvents.gravarLog("Erro ao recuperar grupo de produtos do banco: \n"
            //          + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    //  logEvents.gravarLog("Erro interno no banco" + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    //  logEvents.gravarLog("Erro interno no banco" + ex.getMessage());
                }
            }
        }
        return lista;
    }

    private void verificaGrupo(String nome) throws SistemaException {

        Connection conn = null;
        PreparedStatement ps = null;

        conn = Conexao.getConnection();

        try {
            String sql = "select * from grupo where nome = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                throw new SistemaException("Grupo de Produto já cadastrado");
            }

        } catch (SQLException ex) {
            //logEvents.gravarLog("Erro ao validar Referencia: " + ex.getMessage());
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

    public int getId() {
        Connection conn = null;
        PreparedStatement ps = null;

        int id = 0;

        conn = Conexao.getConnection();

        try {
            String sql = "select max(id_grupo_produto) from grupo";

            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return id + 1;
    }
}
