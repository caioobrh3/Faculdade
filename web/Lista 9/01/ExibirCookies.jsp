<!DOCTYPE html>
<html>
<head>
    <title>Dados dos Cookies</title>
</head>
<body>
    <h1>Dados dos Cookies</h1>
    
    <h2>Informações Pessoais:</h2>
    Nome: <%= request.getParameter("nome") %><br>
    Idade: <%= request.getParameter("idade") %><br>
    
    <h2>Informações Acadêmicas:</h2>
    Universidade: <%= request.getParameter("universidade") %><br>
    Curso: <%= request.getParameter("curso") %><br>
    
    <h2>Informações Profissionais:</h2>
    Cargo: <%= request.getParameter("cargo") %><br>
    Empresa: <%= request.getParameter("empresa") %><br>
    
    <h2>Cor Favorita:</h2>
    Cor: <%= request.getParameter("cor_favorita") %><br>
    
    <%-- Define a cor do texto com base na cor favorita salva no cookie --%>
    <%
        String corFavorita = request.getParameter("cor_favorita");
        if (corFavorita != null && !corFavorita.isEmpty()) {
            out.println("<h2 style=\"color: " + corFavorita + "\">Texto colorido de acordo com a cor favorita.</h2>");
        }
    %>
</body>
</html>
