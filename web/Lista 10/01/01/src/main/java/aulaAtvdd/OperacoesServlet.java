package aulaAtvdd;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/operacoes")
public class OperacoesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int num3 = Integer.parseInt(request.getParameter("num3"));

        OperacoesMatematicas operacoes = new OperacoesMatematicas(num1, num2, num3);

        request.setAttribute("operacoes", operacoes);
        request.getRequestDispatcher("/aula02.jsp").forward(request, response);
    }
}