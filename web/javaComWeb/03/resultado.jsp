<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resultado</title>
</head>
<body>
    <h1>Resultado</h1>
    
    <%
        // Obtém os valores enviados pelo formulário
        String nome = request.getParameter("nome");
        String estadoCivil = request.getParameter("estadoCivil");
        String faixaEtaria = request.getParameter("faixaEtaria");
        
        // Concatena as informações
        String resultado = "Nome: " + nome + "<br>";
        resultado += "Estado Civil: " + estadoCivil + "<br>";
        resultado += "Faixa Etária: " + faixaEtaria + "<br>";
    %>
    
    <p><%= resultado %></p>
    
    <br>
    <a href="formulario.jsp">Voltar</a>
</body>
</html>
