package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAOMenuItem;
import model.MenuItem;
import model.Order;
//definir os padrões de URL
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/update", "/delete", "/createOrder", "/showOrders"})
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DAOMenuItem daoMenuItem;

    public Controller() {
        super();
        daoMenuItem = new DAOMenuItem();
    }
  
    // doGet para requisições GET HTTP.
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	response.setContentType("text/html; charset=UTF-8");
    	response.setCharacterEncoding("UTF-8");

        String action = request.getServletPath();

        try (Connection con = daoMenuItem.connect()) {
            System.out.println("Conexão com o banco de dados estabelecida.");

            switch (action) {
                case "/main":
                    displayMenu(request, response);
                    break;
                case "/insert":
                    insertMenuItem(request, response);
                    break;
                case "/update":
                    showUpdateForm(request, response);
                    break;
                case "/delete":
                    deleteMenuItem(request, response);
                    break;
                case "/createOrder":
                    showCreateOrderForm(request, response);
                    break;
                case "/showOrders":
                    showOrders(request, response);
                    break;
                default:
                    response.sendRedirect("villaHome.jsp");
                    break;
            }
        } catch (SQLException e) {
            handleSQLException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8"); 

        String action = request.getParameter("action");

        switch (action) {
            case "update":
                try {
                    updateMenuItem(request, response);
                } catch (ServletException | IOException | SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                deleteMenuItem(request, response);
                break;
            case "createOrder":
			try {
				createOrder(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                break;
            case "updateOrderStatus":
                updateOrderStatus(request, response);
                break;
            case "deleteOrder":
			try {
				deleteOrder(request, response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                break;
            default:
                response.sendRedirect("villaHome.jsp");
                break;
        }
    }

    private void displayMenu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<MenuItem> menuItems = daoMenuItem.getMenuItems();
        request.setAttribute("menuItems", menuItems);
        RequestDispatcher dispatcher = request.getRequestDispatcher("displayMenu.jsp");
        dispatcher.forward(request, response);
    }

    private void insertMenuItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String ingredients = request.getParameter("ingredients");
        String type = request.getParameter("type");

        MenuItem newMenu = new MenuItem(name, ingredients, type);
        daoMenuItem.insertMenuItem(newMenu);

        response.sendRedirect("main");
    }
    
    private void showCreateOrderForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<MenuItem> entradaItems = daoMenuItem.getMenuItemsByType("entrada");
        List<MenuItem> pratoPrincipalItems = daoMenuItem.getMenuItemsByType("principal");
        List<MenuItem> sobremesaItems = daoMenuItem.getMenuItemsByType("sobremesa");

        request.setAttribute("entradaItems", entradaItems);
        request.setAttribute("pratoPrincipalItems", pratoPrincipalItems);
        request.setAttribute("sobremesaItems", sobremesaItems);

        RequestDispatcher dispatcher = request.getRequestDispatcher("createOrder.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idToUpdate = request.getParameter("idToUpdate");
        MenuItem menuItem = daoMenuItem.getMenuItemById(idToUpdate);
        request.setAttribute("menuItem", menuItem);
        RequestDispatcher dispatcher = request.getRequestDispatcher("updateMenu.jsp");
        dispatcher.forward(request, response);
    }

    private void updateMenuItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setCharacterEncoding("UTF-8");

        String idToUpdate = request.getParameter("idToUpdate");
        String name = request.getParameter("name");
        String ingredients = request.getParameter("ingredients");
        String type = request.getParameter("type");

        MenuItem updatedMenuItem = new MenuItem(name, ingredients, type);
        updatedMenuItem.setId(idToUpdate);

        try {
            int itemId = Integer.parseInt(idToUpdate);
            boolean success = daoMenuItem.updateMenuItem(itemId, updatedMenuItem);

            if (success) {
                request.setAttribute("updateSuccess", true);
                System.out.println("Prato atualizado com sucesso.");
            } else {
                System.err.println("Erro na atualização do prato.");
            }
        } catch (NumberFormatException e) {
            handleException(e, "Erro na atualização do prato: " + e.getMessage());
        }

        response.sendRedirect("main");
    }

    private void deleteMenuItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idToDelete = request.getParameter("idToDelete");

        try {
            int itemId = Integer.parseInt(idToDelete);
            daoMenuItem.deleteMenuItem(itemId);
            System.out.println("Prato excluído com sucesso.");
        } catch (NumberFormatException | SQLException e) {
            handleException(e, "Erro na exclusão do prato: " + e.getMessage());
        }

        response.sendRedirect("main");
    }
    
    
    // Erros e fechar recursos.
    
    private void handleSQLException(SQLException e) {
        e.printStackTrace();
        System.out.println("Não foi possível estabelecer conexão com o banco de dados.");
    }

    private void handleException(Exception e, String message) {
        e.printStackTrace();
        System.err.println(message);
    }
    
    private void createOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String customerName = request.getParameter("customerName");
        int entradaId = Integer.parseInt(request.getParameter("entrada"));
        int pratoPrincipalId = Integer.parseInt(request.getParameter("principal"));
        int sobremesaId = Integer.parseInt(request.getParameter("sobremesa"));

        daoMenuItem.createOrder(customerName, entradaId, pratoPrincipalId, sobremesaId);

        request.setAttribute("orderSuccess", true);

        showCreateOrderForm(request, response);
    }

    private void showOrders(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Order> orders = daoMenuItem.getOrders();
        request.setAttribute("orders", orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("showOrders.jsp");
        dispatcher.forward(request, response);
    }
    
    private void updateOrderStatus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idToUpdate = request.getParameter("idToUpdate");
        String status = request.getParameter("status");

        try {
            int orderId = Integer.parseInt(idToUpdate);
            boolean success = daoMenuItem.updateOrderStatus(orderId, status);

            if (success) {
                System.out.println("Status do pedido atualizado com sucesso.");
            } else {
                System.err.println("Erro na atualização do status do pedido.");
            }
        } catch (NumberFormatException e) {
            handleException(e, "Erro na atualização do status do pedido: " + e.getMessage());
        }

        response.sendRedirect("showOrders");
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String idToDelete = request.getParameter("idToDelete");

        try {
            int orderId = Integer.parseInt(idToDelete);
            daoMenuItem.deleteOrder(orderId);
            System.out.println("Pedido excluído com sucesso.");
        } catch (NumberFormatException e) {
            handleException(e, "Erro na exclusão do pedido: " + e.getMessage());
        }

        response.sendRedirect("showOrders");
    }
}
