package lb19;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class F3 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse)resp);
        var error = req.getParameter("error");

        if (error != null && error.equals("3")) {
            var firstFilterHeader = responseWrapper.getHeader("FirstFilter");
            var secondFilterHeader = responseWrapper.getHeader("SecondFilter");

            resp.setContentType("text/html");
            resp.getWriter().write("<p>FirstFilter: " + firstFilterHeader + "</p>");
            resp.getWriter().write("<p>SecondFilter: " + secondFilterHeader + "</p>");
            resp.getWriter().write("<p><b>Catched by filter F3</b></p>");
        } else {
            responseWrapper.setNewHeader("ThirdFilter", "F3");
            chain.doFilter(req, responseWrapper.getResponse());
        }
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("Filter F3 has been attempted!");
    }

}
