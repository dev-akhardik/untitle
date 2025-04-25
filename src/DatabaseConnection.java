import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseConnection {
  public static Connection getConnection() throws SQLException {

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");

      String url = "jdbc:mysql://localhost:3306/test_db";
      String username = "root";
      String password = "admin";

      return DriverManager.getConnection(url, username, password);

    }

    catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      throw new SQLException("Unable to connect to the database", e);
    }
  }
}
