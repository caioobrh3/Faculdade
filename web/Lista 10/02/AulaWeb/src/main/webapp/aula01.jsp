<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculadora de Idade</title>
</head>
<body>
    <h1>Calculadora de Idade</h1>
    <form action="idadeServlet" method="GET">
        Ano de Nascimento: <input type="number" name="anoNascimento" required><br>
        Já fez aniversário este ano? <input type="checkbox" name="aniversarioFeito"><br>
        Nome: <input type="text" name="nome" required><br>
        Endereço: <input type="text" name="endereco" required><br>
        <input type="submit" value="Calcular Idade">
    </form>
</body>
</html>
