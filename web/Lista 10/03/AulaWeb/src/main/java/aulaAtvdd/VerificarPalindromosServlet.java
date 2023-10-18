package aulaAtvdd;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/verificarPalindromos")
public class VerificarPalindromosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String palavra1 = request.getParameter("palavra1");
        String palavra2 = request.getParameter("palavra2");

        boolean palindromo1 = verificarPalindromo(palavra1);
        boolean palindromo2 = verificarPalindromo(palavra2);

        Palavra palavra1Obj = new Palavra(palavra1, palindromo1);
        Palavra palavra2Obj = new Palavra(palavra2, palindromo2);

        request.setAttribute("palavra1", palavra1Obj);
        request.setAttribute("palavra2", palavra2Obj);
        request.getRequestDispatcher("/aula02.jsp").forward(request, response);
    }

    private boolean verificarPalindromo(String palavra) {
        String palavraInvertida = new StringBuilder(palavra).reverse().toString();
        return palavra.equalsIgnoreCase(palavraInvertida);
    }
}
