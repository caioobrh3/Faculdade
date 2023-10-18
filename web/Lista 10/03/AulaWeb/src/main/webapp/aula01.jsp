<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Verificar Palíndromos</title>
</head>
<body>
    <h1>Verificar Palíndromos</h1>
    <form action="verificarPalindromos" method="POST">
        Primeira Palavra: <input type="text" name="palavra1" required><br>
        Segunda Palavra: <input type="text" name="palavra2" required><br>
        <input type="submit" value="Verificar">
    </form>
</body>
</html>
