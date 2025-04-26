import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
  public void createUser(String username, String email, String pass) {
    String query = "INSERT INTO users (username, email, pass) VALUES (?,?,?)";

    try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {

      preparedStatement.setString(1, username);
      preparedStatement.setString(2, email);
      preparedStatement.setString(3, pass);
      preparedStatement.executeUpdate();

      System.out.println("User created successfully! from UserDao class");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public ResultSet getUser(int id) {
    String query = "SELECT * FROM users WHERE id = ?";

    try {
      Connection connection = DatabaseConnection.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(query);

      preparedStatement.setInt(1, id);

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        String username = rs.getString("username");
        String email = rs.getString("email");
        String pass = rs.getString("pass");
        System.out.println("Username: " + username + " | Email: " + email + " | Password: " + pass);
      }

      return rs;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public void updateUser(int id, String username, String email, String pass) {
    String query = "UPDATE users SET username = ?, email = ?, pass = ? WHERE id = ?";

    try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {

      preparedStatement.setString(1, username);
      preparedStatement.setString(2, email);
      preparedStatement.setString(3, pass);
      preparedStatement.setInt(4, id);
      preparedStatement.executeUpdate();
      int rowsUpdated = preparedStatement.executeUpdate();

      if (rowsUpdated > 0) {
        System.out.println("User updated successfully! from UserDao class");
      } else {
        System.out.println("No user found with the given ID.");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void deleteUser(int id) {
    String query = "DELETE FROM users WHERE id = ?";

    try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {

      preparedStatement.setInt(1, id);
      int rowsDeleted = preparedStatement.executeUpdate();

      if (rowsDeleted > 0) {
        System.out.println("User deleted successfully! from UserDao class");
      } else {
        System.out.println("No user found with the given ID.");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
