package model;

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
	private String user = "postgres";
	private String password = "postgres";
	
	 // Construtor que carrega o driver do banco de dados
	public DAOMenuItem() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection connect() throws SQLException {
		return DriverManager.getConnection(url + "?charset=utf8", user, password);
	}


	public void testConnection() {
		try (Connection con = connect()) {
			System.out.println("Conexão com o banco de dados estabelecida.");
		} catch (SQLException e) {
			handleSQLException(e);
		}
	}

	
	  // Insere um novo item no menu no banco de dados
	public void insertMenuItem(MenuItem novoPrato) {
		try (Connection con = connect();
				PreparedStatement statement = con.prepareStatement("INSERT INTO menu (name, ingredients, type) VALUES (?, ?, ?)")) {

			statement.setString(1, novoPrato.getName());
			statement.setString(2, novoPrato.getIngredients());
			statement.setString(3, novoPrato.getType());

			statement.executeUpdate();

			System.out.println("Novo prato inserido com sucesso!");
		} catch (SQLException e) {
			handleSQLException(e);
		}
	}

	// Recupera todos os itens do menu do banco de dados
	public List<MenuItem> getMenuItems() {
		List<MenuItem> menuItems = new ArrayList<>();

		try (Connection con = connect();
				PreparedStatement statement = con.prepareStatement("SELECT * FROM menu");
				ResultSet rs = statement.executeQuery()) {

			while (rs.next()) {
				MenuItem menu = new MenuItem(
						rs.getString("name"),
						rs.getString("ingredients"),
						rs.getString("type"));
				menu.setId(rs.getString("id"));
				menuItems.add(menu);
			}
		} catch (SQLException e) {
			handleSQLException(e);
		}

		return menuItems;
	}

	
	
	public void deleteMenuItem(int id) throws SQLException {
		try (Connection connection = connect()) {
			String sql = "DELETE FROM menu WHERE id = ?";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setInt(1, id);
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			handleSQLException(e);
		}
	}

	public MenuItem getMenuItemById(String id) {
		try (Connection con = connect();
				PreparedStatement statement = con.prepareStatement("SELECT * FROM menu WHERE id = ?")) {

			int itemId = Integer.parseInt(id);
			statement.setInt(1, itemId);

			try (ResultSet rs = statement.executeQuery()) {
				if (rs.next()) {
					MenuItem menuItem = new MenuItem(
							rs.getString("name"),
							rs.getString("ingredients"),
							rs.getString("type"));
					menuItem.setId(String.valueOf(rs.getInt("id")));
					return menuItem;
				}
			}
		} catch (SQLException e) {
			handleSQLException(e);
		}

		return null;
	}

	public boolean updateMenuItem(int id, MenuItem updatedMenuItem) {
		try (Connection connection = connect()) {
			String sql = "UPDATE menu SET name=?, ingredients=?, type=? WHERE id=?";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, updatedMenuItem.getName());
				statement.setString(2, updatedMenuItem.getIngredients());
				statement.setString(3, updatedMenuItem.getType());
				statement.setInt(4, id);

				int rowsAffected = statement.executeUpdate();
				return rowsAffected > 0;
			}
		} catch (SQLException e) {
			handleSQLException(e);
			return false;
		}
	}

	private void handleSQLException(SQLException e) {
		e.printStackTrace();
		System.out.println("Erro na execução do SQL: " + e.getMessage());
	}

	public void createOrder(String customerName, int entradaId, int pratoPrincipalId, int sobremesaId) {
		try (Connection con = connect();
				PreparedStatement statement = con.prepareStatement(
						"INSERT INTO orders (customer_name, entrada_id, prato_principal_id, sobremesa_id) VALUES (?, ?, ?, ?)")) {

			statement.setString(1, customerName);
			statement.setInt(2, entradaId);
			statement.setInt(3, pratoPrincipalId);
			statement.setInt(4, sobremesaId);

			statement.executeUpdate();

			System.out.println("Pedido criado com sucesso!");
		} catch (SQLException e) {
			handleSQLException(e);
		}
	}
    // Recupera itens do menu por tipo
	public List<MenuItem> getMenuItemsByType(String type) {
		List<MenuItem> menuItems = new ArrayList<>();

		try (Connection con = connect();
				PreparedStatement statement = con.prepareStatement("SELECT * FROM menu WHERE type = ?")) {

			statement.setString(1, type);

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					MenuItem menuItem = new MenuItem(
							rs.getString("name"),
							rs.getString("ingredients"),
							rs.getString("type"));
					menuItem.setId(rs.getString("id"));
					menuItems.add(menuItem);
				}
			}
		} catch (SQLException e) {
			handleSQLException(e);
		}

		return menuItems;
	}
	
	// Recupera todos os pedidos do banco de dados
	public List<Order> getOrders() {
	    List<Order> orders = new ArrayList<>();

	    try (Connection con = connect();
	         PreparedStatement statement = con.prepareStatement("SELECT * FROM orders");
	         ResultSet rs = statement.executeQuery()) {

	        while (rs.next()) {
	            Order order = new Order(
	                    rs.getInt("id"),
	                    rs.getString("customer_name"),
	                    rs.getInt("entrada_id"),
	                    rs.getInt("prato_principal_id"),
	                    rs.getInt("sobremesa_id"),
	                    rs.getString("status"),
	                    rs.getTimestamp("created_at"),  
	                    rs.getTimestamp("updated_at")   
	            );
	            orders.add(order);
	        }
	    } catch (SQLException e) {
	        handleSQLException(e);
	    }

	    return orders;
	}

	public String getMenuItemNameById(int itemId) {
		String itemName = "N/A"; 

		try (Connection con = connect()) {
			String query = "SELECT name FROM menu WHERE id = ?";
			try (PreparedStatement pst = con.prepareStatement(query)) {
				pst.setInt(1, itemId);
				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						itemName = rs.getString("name");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return itemName;
	}
	

    // Atualiza o status de um pedido pelo ID
    public boolean updateOrderStatus(int orderId, String newStatus) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = connect();
            String query = "UPDATE orders SET status = ? WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, newStatus);
            ps.setInt(2, orderId);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(con, ps, null);
        }

        return false; // Return false if the update fails
    }

    // Delete pelo id
    public boolean deleteOrder(int orderId) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = connect();
            String query = "DELETE FROM orders WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, orderId);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(con, ps, null);
        }

        return false; 
    }

    // fechar recursos do banco de dados
    private void closeResources(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}