import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Aaa", urlPatterns = "/Aaa")
public class Aaa extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod("http://localhost:8080/AS_ydsei/Bbb");

        NameValuePair[] params = {
                new NameValuePair("firstValue", "hello"),
                new NameValuePair("secondValue", "world"),
                new NameValuePair("thirdValue", "headers")
        };

        postMethod.addParameters(params);
        postMethod.addRequestHeader("FirstCustomHeader", "test1");
        postMethod.addRequestHeader("SecondCustomHeader", "test2");
        postMethod.addRequestHeader("ThirdCustomHeader", "test2");

        httpClient.executeMethod(postMethod);

        if (postMethod.getStatusCode() == HttpStatus.SC_OK) {
            var headerNames = postMethod.getResponseHeaders();
            response.setContentType("text/html");

            try {
                var obj = new JSONParser().parse(postMethod.getResponseBodyAsString());
                var jsonObject = (JSONObject)obj;
                var parsedFirstValue = (String)jsonObject.get("firstValue");
                var parsedSecondValue = (String)jsonObject.get("secondValue");
                var parsedThirdValue = (String)jsonObject.get("thirdValue");

                response.getWriter().write("<p>Http parameters</p>");
                response.getWriter().write("<ul>");
                response.getWriter().write("<li>" + "First parameter: " + parsedFirstValue + "</li>");
                response.getWriter().write("<li>" + "Second parameter: " + parsedSecondValue + "</li>");
                response.getWriter().write("<li>" + "Third parameter: " + parsedThirdValue + "</li>");
                response.getWriter().write("</ul>");
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }

            response.getWriter().write("<p>Http headers</p>");
            response.getWriter().write("<ul>");
            for (var headerName:headerNames) {
                response.getWriter().write("<li>" + headerName.getName() + ": " + headerName.getValue() + "</li>");
            }
            response.getWriter().write("</ul>");
        }
    }
}
