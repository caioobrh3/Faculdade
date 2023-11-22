<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.MenuItem" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cardápio</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script src="script/MenuValidator.js"></script>
     <style>
        /* Additional styles for responsiveness */
        @media (max-width: 600px) {
            table {
                width: 100%;
                overflow-x: auto;
            }

            /* Hide columns on smaller devices */
            .menu-table th:nth-child(1),
            .menu-table td:nth-child(1),
            .menu-table th:nth-child(3),
            .menu-table td:nth-child(3),
            .menu-table th:nth-child(4),
            .menu-table td:nth-child(4) {
                display: none;
            }
        }
    </style>
</head>
<body>
    <header id="container-menu">
        <p class="menu-title">Restaurante</p>
    </header>
    <main>
        <div id="box-main">
            <h2 class="menu-heading">Menu</h2>
            <div class="table-container">
                <table class="menu-table">
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Ingredientes</th>
                        <th>Tipo</th>
                        <th>Ação</th>
                        <th>Editar</th>
                    </tr>
                    <% List<MenuItem> menuItems = (List<MenuItem>) request.getAttribute("menuItems");
                        for (MenuItem menuItem : menuItems) { %>
                    <tr>
                        <td><%=menuItem.getId()%></td>
                        <td><%=menuItem.getName()%></td>
                        <td><%=menuItem.getIngredients()%></td>
                        <td><%=menuItem.getType()%></td>
                        <td>
                            <form action="Controller" method="post" onsubmit="return confirmDelete(event)">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="idToDelete" value="<%=menuItem.getId()%>">
                                <button type="submit" class="delete-button">
                                    <i class="fas fa-trash-alt"></i>
                                </button>
                            </form>
                        </td>
                        <td><a href="editMenu.jsp?id=<%=menuItem.getId()%>" class="edit-button">
                                <i class="fas fa-pencil-alt"></i></a>
                        </td>
                    </tr>
                    <% } %>
                </table>
            </div>
            <table class="option-buttons">
                <tr>
                    <td>
                        <button onclick="redirectToHome()" class="back-button botao">Home</button>
                    </td>
                </tr>
            </table>
        </div>
    </main>
</body>
</html>
