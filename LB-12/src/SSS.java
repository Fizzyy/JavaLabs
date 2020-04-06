import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SSS extends HttpServlet {
    public SSS() {
        System.out.println("---- SSS constructor has been called ----");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("---- init has been called ----");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("---- destroy has been called ----");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("---- service has been called ----");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        response.getWriter().write("POST-method");
        if (firstName != "" & lastName != "") {
            response.getWriter().write("\n\nFirstname: " + firstName + " Lastname: " + lastName);
        } else {
            response.getWriter().write("\n\nFirstname or Lastname is empty :(");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("Method: " + request.getMethod());
        response.getWriter().write("\nAddress: " + request.getRemoteAddr());
        response.getWriter().write("\nName: " + request.getServerName());

        String queryString = request.getQueryString();
        response.getWriter().write("\nFull GET-string: " + request.getRequestURL() + (queryString != null ? "?" + queryString : ""));

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        if (firstName != null && lastName != null) {
            response.getWriter().write("\n\nFirstname: " + firstName + " Lastname: " + lastName);
        }
    }
}
