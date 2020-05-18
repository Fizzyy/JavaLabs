import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "Sss_JSON", urlPatterns = "/Sss_JSON")
public class Sss_JSON extends HttpServlet {
    private final int lowBorder = 5;
    private final int highBorder = 10;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var randN = Integer.parseInt((request.getHeader("XRand_n")));
        Random rand = new Random();
        var amountOfNumbers = rand.nextInt(lowBorder + 1) + lowBorder;
        var task = Integer.parseInt(request.getHeader("task"));

        if (task == 4) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        JSONArray randomNumbers = new JSONArray();
        for (int i = 0; i < amountOfNumbers; i++) {
            randomNumbers.add(rand.nextInt(randN + randN) - randN);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("numbers", randomNumbers);

        response.setContentType("application/json");
        response.getWriter().write(jsonObject.toJSONString());
    }
}
