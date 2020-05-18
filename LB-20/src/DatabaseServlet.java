import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "DatabaseServlet", urlPatterns = "/db")
public class DatabaseServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();

        var db = new DBConnection();
        try {
            db.connectToDB();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var userId = request.getParameter("id");
        var userName = request.getParameter("name");
        var userAge = Integer.parseInt(request.getParameter("age"));

        try {
            CallableStatement callState = DBConnection.connection.prepareCall("{ call AddAndReturnTotalUsers(?, ?, ?, ?) }");
            callState.setString(1,  userId);
            callState.setString(2,  userName);
            callState.setInt(3,  userAge);
            callState.registerOutParameter(4, Types.INTEGER);

            callState.execute();
            var totalUsers = callState.getInt(4);

            response.getWriter().write("Total users in table: " + totalUsers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var type = request.getParameter("type");
        var userId = request.getParameter("user_id");

        response.setContentType("text/html");
        try {
            if (type != null && type.equals("dynamic")) {
                PreparedStatement prepState = DBConnection.connection.prepareStatement("SELECT * FROM TestUsers WHERE Id = ?");
                prepState.setString(1, userId);
                ResultSet resultSet = prepState.executeQuery();

                response.getWriter().write("<html><body>");
                while (resultSet.next()) {
                    String id = resultSet.getString("Id");
                    String name = resultSet.getString("Name");
                    int age = Integer.parseInt(resultSet.getString("Age"));

                    response.getWriter().write("<p>Id: " + id + " Name: " + name + " Age: " + age + "</p>");
                }
                response.getWriter().write("</body></html>");
            } else {
                Statement query = DBConnection.connection.createStatement();
                ResultSet resultSet = query.executeQuery("SELECT * FROM TestUsers");
                response.getWriter().write("<html><body><ul>");

                while (resultSet.next()) {
                    String id = resultSet.getString("Id");
                    String name = resultSet.getString("Name");
                    int age = Integer.parseInt(resultSet.getString("Age"));

                    response.getWriter().write("<p><b>Id:</b> " + id + " <b>Name:</b> " + name + " <b>Age:</b> " + age + "</p>");
                }
                response.getWriter().write("</ul></body></html>");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
