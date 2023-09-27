import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ConcatenarDadosServlet")
public class ConcatenarDadosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nome = request.getParameter("nome");
        String estadoCivil = request.getParameter("estadoCivil");
        String faixaEtaria = request.getParameter("faixaEtaria");

        String resultado = "Nome: " + nome + "<br>";
        resultado += "Estado Civil: " + estadoCivil + "<br>";
        resultado += "Faixa Etária: " + faixaEtaria;

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Dados Concatenados</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Dados Concatenados</h1>");
        out.println("<p>" + resultado + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
