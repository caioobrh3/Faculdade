<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Usuário</title>
</head>
<body>
    <h1>Cadastro de Novo Usuário</h1>
    <form action="SalvarCookieServlet" method="post">
        <h2>Informações Pessoais</h2>
        Nome: <input type="text" name="nome"><br>
        Idade: <input type="text" name="idade"><br>

        <h2>Informações Acadêmicas</h2>
        Universidade: <input type="text" name="universidade"><br>
        Curso: <input type="text" name="curso"><br>

        <h2>Informações Profissionais</h2>
        Cargo: <input type="text" name="cargo"><br>
        Empresa: <input type="text" name="empresa"><br>

        <h2>Cor Favorita</h2>
        Cor: <input type="text" name="cor_favorita"><br>

        <input type="submit" value="Salvar">
    </form>
</body>
</html>
