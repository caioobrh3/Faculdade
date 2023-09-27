<!DOCTYPE html>
<html>
<head>
    <title>Calcular Idade</title>
</head>
<body>
    <h1>Calcular Idade Atual</h1>
    <form action="CalcularIdadeServlet" method="get">
        <label for="anoNascimento">Ano de Nascimento:</label>
        <input type="text" id="anoNascimento" name="anoNascimento" required><br><br>
        
        <label for="fezAniversario">Já fez aniversário este ano?</label>
        <input type="radio" id="sim" name="fezAniversario" value="sim" required>
        <label for="sim">Sim</label>
        <input type="radio" id="nao" name="fezAniversario" value="nao" required>
        <label for="nao">Não</label><br><br>
        
        <input type="submit" value="Calcular Idade">
    </form>
</body>
</html>
