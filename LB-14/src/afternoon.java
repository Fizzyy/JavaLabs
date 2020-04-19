import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "afternoon", urlPatterns = "/afternoon")
public class afternoon extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var task = request.getParameter("task");
        switch (Integer.parseInt(task)) {
            case 7: request.setAttribute("servletMessage","Servlet:Good afternoon!"); break;
        }
    }
}
