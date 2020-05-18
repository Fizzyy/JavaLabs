package lb19;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ResponseWrapper extends HttpServletResponseWrapper {
    private HttpServletResponse response;

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
        this.response = response;
    }

    @Override
    public String getHeader(String name) {
        return response.getHeader(name);
    }

    public void setNewHeader(String name, String value) {
        response.setHeader(name, value);
    }

    @Override
    public HttpServletResponse getResponse() {
        return response;
    }
}
