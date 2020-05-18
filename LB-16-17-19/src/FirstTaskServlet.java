import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FirstTaskServlet", urlPatterns = "/firstServlet")
public class FirstTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = null;

        var urln = request.getParameter("urln");
        switch (Integer.parseInt(urln)) {
            case 1:
                String htmlUri = servletContext.getInitParameter("URL1");
                getMethod = new GetMethod(htmlUri);
                httpClient.executeMethod(getMethod);

                if (getMethod.getStatusCode() == HttpStatus.SC_OK) {
                    for (var bytee:getMethod.getResponseBody()) {
                        response.getWriter().write(bytee);
                    }
                }
                break;
            case 2:
                String servletUri = servletContext.getInitParameter("URL2");
                getMethod = new GetMethod(servletUri);
                httpClient.executeMethod(getMethod);

                if (getMethod.getStatusCode() == HttpStatus.SC_OK) {
                    for (var bytee:getMethod.getResponseBody()) {
                        response.getWriter().write(bytee);
                    }
                }
                break;
            default:
                response.getWriter().write("parameter URLn not found");
                break;
        }
    }
}
