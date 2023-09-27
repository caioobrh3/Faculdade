import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculadoraServlet")
public class CalculadoraServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int numero1 = Integer.parseInt(request.getParameter("numero1"));
        int numero2 = Integer.parseInt(request.getParameter("numero2"));

        int soma = numero1 + numero2;
        int subtracao = numero1 - numero2;
        int multiplicacao = numero1 * numero2;
        int divisao = numero1 / numero2;
        int resto = numero1 % numero2;

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Resultado</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Resultados</h1>");
        out.println("<p>Número 1: " + numero1 + "</p>");
        out.println("<p>Número 2: " + numero2 + "</p>");
        out.println("<p>Soma: " + soma + "</p>");
        out.println("<p>Subtração: " + subtracao + "</p>");
        out.println("<p>Multiplicação: " + multiplicacao + "</p>");
        out.println("<p>Divisão: " + divisao + "</p>");
        out.println("<p>Resto da Divisão: " + resto + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
