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

public class ClienteDao {

    private LogEvents logEvents = new LogEvents();

    public void insert(Cliente cliente) throws SistemaException {
        Connection conn = null;
        PreparedStatement ps = null;

        verificaCpf(cliente.getCpf());

        cliente.setId_cliente(getId());

        conn = Conexao.getConnection();

        String sql = "insert into clientes (id_cliente, nome, sobrenome, cpf, email,"
                + " sexo, nascimento, rua, bairro, cidade, estado, pais,"
                + "cep, numCasa, telefone, data_cadastro) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cliente.getId_cliente());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getSobreNome());
            ps.setString(4, cliente.getCpf());
            ps.setString(5, cliente.getEmail());
            ps.setString(6, cliente.getSexo());
            ps.setString(7, convertDateToDB(cliente.getNascimento().split("/")));
            ps.setString(8, cliente.getRua());
            ps.setString(9, cliente.getBairro());
            ps.setString(10, cliente.getCidade());
            ps.setString(11, cliente.getEstado());
            ps.setString(12, cliente.getPais());
            ps.setString(13, cliente.getCep());
            ps.setString(14, cliente.getNumCasa());
            ps.setString(15, cliente.getTelefone());
            ps.setString(16, cliente.getDataCadastro());

            ps.execute();

            conn.commit();

            logEvents.gravarLog("Cadastrado Cliente: "
                    + cliente.getNome());
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

        } catch (SQLException e) {

            logEvents.gravarLog("Erro ao cadastrar Cliente: "
                    + cliente.getNome() + "\nErro: "
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

    public void update(Cliente cliente) {
        Connection conn = null;
        PreparedStatement ps = null;

        conn = Conexao.getConnection();

        String sql = "update clientes set nome = ?, sobrenome = ?, "
                + "cpf = ?, email = ?, sexo = ?, nascimento = ?, rua = ?,"
                + "bairro = ?, cidade = ?, estado = ?, pais = ?,"
                + "cep = ?, numCasa = ?, telefone = ? where id_cliente = ?";

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getSobreNome());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getSexo());
            ps.setString(6, convertDateToDB(cliente.getNascimento().split("/")));
            ps.setString(7, cliente.getRua());
            ps.setString(8, cliente.getBairro());
            ps.setString(9, cliente.getCidade());
            ps.setString(10, cliente.getEstado());
            ps.setString(11, cliente.getPais());
            ps.setString(12, cliente.getCep());
            ps.setString(13, cliente.getNumCasa());
            ps.setString(14, cliente.getTelefone());
            ps.setInt(15, cliente.getId_cliente());
            
            ps.execute();
            conn.commit();
            
            System.out.println("Cliente: " + cliente.getNome()); 
            System.out.println("id: " + cliente.getId_cliente());
            
        } catch (SQLException ex) {
            logEvents.gravarLog("Erro ao atualizar cliente " + cliente.getNome()
                    + "\n" + ex.getMessage());

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

    public Cliente selectByCpf(String cpf) {
        Connection conn = null;
        PreparedStatement ps = null;
        conn = Conexao.getConnection();
        try {
            String sql = "select * from clientes where cpf = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setSobreNome(rs.getString(3));
                cliente.setCpf(rs.getString(4));
                cliente.setEmail(rs.getString(5));
                cliente.setSexo(rs.getString(6));
                cliente.setDataNascimento(rs.getString(7));
                cliente.setRua(rs.getString(8));
                cliente.setBairro(rs.getString(9));
                cliente.setCidade(rs.getString(10));
                cliente.setEstado(rs.getString(11));
                cliente.setPais(rs.getString(12));
                cliente.setCep(rs.getString(13));
                cliente.setNumCasa(rs.getString(14));
                cliente.setTelefone(rs.getString(15));
                cliente.setDataCadastro(rs.getString(16));

                return cliente;
            }

        } catch (SQLException ex) {
            logEvents.gravarLog("Erro ao procurar Cliente: \n"
                    + ex.getMessage());
        }
        return null;
    }

    public List<Cliente> pesquisaAniversario(String[] dados) {
        List<Cliente> lista = new ArrayList<Cliente>();

        Connection conn = null;
        PreparedStatement ps = null;

        conn = Conexao.getConnection();

        String dataPesquisa = "'____-" + dados[1] + "-" + dados[0] + "'";
        System.out.println("Like: " + dataPesquisa);

        try {
            String sql = "select * from clientes where nascimento like " + dataPesquisa;

            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setSobreNome(rs.getString(3));
                cliente.setCpf(rs.getString(4));
                cliente.setEmail(rs.getString(5));
                cliente.setSexo(rs.getString(6));
                cliente.setDataNascimento(rs.getString(7));
                cliente.setRua(rs.getString(8));
                cliente.setBairro(rs.getString(9));
                cliente.setCidade(rs.getString(10));
                cliente.setEstado(rs.getString(11));
                cliente.setPais(rs.getString(12));
                cliente.setCep(rs.getString(13));
                cliente.setNumCasa(rs.getString(14));
                cliente.setTelefone(rs.getString(15));
                cliente.setDataCadastro(rs.getString(16));

                lista.add(cliente);
            }

        } catch (SQLException ex) {
            logEvents.gravarLog("Erro ao procurar aniversário: \n"
                    + ex.getMessage());
        }

        return lista;
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

            if (rs.next()) {
                throw new SistemaException("CPF já cadastrado no Sistema");
            }

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
    }

    public List<Cliente> selectCliente(String nome, String cpf) {
        Connection conn = null;
        PreparedStatement ps = null;
        List<Cliente> lista = new ArrayList<Cliente>();

        try {
            conn = Conexao.getConnection();
            String sql = "select * from clientes where upper (nome) "
                    + "like upper ('%" + nome + "%')"
                    + " and cpf like '%" + cpf + "%'";

            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setSobreNome(rs.getString(3));
                cliente.setCpf(rs.getString(4));
                cliente.setEmail(rs.getString(5));
                cliente.setSexo(rs.getString(6));
                cliente.setDataNascimento(rs.getString(7));
                cliente.setRua(rs.getString(8));
                cliente.setBairro(rs.getString(9));
                cliente.setCidade(rs.getString(10));
                cliente.setEstado(rs.getString(11));
                cliente.setPais(rs.getString(12));
                cliente.setCep(rs.getString(13));
                cliente.setNumCasa(rs.getString(14));
                cliente.setTelefone(rs.getString(15));
                cliente.setDataCadastro(rs.getString(16));

                lista.add(cliente);
            }

            return lista;

        } catch (SQLException e) {
            logEvents.gravarLog("Erro ao recuperar cliente do banco: \n"
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

    private int getId() {
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
            logEvents.gravarLog("Erro: " + ex.getMessage());
        }

        return id + 1;
    }

    public String convertDateToDB(String date[]) {
        return date[2] + "-" + date[1] + "-" + date[0];
    }
}
