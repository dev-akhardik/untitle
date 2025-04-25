public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("This is a test for the database connection.");
        UserDao userDao = new UserDao();
        userDao.createUser("Anurag", "test@gmail.com");
        System.out.println("User created successfully! from App class");
    }
}
