<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resultado da Tabuada</title>
</head>
<body>
    <h1>Resultado da Tabuada</h1>
    
    <%
        int numero = Integer.parseInt(request.getParameter("numero"));
    %>
    
    <table border="1">
        <tr>
            <th>Operação</th>
            <th>Resultado</th>
        </tr>
        
        <%
            for (int i = 1; i <= 10; i++) {
                int resultado = numero * i;
        %>
        
        <tr>
            <td><%= numero %> x <%= i %></td>
            <td><%= resultado %></td>
        </tr>
        
        <%
            }
        %>
    </table>
    
    <br>
    <a href="tabuada.jsp">Voltar</a>
</body>
</html>
