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

@WebServlet(urlPatterns = { "/Controller", "/main", "/inserir", "/atualizar", "/excluir", "/criarPedido", "/mostrarPedidos" })
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DAOMenuItem daoMenuItem;

    public Controller() {
        super();
        daoMenuItem = new DAOMenuItem();
    }
  
    // Conexão com o banco de dados
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	response.setContentType("text/html; charset=UTF-8");
    	response.setCharacterEncoding("UTF-8");

        String acao = request.getServletPath();

        try (Connection con = daoMenuItem.conectar()) {

            switch (acao) {
                case "/main":
                    exibirMenu(request, response);
                    break;
                case "/inserir":
                    inserirItemDeMenu(request, response);
                    break;
                case "/atualizar":
                    mostrarFormularioDeAtualizacao(request, response);
                    break;
                case "/excluir":
                    excluirItemDeMenu(request, response);
                    break;
                case "/criarPedido":
                    mostrarFormularioDeCriacaoDePedido(request, response);
                    break;
                case "/mostrarPedidos":
                    mostrarPedidos(request, response);
                    break;
                default:
                    response.sendRedirect("villaHome.jsp");
                    break;
            }
        } catch (SQLException e) {
            tratarExcecaoSQL(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8"); 

        String acao = request.getParameter("acao");

        switch (acao) {
            case "atualizar":
                try {
                    atualizarItemDeMenu(request, response);
                } catch (ServletException | IOException | SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "excluir":
                excluirItemDeMenu(request, response);
                break;
            case "criarPedido":
			try {
				criarPedido(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
                break;
            case "atualizarStatusDoPedido":
                atualizarStatusDoPedido(request, response);
                break;
            case "excluirPedido":
			try {
				excluirPedido(request, response);
			} catch (ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
                break;
            default:
                response.sendRedirect("villaHome.jsp");
                break;
        }
    }

    // Exibir o menu principal
    private void exibirMenu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<MenuItem> itensDoMenu = daoMenuItem.getItensDoMenu();
        request.setAttribute("itensDoMenu", itensDoMenu);
        RequestDispatcher dispatcher = request.getRequestDispatcher("exibirMenu.jsp");
        dispatcher.forward(request, response);
    }

    // Inserir um novo item de menu
    private void inserirItemDeMenu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String ingredientes = request.getParameter("ingredientes");
        String tipo = request.getParameter("tipo");

        MenuItem novoItemDeMenu = new MenuItem(nome, ingredientes, tipo);
        daoMenuItem.inserirItemDeMenu(novoItemDeMenu);

        response.sendRedirect("main");
    }
    
    // Exibir o formulário de criação de pedido
    private void mostrarFormularioDeCriacaoDePedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<MenuItem> itensEntrada = daoMenuItem.getItensDoMenuPorTipo("entrada");
        List<MenuItem> itensPratoPrincipal = daoMenuItem.getItensDoMenuPorTipo("prato principal");
        List<MenuItem> itensSobremesa = daoMenuItem.getItensDoMenuPorTipo("sobremesa");

        request.setAttribute("itensEntrada", itensEntrada);
        request.setAttribute("itensPratoPrincipal", itensPratoPrincipal);
        request.setAttribute("itensSobremesa", itensSobremesa);

        RequestDispatcher dispatcher = request.getRequestDispatcher("criarPedido.jsp");
        dispatcher.forward(request, response);
    }

    // Exibir o formulário de atualização do menu
    private void mostrarFormularioDeAtualizacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParaAtualizar = request.getParameter("idParaAtualizar");
        MenuItem itemDeMenu = daoMenuItem.getItemDeMenuPorId(idParaAtualizar);
        request.setAttribute("itemDeMenu", itemDeMenu);
        RequestDispatcher dispatcher = request.getRequestDispatcher("atualizarMenu.jsp");
        dispatcher.forward(request, response);
    }

    // Atualizar um item de menu
    private void atualizarItemDeMenu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setCharacterEncoding("UTF-8");

        String idParaAtualizar = request.getParameter("idParaAtualizar");
        String nome = request.getParameter("nome");
        String ingredientes = request.getParameter("ingredientes");
        String tipo = request.getParameter("tipo");

        MenuItem itemDeMenuAtualizado = new MenuItem(nome, ingredientes, tipo);
        itemDeMenuAtualizado.setId(idParaAtualizar);

        try {
            int idItem = Integer.parseInt(idParaAtualizar);
            boolean sucesso = daoMenuItem.atualizarItemDeMenu(idItem, itemDeMenuAtualizado);

            if (sucesso) {
                request.setAttribute("atualizacaoComSucesso", true);
                System.out.println("Item de menu atualizado com sucesso.");
            } else {
                System.err.println("Erro na atualização do item de menu.");
            }
        } catch (NumberFormatException e) {
            tratarExcecao(e, "Erro na atualização do item de menu: " + e.getMessage());
        }

        response.sendRedirect("main");
    }

    // Excluir um item de menu
    private void excluirItemDeMenu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParaExcluir = request.getParameter("idParaExcluir");

        try {
            int idItem = Integer.parseInt(idParaExcluir);
            daoMenuItem.excluirItemDeMenu(idItem);
            System.out.println("Item de menu excluído com sucesso.");
        } catch (NumberFormatException | SQLException e) {
            tratarExcecao(e, "Erro na exclusão do item de menu: " + e.getMessage());
        }

        response.sendRedirect("main");
    }
    

