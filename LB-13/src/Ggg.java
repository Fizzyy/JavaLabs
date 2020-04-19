import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.json.simple.JSONObject;

@WebServlet(name = "Ggg", urlPatterns = "/Ggg")
public class Ggg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var task = request.getParameter("task");
        switch(Integer.parseInt(task)) {
            case 2: {
                response.getWriter().write("Post-Ggg forwarding");
                break;
            }
            case 66: {
                response.getWriter().write("POST-Ggg redirection");
                break;
            }
            case 10: {
                sendResponseToHttpClient(request, response);
                break;
            }
        };
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var task = request.getParameter("task");
        switch (Integer.parseInt(task)) {
            case 1: {
                response.getWriter().write("Get-Ggg");
                break;
            }
            case 4: {
                System.out.println("--- Forwarding to HTML page ---");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/secondPage.html");
                requestDispatcher.forward(request, response);
                break;
            }
            case 8: {
                response.sendRedirect("/AS_ydsth/secondPage.html");
                break;
            }
            case 9: {
                sendResponseToHttpClient(request, response);
                break;
            }
        }
    }

    private void sendResponseToHttpClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("surname", surname);
        response.setContentType("application/json");
        response.getWriter().write(jsonObject.toJSONString());
        response.getWriter().flush();
    }
}
