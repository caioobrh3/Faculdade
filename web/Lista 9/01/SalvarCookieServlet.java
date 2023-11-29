import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SalvarCookieServlet")
public class SalvarCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String idade = request.getParameter("idade");
        String universidade = request.getParameter("universidade");
        String curso = request.getParameter("curso");
        String cargo = request.getParameter("cargo");
        String empresa = request.getParameter("empresa");
        String corFavorita = request.getParameter("cor_favorita");

        Cookie nomeCookie = new Cookie("nome", nome);
        Cookie idadeCookie = new Cookie("idade", idade);
        Cookie universidadeCookie = new Cookie("universidade", universidade);
        Cookie cursoCookie = new Cookie("curso", curso);
        Cookie cargoCookie = new Cookie("cargo", cargo);
        Cookie empresaCookie = new Cookie("empresa", empresa);
        Cookie corFavoritaCookie = new Cookie("cor_favorita", corFavorita);

        nomeCookie.setMaxAge(24 * 60 * 60);
        idadeCookie.setMaxAge(24 * 60 * 60);
        universidadeCookie.setMaxAge(24 * 60 * 60);
        cursoCookie.setMaxAge(24 * 60 * 60);
        cargoCookie.setMaxAge(24 * 60 * 60);
        empresaCookie.setMaxAge(24 * 60 * 60);
        corFavoritaCookie.setMaxAge(24 * 60 * 60);

        response.addCookie(nomeCookie);
        response.addCookie(idadeCookie);
        response.addCookie(universidadeCookie);
        response.addCookie(cursoCookie);
        response.addCookie(cargoCookie);
        response.addCookie(empresaCookie);
        response.addCookie(corFavoritaCookie);

        response.sendRedirect("ExibirCookies.jsp");
    }
}
