package aulaAtvdd;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/idadeServlet")
public class IdadeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recebendo dados do formulário
        int anoNascimento = Integer.parseInt(request.getParameter("anoNascimento"));
        boolean aniversarioFeito = request.getParameter("aniversarioFeito") != null;
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");

        // Criando objeto Pessoa
        Pessoa pessoa = new Pessoa(nome, endereco, anoNascimento, aniversarioFeito);

        // Calculando a idade
        int anoAtual = java.time.Year.now().getValue();
        int idade = anoAtual - pessoa.getAnoNascimento();
        if (!pessoa.isAniversarioFeito()) {
            idade--;
        }

        // Configurando a resposta
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Idade e Dados da Pessoa</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Idade: " + idade + " anos</h1>");
        out.println("<h2>Dados da Pessoa:</h2>");
        out.println("<p>Nome: " + pessoa.getNome() + "</p>");
        out.println("<p>Endereço: " + pessoa.getEndereco() + "</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
