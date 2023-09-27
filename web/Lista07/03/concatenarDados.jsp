<!DOCTYPE html>
<html>
<head>
    <title>Concatenar Dados</title>
</head>
<body>
    <h1>Concatenar Dados</h1>
    <form action="ConcatenarDadosServlet" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required><br><br>
        
        <label for="estadoCivil">Estado Civil:</label>
        <select id="estadoCivil" name="estadoCivil">
            <option value="solteiro">Solteiro(a)</option>
            <option value="casado">Casado(a)</option>
        </select><br><br>
        
        <label for="faixaEtaria">Faixa Etária:</label>
        <select id="faixaEtaria" name="faixaEtaria">
            <option value="3-10">3 a 10 anos</option>
            <option value="11-25">11 a 25 anos</option>
            <option value="36-55">36 a 55 anos</option>
            <option value="56-100">56 a 100 anos</option>
        </select><br><br>
        
        <input type="submit" value="Concatenar Dados">
    </form>
</body>
</html>
