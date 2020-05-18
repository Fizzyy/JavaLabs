import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Bbb", urlPatterns = "/Bbb")
public class Bbb extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var firstParameter = request.getParameter("firstValue");
        var secondParameter = request.getParameter("secondValue");
        var thirdParameter = request.getParameter("thirdValue");

        var firstCustomHeader = request.getHeader("FirstCustomHeader");
        var secondCustomHeader = request.getHeader("SecondCustomHeader");
        var thirdCustomHeader = request.getHeader("ThirdCustomHeader");

        response.addHeader("FirstCustomHeader", firstCustomHeader);
        response.addHeader("SecondCustomHeader", secondCustomHeader);
        response.addHeader("ThirdCustomHeader", thirdCustomHeader);
        response.addHeader("FirstBbbHeader", "value1");
        response.addHeader("SecondBbbHeader", "value2");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstValue", firstParameter);
        jsonObject.put("secondValue", secondParameter);
        jsonObject.put("thirdValue", thirdParameter);
        response.setContentType("application/json");
        response.getWriter().write(jsonObject.toJSONString());
    }
}
