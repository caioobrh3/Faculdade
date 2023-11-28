import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOMenuItem {
    // Configuração do driver e credenciais do banco de dados
    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://localhost:5432/cardapio";
    private String usuario = "postgres";
    private String senha = "postgres";

    // Construtor que carrega o driver do banco de dados
    public DAOMenuItem() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Método para estabelecer uma conexão com o banco de dados
    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(url + "?charset=utf8", usuario, senha);
    }

    // Método para testar a conexão com o banco de dados
    public void testarConexao() {
        try (Connection con = conectar()) {
            System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (SQLException e) {
            tratarExcecaoSQL(e);
        }
    }

    // Método para inserir um novo item no menu no banco de dados
    public void inserirItemDeMenu(MenuItem novoPrato) {
        try (Connection con = conectar();
             PreparedStatement statement = con.prepareStatement("INSERT INTO menu (nome, ingredientes, tipo) VALUES (?, ?, ?)")) {

            statement.setString(1, novoPrato.getNome());
            statement.setString(2, novoPrato.getIngredientes());
            statement.setString(3, novoPrato.getTipo());

            statement.executeUpdate();

            System.out.println("Novo prato inserido com sucesso!");
        } catch (SQLException e) {
            tratarExcecaoSQL(e);
        }
    }

    // Método para recuperar todos os itens do menu do banco de dados
    public List<MenuItem> getItensDoMenu() {
        List<MenuItem> itensDoMenu = new ArrayList<>();

        try (Connection con = conectar();
             PreparedStatement statement = con.prepareStatement("SELECT * FROM menu");
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                MenuItem menu = new MenuItem(
                        rs.getString("nome"),
                        rs.getString("ingredientes"),
                        rs.getString("tipo"));
                menu.setId(rs.getString("id"));
                itensDoMenu.add(menu);
            }
        } catch (SQLException e) {
            tratarExcecaoSQL(e);
        }

        return itensDoMenu;
    }

    // Método para excluir um item do menu pelo ID
    public void excluirItemDeMenu(int id) throws SQLException {
        try (Connection con = conectar()) {
            String sql = "DELETE FROM menu WHERE id = ?";
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            tratarExcecaoSQL(e);
        }
    }

    // Método para obter um item do menu pelo ID
    public MenuItem getItemDeMenuPorId(String id) {
        try (Connection con = conectar();
             PreparedStatement statement = con.prepareStatement("SELECT * FROM menu WHERE id = ?")) {

            int itemId = Integer.parseInt(id);
            statement.setInt(1, itemId);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    MenuItem itemDeMenu = new MenuItem(
                            rs.getString("nome"),
                            rs.getString("ingredientes"),
                            rs.getString("tipo"));
                    itemDeMenu.setId(String.valueOf(rs.getInt("id")));
                    return itemDeMenu;
                }
            }
        } catch (SQLException e) {
            tratarExcecaoSQL(e);
        }

        return null;
    }

    // Método para atualizar um item do menu pelo ID
    public boolean atualizarItemDeMenu(int id, MenuItem itemDeMenuAtualizado) {
        try (Connection con = conectar()) {
            String sql = "UPDATE menu SET nome=?, ingredientes=?, tipo=? WHERE id=?";
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setString(1, itemDeMenuAtualizado.getNome());
                statement.setString(2, itemDeMenuAtualizado.getIngredientes());
                statement.setString(3, itemDeMenuAtualizado.getTipo());
                statement.setInt(4, id);

                int linhasAfetadas = statement.executeUpdate();
                return linhasAfetadas > 0;
            }
        } catch (SQLException e) {
            tratarExcecaoSQL(e);
            return false;
        }
    }

    // Método para tratar exceções SQL
    private void tratarExcecaoSQL(SQLException e) {
        e.printStackTrace();
        System.out.println("Erro na execução do SQL: " + e.getMessage());
    }

    // Método para criar um novo pedido
    public void criarPedido(String nomeCliente, int entradaId, int pratoPrincipalId, int sobremesaId) {
        try (Connection con = conectar();
             PreparedStatement statement = con.prepareStatement(
                     "INSERT INTO pedidos (nome_cliente, entrada_id, prato_principal_id, sobremesa_id) VALUES (?, ?, ?, ?)")) {

            statement.setString(1, nomeCliente);
            statement.setInt(2, entradaId);
            statement.setInt(3, pratoPrincipalId);
            statement.setInt(4, sobremesaId);

            statement.executeUpdate();

            System.out.println("Pedido criado com sucesso!");
        } catch (SQLException e) {
            tratarExcecaoSQL(e);
        }
    }

    // Método para recuperar itens do menu por tipo
    public List<MenuItem> getItensDoMenuPorTipo(String tipo) {
        List<MenuItem> itensDoMenu = new ArrayList<>();

        try (Connection con = conectar();
             PreparedStatement statement = con.prepareStatement("SELECT * FROM menu WHERE tipo = ?")) {

            statement.setString(1, tipo);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    MenuItem itemDeMenu = new MenuItem(
                            rs.getString("nome"),
                            rs.getString("ingredientes"),
                            rs.getString("tipo"));
                    itemDeMenu.setId(rs.getString("id"));
                    itensDoMenu.add(itemDeMenu);
                }
            }
        } catch (SQLException e) {
            tratarExcecaoSQL(e);
        }

        return itensDoMenu;
    }

    // Método para recuperar todos os pedidos do banco de dados
    public List<Pedido> getPedidos() {
        List<Pedido> pedidos = new ArrayList<>();

        try (Connection con = conectar();
             PreparedStatement statement = con.prepareStatement("SELECT * FROM pedidos");
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Pedido pedido = new Pedido(
                        rs.getInt("id"),
                        rs.getString("nome_cliente"),
                        rs.getInt("entrada_id"),
                        rs.getInt("prato_principal_id"),
                        rs.getInt("sobremesa_id"),
                        rs.getString("status"),
                        rs.getTimestamp("data_criacao"),
                        rs.getTimestamp("data_atualizacao")
                );
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            tratarExcecaoSQL(e);
        }

        return pedidos;
    }

    // Método para obter o nome de um item do menu pelo ID
    public String getNomeItemDeMenuPorId(int idItem) {
        String nomeItem = "N/A";

        try (Connection con = conectar()) {
            String query = "SELECT nome FROM menu WHERE id = ?";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setInt(1, idItem);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        nomeItem = rs.getString("nome");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nomeItem;
    }

    // Método para atualizar o status de um pedido pelo ID
    public boolean atualizarStatusDoPedido(int idPedido, String novoStatus) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = conectar();
            String query = "UPDATE pedidos SET status = ? WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, novoStatus);
            ps.setInt(2, idPedido);

            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharRecursos(con, ps, null);
        }

        return false; // Retorna falso se a atualização falhar
    }

    // Método para excluir um pedido pelo ID
    public boolean excluirPedido(int idPedido) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = conectar();
            String query = "DELETE FROM pedidos WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, idPedido);

            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharRecursos(con, ps, null);
        }

        return false;
    }

    // Método para fechar recursos do banco de dados
    private void fecharRecursos(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
