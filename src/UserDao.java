import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
  public void createUser(String username, String email) {
    String query = "INSERT INTO users (username, email) VALUES (?, ?)";

    try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, email);
      preparedStatement.executeUpdate();
      System.out.println("User created successfully! from UserDao class");
    }

    catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
