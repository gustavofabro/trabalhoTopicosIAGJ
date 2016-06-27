package br.unesc.topicos.grc.dao;

import br.unesc.topicos.grc.bean.Cliente;
import br.unesc.topicos.grc.bean.Produto;
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

public class ProdutoDao {

    private LogEvents logEvents = new LogEvents();

    public void insert(Produto produto) throws SistemaException {
        verificaReferencia(produto.getReferencia());

        Connection conn = null;
        PreparedStatement ps = null;

        produto.setId_produto(getId());

        conn = Conexao.getConnection();

        String sql = "insert into produto (id_produto ,referencia, descricao, valor,"
                + "tamanho, cor, grupo) values(?,?,?,?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, produto.getId_produto());
            ps.setString(2, produto.getReferencia());
            ps.setString(3, produto.getDescricao());
            ps.setDouble(4, produto.getValor());
            ps.setString(5, produto.getTamanho());
            ps.setString(6, produto.getCor());
            ps.setString(7, produto.getGrupo());

            ps.execute();

            conn.commit();

            logEvents.gravarLog("Produto salvo: "
                    + produto.getReferencia());
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

        } catch (SQLException e) {
            logEvents.gravarLog("Erro ao salvar Produto: "
                    + produto.getReferencia() + "\nErro: "
                    + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    logEvents.gravarLog("Erro: " + ex.getMessage());
                }
            }

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

    public void delete(Produto produto) {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = Conexao.getConnection();

        try {
            String sql = "delete from produto where id_produto = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, produto.getId_produto());

            ps.execute();
            conn.commit();
            System.out.println(produto.getId_produto());

            logEvents.gravarLog("Produto deletado: "
                    + produto.getReferencia() + " - "
                    + produto.getDescricao());

            JOptionPane.showMessageDialog(null, "\"" + produto.getReferencia() + " - "
                    + produto.getDescricao() + "\" deletado com sucesso!");

        } catch (SQLException ex) {

            logEvents.gravarLog("Erro ao deletar o produto: "
                    + produto.getReferencia() + "\nErro: "
                    + ex.getMessage());

            JOptionPane.showMessageDialog(null, "Erro ao deletar o produto: "
                    + produto.getReferencia() + produto.getReferencia()
            );
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

    public void update(Produto produto) throws SistemaException {
        //verificaReferencia(produto.getReferencia());

        Connection conn = null;
        PreparedStatement ps = null;

        conn = Conexao.getConnection();

        String sql = "update produto set referencia = ?, descricao = ?, "
                + "valor = ?, tamanho = ?, cor = ?, grupo = ? where id_produto = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, produto.getReferencia());
            ps.setString(2, produto.getDescricao());
            ps.setDouble(3, produto.getValor());
            ps.setString(4, produto.getTamanho());
            ps.setString(5, produto.getCor());
            ps.setString(6, produto.getGrupo()); 
            ps.setInt(7, produto.getId_produto());

            ps.execute();

            logEvents.gravarLog("Dados do produto " + produto.getReferencia()
                    + " atualizados");
        } catch (SQLException ex) {
            logEvents.gravarLog("Erro: " + ex.getMessage());
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

    private void verificaReferencia(String referencia) throws SistemaException {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = Conexao.getConnection();

        try {
            String sql = "select * from produto where referencia = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, referencia);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                throw new SistemaException("Produto já cadastrado");
            }

        } catch (SQLException ex) {
            logEvents.gravarLog("Erro ao validar Referencia: " + ex.getMessage());
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

    public List<Produto> selectProduto(String valor, String by) {
        Connection conn = null;
        PreparedStatement ps = null;
        List<Produto> lista = new ArrayList<Produto>();
        String produtoPesquisa = "'%" + valor + "%'";

        try {
            conn = Conexao.getConnection();
            String sql = "select * from produto where upper (" + by + ") like upper(" + produtoPesquisa + ")";

            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId_produto(rs.getInt(1));
                produto.setReferencia(rs.getString(2));
                produto.setDescricao(rs.getString(3));
                produto.setValor(rs.getDouble(4));
                produto.setTamanho(rs.getString(5));
                produto.setCor(rs.getString(6));
                produto.setGrupo(rs.getString(7));

                lista.add(produto);

            }

            return lista;

        } catch (SQLException e) {
            logEvents.gravarLog("Erro ao recuperar produto do banco: \n"
                    + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    logEvents.gravarLog("Erro interno no banco" + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    logEvents.gravarLog("Erro interno no banco" + ex.getMessage());
                }
            }
        }
        return null;
    }

    public List<String> getAll() {
        List<String> lista = new ArrayList<String>();
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexao.getConnection();
            String sql = "select * from produto";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString(1) + " - " + rs.getString(2));
            }
        } catch (SQLException e) {
            //   logEvents.gravarLog("Erro ao recuperar produtos do banco: \n"
            //          + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    //   logEvents.gravarLog("Erro interno no banco" + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    //   logEvents.gravarLog("Erro interno no banco" + ex.getMessage());
                }
            }
        }
        return lista;
    }

    public int getId() {
        Connection conn = null;
        PreparedStatement ps = null;

        int id = 0;

        conn = Conexao.getConnection();

        try {
            String sql = "select max(id_produto) from produto";

            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id + 1;
    }
}
