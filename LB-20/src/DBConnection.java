import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection connection;
    private final String connectionString = "jdbc:oracle:thin:@192.168.56.102:1521:orcle";

    public void connectToDB() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection(connectionString, "system", "Pa$$w0rd");
        if (connection != null) {
            System.out.println("Connect to db has been performed successfully");
        }
    }
}
