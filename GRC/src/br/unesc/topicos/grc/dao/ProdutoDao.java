package br.unesc.topicos.grc.dao;

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
                + "tamanho, cor) values(?,?,?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, produto.getId_produto());
            ps.setString(2, produto.getReferencia());
            ps.setString(3, produto.getDescricao());
            ps.setDouble(4, produto.getValor());
            ps.setString(5, produto.getTamanho());
            ps.setString(6, produto.getCor());

            ps.execute();

            conn.commit();

            logEvents.gravarLog("Produto salvo: "
                    + produto.getReferencia());
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());

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

        } catch (SQLException ex) {

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

    public void update(Produto produto) {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = Conexao.getConnection();

        String sql = "update produto set referencia = ?, descricao = ?, "
                + "valor = ?, tamanho = ?, cor = ? where id_produto = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, produto.getReferencia());
            ps.setString(2, produto.getDescricao());
            ps.setDouble(3, produto.getValor());
            ps.setString(4, produto.getTamanho());
            ps.setString(5, produto.getCor());
            ps.setInt(6, produto.getId_produto());

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

     public Produto selectProduto(String referencia) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexao.getConnection();
            String sql = "select * from produto where referencia = ?";
          
            ps = conn.prepareStatement(sql);

            ps.setString(1, referencia); 
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Produto produto = new Produto();
                
                produto.setReferencia(rs.getString(2));
                produto.setDescricao(rs.getString(3));
                produto.setValor(rs.getDouble(4));
                produto.setTamanho(rs.getString(5));
                produto.setCor(rs.getString(6));
                
                return produto;
            }
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
