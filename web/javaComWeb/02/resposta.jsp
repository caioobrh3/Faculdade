<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resposta</title>
</head>
<body>
    <h1>Resposta</h1>
    
    <%
        // Obtém a palavra enviada pelo formulário
        String palavra = request.getParameter("palavra");
        // Remove espaços em branco e converte para letras minúsculas para ignorar maiúsculas/minúsculas
        palavra = palavra.replaceAll(" ", "").toLowerCase();
        
        // Verifica se a palavra é um palíndromo
        boolean isPalindromo = true;
        int length = palavra.length();
        for (int i = 0; i < length / 2; i++) {
            if (palavra.charAt(i) != palavra.charAt(length - i - 1)) {
                isPalindromo = false;
                break;
            }
        }
    %>
    
    <p>A palavra "<%= request.getParameter("palavra") %>" <%= isPalindromo ? "é" : "não é" %> um palíndromo.</p>
    
    <br>
    <a href="verificarPalindromo.jsp">Voltar</a>
</body>
</html>
