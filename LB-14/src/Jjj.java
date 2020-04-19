import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "Jjj", urlPatterns = "/Jjj")
public class Jjj extends HttpServlet {
    private final String MainUrl = "http://localhost:8082/lb14";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = null;

        if (LocalDateTime.now().getHour() >= 1 && LocalDateTime.now().getHour() <= 6) {
            postMethod = new PostMethod(MainUrl + "/night.jsp?task=13");
        } else if (LocalDateTime.now().getHour() >= 7 && LocalDateTime.now().getHour() <= 11) {
            postMethod = new PostMethod(MainUrl + "/morning.jsp?task=13");
        } else if (LocalDateTime.now().getHour() >= 12 && LocalDateTime.now().getHour() <= 17) {
            postMethod = new PostMethod(MainUrl + "/afternoon.jsp?task=13");
        } else if (LocalDateTime.now().getHour() >= 18) {
            postMethod = new PostMethod(MainUrl + "/evening.jsp?task=13");
        }
        if (postMethod != null) {
            httpClient.executeMethod(postMethod);

            if (postMethod.getStatusCode() == HttpStatus.SC_OK) {
                System.out.println("POST method has been performed successfully!");

                for (var oneByte:postMethod.getResponseBody()) {
                    response.getWriter().write(oneByte);
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var task = request.getParameter("task");
        switch (Integer.parseInt(task)) {
            case 11:
                RequestDispatcher requestDispatcher = null;
                if (LocalDateTime.now().getHour() >= 1 && LocalDateTime.now().getHour() <= 6) {
                    requestDispatcher = request.getRequestDispatcher("/night.jsp");
                } else if (LocalDateTime.now().getHour() >= 7 && LocalDateTime.now().getHour() <= 11) {
                    requestDispatcher = request.getRequestDispatcher("/morning.jsp");
                } else if (LocalDateTime.now().getHour() >= 12 && LocalDateTime.now().getHour() <= 17) {
                    requestDispatcher = request.getRequestDispatcher("/afternoon.jsp");
                } else if (LocalDateTime.now().getHour() >= 18) {
                    requestDispatcher = request.getRequestDispatcher("/evening.jsp");
                }
                if (requestDispatcher != null) requestDispatcher.forward(request, response);
                break;
            case 12:
                HttpClient httpClient = new HttpClient();
                GetMethod getMethod = null;

                if (LocalDateTime.now().getHour() >= 1 && LocalDateTime.now().getHour() <= 6) {
                    getMethod = new GetMethod(MainUrl + "/night.jsp?task=12");
                } else if (LocalDateTime.now().getHour() >= 7 && LocalDateTime.now().getHour() <= 11) {
                    getMethod = new GetMethod(MainUrl + "/morning.jsp?task=12");
                } else if (LocalDateTime.now().getHour() >= 12 && LocalDateTime.now().getHour() <= 17) {
                    getMethod = new GetMethod(MainUrl + "/afternoon.jsp?task=12");
                } else if (LocalDateTime.now().getHour() >= 18) {
                    getMethod = new GetMethod(MainUrl + "/evening.jsp?task=12");
                }
                if (getMethod != null) {
                    httpClient.executeMethod(getMethod);

                    if (getMethod.getStatusCode() == HttpStatus.SC_OK) {
                        System.out.println("GET method has been performed successfully!");

                        for (var oneByte:getMethod.getResponseBody()) {
                            response.getWriter().write(oneByte);
                        }
                    }
                }

                break;
        }
    }
}
