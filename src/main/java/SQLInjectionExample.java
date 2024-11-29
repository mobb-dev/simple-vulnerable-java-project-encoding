import java.sql.*;

public class SQLInjectionExample {
    public static void main(String[] args) throws SQLException {
        // ó
        String userInputA = args[1];
        // ó
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
        // ó
        String query = "SELECT * FROM users WHERE username = '" + userInputA + "';";
        // ó
        Statement stmt = con.createStatement();
        // ó
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");

            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }
    }
}
