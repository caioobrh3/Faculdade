<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.DAOMenuItem, model.MenuItem"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Editar Prato</title>
<link rel="stylesheet" href="style.css">
<script src="script/MenuValidator.js"></script>
</head>
<body>
	<header id="container-menu">
		<p class="menu-title">Restaurante</p>
	</header>
	<main>
		<div id="box-main">
			<h2 class="menu-heading">Editar Prato</h2>
			<%
                String itemId = request.getParameter("id");
                DAOMenuItem daoMenuItem = new DAOMenuItem();
                MenuItem menuItem = daoMenuItem.getMenuItemById(itemId);
            %>
			<form action="Controller" method="post" accept-charset="UTF-8">
				<input type="hidden" name="action" value="update"> <input
					type="hidden" name="idToUpdate" value="<%=itemId%>">
				<table class="order-table">
					<tr>
						<td><label for="name">Nome:</label></td>
						<td><input type="text" name="name"
							value="<%=menuItem.getNome()%>" required class="input-field"></td>
					</tr>
					<tr>
						<td><label for="ingredients">Ingredientes:</label></td>
						<td><input type="text" name="ingredients"
							value="<%=menuItem.getIngredients()%>" required
							class="input-field"></td>
					</tr>
					<tr>
						<td><label for="type">Tipo:</label></td>
						<td><select name="type" required class="input-field">
								<option value="entrada"
									<%=selected("entrada", menuItem.getType())%>>Entrada</option>
								<option value="principal"
									<%=selected("principal", menuItem.getType())%>>Principal</option>
								<option value="sobremesa"
									<%=selected("sobremesa", menuItem.getType())%>>Sobremesa</option>
						</select></td>
					</tr>
					<tr>
						<td>
							<button onclick="redirectToHome()" class="back-button botao">Página
								Principal</button>

						</td>
						<td>
							<button type="submit" class="back-button botao">Atualizar</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</main>
</body>
</html>

<%!
    // Método auxiliar para simplificar o atributo "selected" no dropdown
    private String selected(String esperado, String atual) {
        return esperado.equals(atual) ? "selected" : "";
    }
%>
