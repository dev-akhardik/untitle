public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("This is a test for the database connection.");
        UserDao userDao = new UserDao();
        userDao.createUser("Anurag", "test@gmail.com", "password123");
        System.out.println("User created successfully! from App class");

        userDao.getUser(1);

        userDao.updateUser(1, "Tannu", "test@gmail.tannu", "tan123");

        userDao.deleteUser(2);
    }
}
