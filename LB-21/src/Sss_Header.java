import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Sss_Header", urlPatterns = "/Sss_Header")
public class Sss_Header extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var valueX = Integer.parseInt(request.getHeader("Value-x"));
        var valueY = Integer.parseInt(request.getHeader("Value-y"));
        var task = Integer.parseInt(request.getHeader("task"));

        if (task == 4) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        var headersSum = valueX + valueY;
        response.setHeader("Value-Z", String.valueOf(headersSum));
    }
}
