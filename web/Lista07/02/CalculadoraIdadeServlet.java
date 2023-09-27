import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalcularIdadeServlet")
public class CalcularIdadeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int anoNascimento = Integer.parseInt(request.getParameter("anoNascimento"));
        String fezAniversario = request.getParameter("fezAniversario");

        Calendar calendario = Calendar.getInstance();
        int anoAtual = calendario.get(Calendar.YEAR);

        int idade;
        if ("sim".equals(fezAniversario)) {
            idade = anoAtual - anoNascimento;
        } else {
            idade = anoAtual - anoNascimento - 1;
        }

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Idade Atual</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Sua Idade Atual</h1>");
        out.println("<p>Ano de Nascimento: " + anoNascimento + "</p>");
        out.println("<p>Já fez aniversário este ano? " + fezAniversario + "</p>");
        out.println("<p>Idade Atual: " + idade + " anos</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
