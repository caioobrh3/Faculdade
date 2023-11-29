import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CriarSessaoServlet")
public class CriarSessaoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        String sessionId = session.getId();

        Date creationTime = new Date(session.getCreationTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date lastAccessTime = new Date(session.getLastAccessedTime());

        Integer accessCount = (Integer) session.getAttribute("accessCount");
        if (accessCount == null) {
            accessCount = 1;
        } else {
            accessCount++;
        }
        session.setAttribute("accessCount", accessCount);

        response.getWriter().println("ID da Sessão: " + sessionId + "<br>");

        response.getWriter().println("Data e Hora de Criação da Sessão: " + dateFormat.format(creationTime) + "<br>");

        response.getWriter().println("Data e Hora do Último Acesso à Sessão: " + dateFormat.format(lastAccessTime) + "<br>");

        if (accessCount == 5) {
            response.getWriter().println("Parabéns! Esta é a sua 5ª sessão.<br>");
        }

        session.invalidate();
    }
}
