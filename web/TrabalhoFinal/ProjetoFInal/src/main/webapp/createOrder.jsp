<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.MenuItem" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Criar Pedido</title>
    <link rel="stylesheet" href="style.css">
    <script src="script/MenuValidator.js"></script>
</head>
<body>
    <header id="container-menu">
        <p class="menu-title">Restaurante</p>
    </header>
    <main>
        <div id="box-main">
            <h2 class="menu-heading">Fazer pedido</h2>
            <%-- Display success message if it exists in the request attribute --%>
            <div class="success-message">
                <% if (request.getAttribute("orderSuccess") != null) { %>
                    Pedido criado com sucesso!
                <% } %>
            </div>
            <form action="Controller" method="post">
                <input type="hidden" name="action" value="createOrder">
                
                <table class="order-table">
                    <tr>
                        <td><label for="entrada">Entrada:</label></td>
                        <td>
                            <select name="entrada" required>
                                <option value="" disabled selected>Selecione a Entrada</option>
                                <% 
                                    List<MenuItem> entradaItems = (List<MenuItem>) request.getAttribute("entradaItems");
                                    for (MenuItem menuItem : entradaItems) {
                                %>
                                <option value="<%=menuItem.getId()%>"><%=menuItem.getName()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="principal">Prato Principal:</label></td>
                        <td>
                            <select name="principal" required>
                                <option value="" disabled selected>Selecione o Prato Principal</option>
                                <% 
                                    List<MenuItem> pratoPrincipalItems = (List<MenuItem>) request.getAttribute("pratoPrincipalItems");
                                    for (MenuItem menuItem : pratoPrincipalItems) {
                                %>
                                <option value="<%=menuItem.getId()%>"><%=menuItem.getName()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="sobremesa">Sobremesa:</label></td>
                        <td>
                            <select name="sobremesa" required>
                                <option value="" disabled selected>Selecione a Sobremesa</option>
                                <% 
                                    List<MenuItem> sobremesaItems = (List<MenuItem>) request.getAttribute("sobremesaItems");
                                    for (MenuItem menuItem : sobremesaItems) {
                                %>
                                <option value="<%=menuItem.getId()%>"><%=menuItem.getName()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="customerName">Nome do cliente:</label></td>
                        <td><input type="text" name="customerName" required></td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td><button type="submit" class="back-button botao">Enviar Pedido</button></td>
                      </tr>
                      <tr>
                        <td><button onclick="redirectToHome()" class="back-button botao">Home</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </main>
</body>
</html>
