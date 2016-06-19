package dao;

import bean.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.LogEvents;

public class ClienteDao {

    private LogEvents logEvents = new LogEvents();

    public void insert(Cliente cliente) {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = Conexao.getConnection();

        String sql = "insert into clientes (id_cliente, nome, sobrenome, cpf, email,"
                + " sexo, nascimento, rua, bairro, cidade, estado, pais,"
                + "cep, numCasa, telefone) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cliente.getId_cliente());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getSobreNome());
            ps.setString(4, cliente.getCpf());
            ps.setString(5, cliente.getEmail());
            ps.setString(6, cliente.getSexo());
            ps.setString(7, cliente.getNascimento());
            ps.setString(8, cliente.getRua());
            ps.setString(9, cliente.getBairro());
            ps.setString(10, cliente.getCidade());
            ps.setString(11, cliente.getEstado());
            ps.setString(12, cliente.getPais());
            ps.setString(13, cliente.getCep());
            ps.setString(14, cliente.getNumCasa());
            ps.setString(15, cliente.getTelefone());
            ps.execute();

            conn.commit();

            logEvents.gravarLog("Cadastrado Cliente: "
                    + cliente.getNome());

        } catch (SQLException e) {

            logEvents.gravarLog("Erro ao cadastrar Cliente: "
                    + cliente.getNome() + "\nErro: "
                    + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
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

    public void delete(Cliente cliente) {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = Conexao.getConnection();

        try {
            String sql = "delete from clientes where id_cliente = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cliente.getId_cliente());

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

    public void update(Cliente cliente) {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = Conexao.getConnection();

        String sql = "update clientes set nome = ?, sobrenome = ?, "
                + "cpf = ?, sexo = ?, nascimento = ?, rua = ?,"
                + "bairro = ?, cidade = ?, estado = ?, pais = ?,"
                + "cep = ?, numCasa = ?, telefone = ? where cpf = id_cliente";

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getSobreNome());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getSexo());
            ps.setString(5, cliente.getNascimento());
            ps.setString(6, cliente.getRua());
            ps.setString(7, cliente.getBairro());
            ps.setString(8, cliente.getCidade());
            ps.setString(9, cliente.getEstado());
            ps.setString(10, cliente.getPais());
            ps.setString(11, cliente.getCep());
            ps.setString(12, cliente.getNumCasa());
            ps.setString(13, cliente.getTelefone());
            ps.setString(14, cliente.getCpf());
            ps.setInt(15, cliente.getId_cliente());

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

    public int getId() {
        Connection conn = null;
        PreparedStatement ps = null;
        int id = 0;

        conn = Conexao.getConnection();

        try {
            String sql = "select max(id_cliente) from clientes";

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
