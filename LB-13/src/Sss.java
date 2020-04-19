import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@WebServlet(name = "Sss", urlPatterns = "/Sss")
public class Sss extends HttpServlet {
    private final String MainUrl = "http://localhost:8080";
    private final String RedirectUrl = MainUrl + "/AS_ydsth";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equals("POST")) {
            var task = req.getParameter("task");
            switch (Integer.parseInt(task)) {
                case 2: {
                    System.out.println("--- Post method has arrived ---");
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Ggg?task2");
                    requestDispatcher.forward(req, resp);
                    break;
                }
                case 6: {
                    resp.sendRedirect(RedirectUrl + "/Ggg?task=66");
                    break;
                }
                case 10: {
                    var name = req.getParameter("name");
                    var surname = req.getParameter("surname");

                    HttpClient httpClient = new HttpClient();
                    PostMethod postMethod = new PostMethod(RedirectUrl + "/Ggg?task=10");
                    NameValuePair[] pairs = {
                            new NameValuePair("name", name),
                            new NameValuePair("surname", surname)
                    };

                    postMethod.setRequestBody(pairs);
                    httpClient.executeMethod(postMethod);

                    if (postMethod.getStatusCode() == HttpStatus.SC_OK) {
                        responseParser(postMethod.getResponseBodyAsString(), resp);
                    }
                    break;
                }
            }
        }

        super.service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var task = request.getParameter("task");
        switch (Integer.parseInt(task)) {
            case 1: {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Ggg");
                requestDispatcher.forward(request, response);
                break;
            }
            case 3: {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/secondPage.html");
                requestDispatcher.forward(request, response);
                break;
            }
            case 4: {
                System.out.println("--- Forwarding to servlet Ggg ---");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Ggg?task=4");
                requestDispatcher.forward(request, response);
                break;
            }
            case 5: {
                response.sendRedirect(RedirectUrl + "/Ggg?task=1");
                break;
            }
            case 7: {
                System.out.println("Redirect to second page");
                response.sendRedirect(RedirectUrl + "/secondPage.html");
                break;
            }
            case 8: {
                System.out.println("Redirect to Ggg servlet");
                response.sendRedirect(RedirectUrl + "/Ggg?task=8");
                break;
            }
            case 9: {
                var name = request.getParameter("name");
                var surname = request.getParameter("surname");

                HttpClient httpClient = new HttpClient();
                GetMethod getMethod = new GetMethod(RedirectUrl + "/Ggg");
                NameValuePair[] pairs = {
                        new NameValuePair("task","9"),
                        new NameValuePair("name", name),
                        new NameValuePair("surname", surname)
                };

                getMethod.setQueryString(pairs);
                httpClient.executeMethod(getMethod);

                if (getMethod.getStatusCode() == HttpStatus.SC_OK) {
                    responseParser(getMethod.getResponseBodyAsString(), response);
                } else {
                    response.getWriter().write("Not good response...");
                }
                break;
            }
        }
    }

    private void responseParser(String jsonString, HttpServletResponse response) throws ServletException, IOException {
        try {
            Object obj = new JSONParser().parse(jsonString);
            JSONObject jsonObject = (JSONObject)obj;
            var parsedName = (String)jsonObject.get("name");
            var parsedSurname = (String)jsonObject.get("surname");

            response.getWriter().write("Parsed name: " + parsedName);
            response.getWriter().write("\nParsed surname: " + parsedSurname);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
