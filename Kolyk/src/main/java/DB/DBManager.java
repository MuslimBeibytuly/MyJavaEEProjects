package DB;
import Exceptions.DBException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static Connection connection;
    public static Connection connect()
            throws DBException {
        connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://kolyk.cdijhioblxtq.us-east-2.rds.amazonaws.com:5432/kolyk",
                    username = "postgres", password = "postgres";
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new DBException(e.getMessage());
        }
    }
}
