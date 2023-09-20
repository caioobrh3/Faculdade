<!DOCTYPE html>
<html>
<head>
    <title>Formul�rio JSP</title>
</head>
<body>
    <h1>Formul�rio JSP</h1>
    
    <form action="resultado.jsp" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required><br><br>
        
        <label for="estadoCivil">Estado Civil:</label>
        <select id="estadoCivil" name="estadoCivil">
            <option value="Solteiro(a)">Solteiro(a)</option>
            <option value="Casado(a)">Casado(a)</option>
        </select><br><br>
        
        <label for="faixaEtaria">Faixa Et�ria:</label>
        <select id="faixaEtaria" name="faixaEtaria">
            <option value="3 a 10 anos">3 a 10 anos</option>
            <option value="11 a 25 anos">11 a 25 anos</option>
            <option value="36 a 55 anos">36 a 55 anos</option>
            <option value="56 a 100 anos">56 a 100 anos</option>
        </select><br><br>
        
        <input type="submit" value="Enviar">
    </form>
    
    <p>Autor: Seu Nome Completo</p>
    <p>Palavras-chave: web, Seu N�mero de Matr�cula, Atividades sobre JSP</p>
</body>
</html>
