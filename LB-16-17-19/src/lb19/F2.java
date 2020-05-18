package lb19;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class F2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse)resp);
        var error = req.getParameter("error");
        var request = (HttpServletRequest)req;

        if (error != null && error.equals("2")) {
            var firstFilterHeader = responseWrapper.getHeader("FirstFilter");
            resp.getWriter().write("URI: " + request.getRequestURI());

            resp.setContentType("text/html");
            if (firstFilterHeader != null) {
                resp.getWriter().write("<p>FirstFilter: " + firstFilterHeader + "</p>");
            }
            resp.getWriter().write("<p><b>Catched by filter F2</b></p>");
        } else {
            responseWrapper.setNewHeader("SecondFilter", "F2");
            chain.doFilter(req, responseWrapper.getResponse());
        }
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("Filter F2 has been attempted!");
    }

}
