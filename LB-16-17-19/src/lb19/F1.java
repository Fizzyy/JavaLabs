package lb19;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class F1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        var error = req.getParameter("error");
        if (error != null && error.equals("1")) {
            resp.getWriter().write("Catched by filter F1");
        } else {
            ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse)resp);
            responseWrapper.setNewHeader("FirstFilter", "F1");
            chain.doFilter(req, responseWrapper.getResponse());
        }
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("Filter F1 has been attempted");
    }

}
