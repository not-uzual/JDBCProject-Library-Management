import java.sql.*;

public class DatabaseConnection {
    private static final String url = "jdbc:mysql://localhost:3306/library";
    private static final String user = "root";
    private static final String password = "letsgo";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
