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

    Connection conn = null;
    PreparedStatement ps = null;
    
    private LogEvents logEvents = new LogEvents();

    public void insert(GrupoProduto grupo) throws SistemaException {
        verificaGrupo(grupo.getNome());

        grupo.setIdGrupoProduto(getId());

        conn = Conexao.getConnection();

        String sql = "insert into grupo (id_grupo_produto, nome) values(?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, grupo.getIdGrupoProduto());
            ps.setString(2, grupo.getNome());

            ps.execute();

            conn.commit();

            logEvents.gravarLog("Grupo de Produto salvo: "
                    + grupo.getNome());

            JOptionPane.showMessageDialog(null, "Grupo de Produto \"" 
                    + grupo.getNome() + "\" cadastrado com sucesso!");

        } catch (SQLException e) {
            logEvents.gravarLog("Erro ao salvar Grupo de Produto: "
                    + grupo.getNome() + "\nErro: "
                    + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    logEvents.gravarLog("Erro: " + ex.getMessage());
                }
            }

        } finally {
            finalizaVars();
        }

    }

    public List<String> getAll() {
        List<String> lista = new ArrayList<String>();

        try {
            conn = Conexao.getConnection();
            String sql = "select * from grupo";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString(2));
            }
        } catch (SQLException e) {
            logEvents.gravarLog("Erro ao recuperar grupo de produtos do banco: \n"
                    + e.getMessage());
        } finally {
            finalizaVars();
        }

        return lista;
    }

    private void verificaGrupo(String nome) throws SistemaException {
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
            logEvents.gravarLog("Erro ao validar Referencia: " + ex.getMessage());
        } finally {
            finalizaVars();
        }
    }

    private int getId() {
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
          
        }

        return id + 1;
    }

    private void finalizaVars() {
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
        
        ps = null;
        conn= null;
    }
}
